package com.imooc.ltj.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 线程池提供的阻塞队列
 * @author LTJ
 * @version 1.0
 * @date 2020/1/31 23:40
 */
public class QueueTest {

    @Test
    public void arrayBlockingQueueTest() throws InterruptedException {

        /**
         * 基于数组的有界队列
         */
        ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
        for(int i=0;i<20;i++){
            queue.put(i);
            System.out.println("向有界队列添加值："+i);
        }

    }

    @Test
    public void linkedBlockingQueueTest() throws InterruptedException {
        //基于链表的有界阻塞队列
        //当不指定容量时，为无界阻塞队列
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(10);
        for(int i=0;i<20;i++){
            queue.put(i);
            System.out.println("向有界队列添加值："+i);
        }

    }

    @Test
    public void synchronousQueueTest(){
        //同步移交阻塞队列
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        //插入值
        new Thread(
                ()->{
                    try {
                        queue.put(1);
                        System.out.println("插入成功");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();

        //删除值
        new Thread(
                ()->{
                    try {
                        queue.take();
                        System.out.println("删除成功");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
