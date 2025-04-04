package com.ruoyi.web.controller.tool;

import java.util.HashMap;

public class AreaTree {
    public static String[] areas = {"东北","华北","西北","华东","西南","华南","华中"};

    public static String[][] provinces = {{"黑龙江","吉林","辽宁"},{"北京","天津","山西","河北","内蒙古"},
            {"陕西","甘肃","青海","宁夏","新疆"},{"上海","江苏","浙江","安徽","福建","江西","山东","台湾"},
            {"四川","贵州","云南","重庆","西藏"},{"广东","广西","海南","香港","澳门"},{"河南","湖北","湖南"}};

    public static HashMap getAreaTree(){
        HashMap[] a = new HashMap[areas.length];
        for (int i = 0; i < areas.length; i++) {
            HashMap<String, String[]> map = new HashMap<>();
            map.put(areas[i], provinces[i]);
            a[i] = map;
        }
        HashMap<String, HashMap[]> map = new HashMap<>();
        map.put("中国",a);
        return map;
    }
    public static String provinceToArea(String province){
        int flag = 0;
        for (int i = 0; i < provinces.length; i++) {
            for (String pName: provinces[i]) {
                if (province.equals(pName))
                {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
            {
                return areas[i];
            }
        }
        return null;
    }
}
