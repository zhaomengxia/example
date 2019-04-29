package com.linln.modules.system.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.linln.modules.system.domain.District;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/4/28 11:42
 */
@Service
public class DistrictServiceImpl {
    //获取行政规划的url
    private String resourceUrl="http://www.mca.gov.cn/article/sj/xzqh/2019/201901-06/201902061009.html";
    //解析资源中的html的className
    private String elementClassName="xl7016597";
    //获取本地资源路径
    private String jsonResource="classpath:districts-201901.json";
    private List<District> districts;

    public DistrictServiceImpl() {loadDistricts();
    }

    public DistrictServiceImpl(String resourceUrl, String elementClassName, String jsonResource) {
        this.resourceUrl = resourceUrl;
        this.elementClassName = elementClassName;
        this.jsonResource = jsonResource;
        this.loadDistricts();
    }
    private void loadDistricts(){
        this.districts =  districtList();
    }

    public List<District> list(){
        return districts;
    }

    public List<District> districtList(){
        //2019年01月中华人民共和国县以上行政区划代码网页
        Document document=null;

        try {
            document= Jsoup.connect(resourceUrl).maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();

            try {
                File file= ResourceUtils.getFile(jsonResource);

                Gson gson=new Gson();

                TypeToken<List<District>> typeToken=new TypeToken<List<District>>(){};

                return gson.fromJson(new FileReader(file),typeToken.getType());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        Elements elements=document.getElementsByClass(elementClassName);
        List<String> strings=elements.eachText();
        assert strings.size()%2==0;
        List<District> districts=new LinkedList<>();
        for (int i=0;i<strings.size();i+=2){
            districts.add(new District(strings.get(i),strings.get(i+1)));
        }
      return processData(districts);
    }

    private List<District> processData(List<District> districts){
       List<District> provinces=new ArrayList<>();

       for (int i=0;i<districts.size();i++){
           District district=districts.get(i);
           String name=district.getName();
           String code=district.getCode();
           if (code.endsWith("0000")){
               //省
               District province=new District();
               provinces.add(province);
               province.setName(name);
               province.setCode(code);
               List<District> cities=new ArrayList<>();
               province.setDistricts(cities);
               if (name.contains("香港")||name.contains("澳门")||name.contains("台湾")){
                   //市
                   District city=new District();
                   List<District> areas=new ArrayList<>();
                   city.setName(name);
                   city.setCode(code);
                   city.setDistricts(areas);
                   cities.add(city);
                   //区
                   District area=new District();
                   area.setName(name);
                   area.setCode(code);
                   areas.add(area);
               }

               if (name.contains("北京")||name.contains("上海")||name.contains("天津")||name.contains("重庆")){
                   //市
                   District city=new District();
                   List<District> areas=new ArrayList<>();
                   city.setName(name);
                   city.setCode(code);
                   //区
                   city.setDistricts(areas);
                   cities.add(city);
                   for (int j=0;j<districts.size();j++){
                       District area=districts.get(j);
                       String areaCode=area.getCode();
                       String areaName=area.getName();
                       if (!code.equals(areaCode)&&areaCode.startsWith(code.substring(0,2))){
                           area.setName(areaName);
                           area.setCode(areaCode);
                           areas.add(new District(areaCode,areaName));
                       }
                   }
               }

               for (int k=0;k<districts.size();k++){
                  District city=districts.get(k);
                  String cityCode=city.getCode();
                  String citeName=city.getName();
                  if (!code.equals(cityCode)&&cityCode.startsWith(code.substring(0,2))&&cityCode.endsWith("00")) {
                      District newCity=new District(cityCode,citeName);
                      List<District> areas=new ArrayList<>();
                      city.setDistricts(areas);
                      cities.add(newCity);
                      for (int a = 0; a < districts.size(); a++) {
                          District area = districts.get(a);
                          String areaCode = area.getCode();
                          String areaName=area.getName();
                          if (!cityCode.equals(areaCode) && areaCode.startsWith(cityCode.substring(0, 4))) {
                              areas.add(new District(areaCode,areaName));
                          }
                      }

                  }
               }
           }

       }
        return provinces;
    }
}
