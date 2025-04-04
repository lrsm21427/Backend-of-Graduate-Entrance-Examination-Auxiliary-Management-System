package com.ruoyi.web.controller.tool;

import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonRunner {
    public JSONObject run(String url,String attrs,String userName,String password) {
        try {
            String[] a = new String[]{"python", url, attrs, userName, password};
            Process proc = Runtime.getRuntime().exec(a);// 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            String ret = "";
            while ((line = in.readLine()) != null) {
                ret += line;
            }
            if (ret != "") {
                JSONObject jo = JSONObject.parseObject(ret);
                in.close();
                proc.destroy();
                return jo;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
