package com.test.annotationprocessor;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUtils {
    public static final String printWriterStr="printWriter";
    public static void readFileByLines(String fileName) {
        readFileByLines(new File(fileName));
    }
    public static void readFileByLines(File file) {
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if(tempString==null||tempString.replace(" ","").length()<=0){
                    continue;
                }
                // 显示行号
                System.out.println(printWriterStr+".println(\""+tempString+"\");");
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}