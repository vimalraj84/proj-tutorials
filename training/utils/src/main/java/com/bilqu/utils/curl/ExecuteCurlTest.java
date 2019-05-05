package com.bilqu.utils.curl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteCurlTest {

    public static void main(String[] args) {

        String username = "admin";
        String password = "admin";
        String url = "http://162.216.52.217:9999/mule/applications";
        String path = "/";
        String Content_Type = "application/json";
        String charset = "utf-8";

//        String[] command = { "curl", "-u", username + ":" + password, "-X", "POST", "-F", "cmd=unlockPage", "-F",
//                "path=" + path, "-F", "_charset_="+charset, url };

        String[] command = { "curl","-X", "GET", url };

        ProcessBuilder process = new ProcessBuilder(" curl -s http://162.216.52.217:9999/mule/applications");
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            String result = builder.toString();
            System.out.print(result);

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
    }
}
