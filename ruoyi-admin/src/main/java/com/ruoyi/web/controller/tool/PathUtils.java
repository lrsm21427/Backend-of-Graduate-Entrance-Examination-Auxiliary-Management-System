package com.ruoyi.web.controller.tool;

import com.ruoyi.common.utils.spring.SpringUtils;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.IOException;

public class PathUtils {

    public static String getModelPath() throws IOException {
//        InputStream inputStream = new FileInputStream("src/main/resources/application.yml");
//        Map<String,Object> map = new HashMap<>();
//        Yaml yaml = new Yaml();
//        map = yaml.load(inputStream);
//        return (String) map.get("MODEL_PATH");
        Environment env = SpringUtils.getBean(Environment.class);
        return env.getProperty("MODEL_PATH");
    }

    public static String[] getSqlInfo() throws IOException {


//        InputStream inputStream = new FileInputStream("src/main/resources/application.yml");
//        Yaml yaml = new Yaml();
//        Map<String, Object> map = yaml.load(inputStream);
//        Map<String, Object> spring = (Map) map.get("spring");
//        Map<String, Object> profiles = (Map) spring.get("profiles");
//        InputStream sqlApplication = null;
//        if ("development".equals(profiles.get("active"))) {
//            sqlApplication = new FileInputStream("src/main/resources/application-development.yml");
//        } else {
//            sqlApplication = new FileInputStream("src/main/resources/application-production.yml");
//        }
//        Map<String, Object> sqlMap = yaml.load(sqlApplication);
//        Map<String, Object> springSql = (Map) sqlMap.get("spring");
//        Map<String, Object> datasource = (Map) springSql.get("datasource");
//
//        return new String[]{String.valueOf(datasource.get("username")), String.valueOf(datasource.get("password"))};
        Environment env = SpringUtils.getBean(Environment.class);
        return new String[]{env.getProperty("spring.datasource.druid.master.username"), env.getProperty("spring.datasource.druid.master.password")};

    }

}
