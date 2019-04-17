package com.linln.devtools.generate.utils;

import org.junit.Test;

import java.nio.file.FileAlreadyExistsException;

/**
 * @author 小笨笨
 * @date 2018/10/28
 */
public class GenerateUtilTest {

    @Test
    public void generateFile() {
        try {
            GenerateUtil.generateFile("C:/Users/LINLN/Desktop/qq/aa.txt", "12212\n15544");
        } catch (FileAlreadyExistsException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }
}