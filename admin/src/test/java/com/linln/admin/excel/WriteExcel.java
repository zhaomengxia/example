package com.linln.admin.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.linln.modules.system.domain.Two;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/6/14 16:06
 */
public class WriteExcel {

    public static void main(String[] args) throws IOException {
        excel();
    }

    public static void excel() throws IOException {
        //文件输出位置
        OutputStream outputStream = new FileOutputStream("D:\\huankeyun\\1438\\test.xls");
        ExcelWriter excelWriter = EasyExcelFactory.getWriter(outputStream);
        //写仅有一个Sheet的Excel文件，此场景较为通用
        Sheet sheet = new Sheet(1, 0, Two.class);
        //第一个sheet名称
        sheet.setSheetName("第一个sheet");


        Table table=new Table(1);
        //动态添加表头
        table.setHead(writeExcel2());
        //自定义表格样式
        table.setTableStyle(createStyle());
        //写数据到Writer上下文中
        //参数1：创建要写入的模型数据
        //参数2：要写入的目标 sheet
//        excelWriter.write(createModelList(), sheet);
        //像表格中写数据
        excelWriter.write1(createDynamicModelList(),sheet,table);
        //合并单元格
        excelWriter.merge(5,6,3,4);
        //将上下文中的最终输出流写入到指定文件中
        excelWriter.finish();
        //关闭流
        outputStream.close();
    }

    /**
     * 最简单的导出
     * @return
     */
    public static List<Two> createModelList() {
        List<Two> twos = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Two two = Two.builder().title("标题1" + i).remark("zhao").build();
            twos.add(two);
        }
        return twos;
    }
    /**
     * 设置 自由自定义组合的复杂表头
     * @return
     */
    public static List<List<String>> writeExcel2(){

        List<List<String>> head=new ArrayList<>();

        List<String> headCoulumn1=new ArrayList<>();

        List<String> headCoulumn2=new ArrayList<>();
        List<String> headCoulumn3=new ArrayList<>();
        List<String> headCoulumn4=new ArrayList<>();
        List<String> headCoulumn5=new ArrayList<>();
        headCoulumn1.add("First");
        headCoulumn1.add("First");
        headCoulumn1.add("First");

        headCoulumn2.add("Second");
        headCoulumn2.add("Second");
        headCoulumn2.add("Second");

        headCoulumn3.add("Third");
        headCoulumn3.add("Third");
        headCoulumn3.add("Third");

        headCoulumn4.add("Fourth");
        headCoulumn4.add("Fifth");
        headCoulumn4.add("Six");

        headCoulumn5.add("First");
        headCoulumn5.add("Second");
        headCoulumn5.add("Third");

        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        head.add(headCoulumn4);
        head.add(headCoulumn5);
        return head;

    }

    public static List<List<Object>> createDynamicModelList(){
        /**
         * 所有行数据
         */
        List<List<Object>> rows=new ArrayList<>();
        for (int i=0;i<10;i++){
            List<Object> row=new ArrayList<>();
            row.add("a"+i);
            row.add("b"+i);
            row.add("c"+i);
            row.add("d"+i);
            row.add("eee");
            rows.add(row);
        }
        return rows;
    }

    /**
     * 自定义表头及内容样式
     * @return
     */
    public static TableStyle createStyle(){
        TableStyle tableStyle=new TableStyle();
        //设置表头样式
        Font headFont=new Font();
        //加粗
        headFont.setBold(true);
        //字体大小
        headFont.setFontHeightInPoints((short)14);
        headFont.setFontName("楷体");

        tableStyle.setTableHeadFont(headFont);

        tableStyle.setTableHeadBackGroundColor(IndexedColors.RED);


        Font contentFont=new Font();

        contentFont.setBold(false);

        contentFont.setFontHeightInPoints((short)10);

        contentFont.setFontName("宋体");

        tableStyle.setTableContentFont(contentFont);
        tableStyle.setTableContentBackGroundColor(IndexedColors.GREEN);
        return tableStyle;

    }

    public class Down {
        @GetMapping("/a.htm")
        public void cooperation(HttpServletRequest request, HttpServletResponse response) throws IOException {

            ServletOutputStream out = response.getOutputStream();

            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);

            String fileName = new String(("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");

            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("第一个sheet");
             writer.write0(writeExcel2(), sheet1);
            writer.finish();
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" +fileName+ ".xlsx");
            out.flush();
        }
    }
}

