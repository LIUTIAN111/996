package com.imooc.ltj.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/1/29 13:55
 */
public class FileCopyTest {

    @Test
    public void copyTest() {
        /**
         * 1、创建输入输出流
         * 2、执行文件拷贝
         * 3、关闭流
         */
        //定义输入路径和输出路径
        String originUrl = "D:\\IDEAWeb\\com-ltj-996\\src\\test\\java\\com\\imooc\\ltj\\resource\\FileCopyTest.java";
        String targetUrl = "C:\\Users\\12162\\Desktop\\新建文件夹\\1.txt" +
                "";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(originUrl);

            fileOutputStream = new FileOutputStream(targetUrl);

            int content;

            while ((content = fileInputStream.read()) != -1) {
                fileOutputStream.write(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            //关闭流资源
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
