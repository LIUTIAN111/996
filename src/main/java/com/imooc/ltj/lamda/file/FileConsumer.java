package com.imooc.ltj.lamda.file;

/**
 * 文件处理函数式接口
 * @author LTJ
 * @version 1.0
 * @date 2020/1/26 15:40
 */
@FunctionalInterface
public interface FileConsumer {
    /**
     * 函数式接口抽象方法
     * @param fileContent 文件内容字符串
     */
    void fileHandler(String fileContent);
}
