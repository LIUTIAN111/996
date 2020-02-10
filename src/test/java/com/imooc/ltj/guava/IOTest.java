package com.imooc.ltj.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 演示如何使用流(Source)与汇(Sink)来对文件进行常用操作
 * @author LTJ
 * @version 1.0
 * @date 2020/1/31 15:28
 */
public class IOTest {

    @Test
    public void copyFile() throws IOException {

        /**
         * 创建对应的源（Source）与汇（Sink）
         */
        CharSource charSource = Files.asCharSource(new File("D:\\IDEAWeb\\com-ltj-996\\src\\test\\java\\com\\imooc\\ltj\\guava\\ImmutableTest.java"), Charsets.UTF_8);

        CharSink charSink = Files.asCharSink(new File("C:\\Users\\12162\\Desktop\\新建文件夹\\3.txt"), Charsets.UTF_8);

        /**
         * 拷贝
         */
        charSource.copyTo(charSink);
    }
}
