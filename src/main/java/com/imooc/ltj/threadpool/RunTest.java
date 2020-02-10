package com.imooc.ltj.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/2/5 13:55
 */
public class RunTest {

    @Test
    public void submitTest() throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService threadPool= Executors.newCachedThreadPool();

        //利用submit提交任务
        Future<Integer> future = threadPool.submit(
                () -> {
                    Thread.sleep(1000L * 10);
                    return 2 * 5;
                }
        );

        /**
         * 阻塞方法，直到任务有返回值,才向下执行
         */
        Integer integer = future.get();

        System.out.println("执行结果："+integer);

    }

    @Test
    public void executeTest() throws InterruptedException {
        //创建线程池
        ExecutorService threadPool=Executors.newCachedThreadPool();

        // 利用execute方法提交任务，没有返回结果
        threadPool.execute(
                ()->{

                    try {
                        Thread.sleep(1000L*10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Integer num=5*2;
                    System.out.println("执行结果："+num);
                }
        );

        Thread.sleep(1000L*1000);
    }
}
