package com.usc;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
class Help {
    public static String[] getParams(String[] args) {
        if (args.length > 0) {
            File file = new File(args[0]);
            List<String> params = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath()), "UTF-8"));//构造一个BufferedReader类来读取文件
                String s;
                while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                    params.add(s);
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int sz = params.size();
            args = new String[sz];
            for (int i = 0; i < sz; i++) args[i] = params.get(i);
        }

        return args;
    }
}

public class Solution {

    public static void main(String[] args) {
        args = Help.getParams(args);
    }


}






