package com.imooc.ltj.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不可变集合用法
 *
 * @author LTJ
 * @version 1.0
 * @date 2020/1/30 17:31
 */
public class ImmutableTest {

    public static void test(List<Integer> list) {
        list.remove(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> newList = Collections.unmodifiableList(list);

        test(newList);

        System.out.println(newList);
    }

    public void immutable() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        /**
         * 构建不可变集合的三种方式
         */

        //通过已存在的集合构建
        ImmutableSet<Integer> newList = ImmutableSet.copyOf(list);

        //通过初始值，直接创建不可变集合
        ImmutableSet<Integer> immutableSet = ImmutableSet.of(1, 2, 3);

        //以builder的方式创建
        immutableSet.builder()
                .add(1)
                .addAll(Sets.newHashSet(2,3))
                .add(4)
                .build();
    }
}
