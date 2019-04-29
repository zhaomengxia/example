package com.linln.devtools.generate.utils.district;

import com.linln.modules.system.domain.District;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/4/28 11:40
 */
public class DistrictUtils {
    private static final List<String> SPECIAL_ADMINISTRATIVE_REGION_CODES = Arrays.asList("710000", "810000", "820000");

    private static final List<String> MUNICIPALITY_CITY_CODES = Arrays.asList("110000", "120000", "500000", "310000");

    public static boolean isProvince(District district) {
        String code = district.getCode();
        return code.endsWith("0000");
    }

    public static String toProvinceCode(String code) {
        return code.substring(0, 2) + "0000";
    }

    public static String toCityCode(String code) {
        if (MUNICIPALITY_CITY_CODES.contains(toProvinceCode(code))) {
            return code.substring(0, 2).concat("0000");
        }
        return code.substring(0, 4) + "00";
    }

    public static boolean isCity(District district) {

        if (isMunicipalityCity(district)) {
            return true;
        }

        String code = district.getCode();
        return code.endsWith("00") && !isProvince(district);
    }

    public static boolean isCounty(District district) {
        String code = district.getCode();
        return !code.endsWith("00");
    }


    public static boolean isSpecialRegion(District district) {
        String code = district.getCode();
        return SPECIAL_ADMINISTRATIVE_REGION_CODES.contains(code);

    }

    public static boolean isMunicipalityCity(District district) {
        return MUNICIPALITY_CITY_CODES.contains(district.getCode());
    }


}
