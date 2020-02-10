package com.imooc.ltj.lamda.file;

import org.junit.Test;

import java.io.IOException;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/1/26 16:33
 */
public class FileServiceTest {

    @Test
    public void fileHandle() throws IOException {
        FileService fileService=new FileService();

        fileService.fileHandle("D:\\IDEAWeb\\com-ltj-996\\src\\main\\java\\com\\imooc\\ltj\\lamda\\file\\FileService.java",fileContent -> System.out.println(fileContent));
    }
}
