package com.test.annotationprocessor;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void readFile() {
        String property = System.getProperty("user.dir");
        System.out.println(property);
        String currentPath = "E:\\mystudy\\ModuleAnnotationProcessor\\app\\src\\test\\java\\com\\test\\annotationprocessor\\";
        File file = new File(currentPath, "Test2.java");

        boolean exists = file.exists();
        System.out.println(file.getAbsolutePath() + exists);
        ReadFileUtils.readFileByLines(file);
    }

}