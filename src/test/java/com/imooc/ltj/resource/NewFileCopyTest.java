package com.imooc.ltj.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * try-with-resource关闭资源
 * @author LTJ
 * @version 1.0
 * @date 2020/1/29 14:22
 */
public class NewFileCopyTest {

    @Test
    public void copyTest(){
        String originUrl = "D:\\IDEAWeb\\com-ltj-996\\src\\test\\java\\com\\imooc\\ltj\\resource\\FileCopyTest.java";
        String targetUrl = "C:\\Users\\12162\\Desktop\\新建文件夹\\2.txt";

       try(
               FileInputStream fileInputStream = new FileInputStream(originUrl);
               FileOutputStream fileOutputStream = new FileOutputStream(targetUrl)

               ){
           int content;
           while((content=fileInputStream.read())!=-1){
               fileOutputStream.write(content);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

}
