package com.imooc.ltj.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 集合工具類
 * @author LTJ
 * @version 1.0
 * @date 2020/1/31 0:29
 */
public class SetsTest {

    /**
     * Sets工具類的常用方法
     * 并集/交集/差集/分解集合中的所有子集/求两个集合的笛卡尔积
     * <p>
     * Lists工具类的常用方法
     * 反转/拆分
     */

    private static final Set SET1 = Sets.newHashSet(1, 2, 3, 4);
    private static final Set SET2 = Sets.newHashSet(4, 5, 6);

    /**
     * 并集
     */
    @Test
    public void union() {
        Set<Integer> set = Sets.union(SET1, SET2);

        System.out.println(set);
    }


    /**
     * 交集
     */
    @Test
    public void intersection() {
        Set<Integer> set = Sets.intersection(SET1, SET2);

        System.out.println(set);
    }

    /**
     * 差集 A-B
     */
    @Test
    public void difference() {
        Set<Integer> set = Sets.difference(SET1, SET2);

        System.out.println(set);

        //相对差集
        set = Sets.symmetricDifference(SET1, SET2);
        System.out.println(set);
    }


    /**
     * 求一个集合的所有子集
     */
    @Test
    public void powerSet() {
        Set<Set<Integer>> powerSet = Sets.powerSet(SET1);

        System.out.println(JSON.toJSONString(powerSet));
    }

    /**
     * 计算两个集合的笛卡尔积
     */
    @Test
    public void cartesianProduct() {
        Set<List<Integer>> product = Sets.cartesianProduct(SET1, SET2);

        System.out.println(JSON.toJSONString(product));
    }


    /**
     * 拆分集合
     */
    @Test
    public void partition() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);

        //按size个数拆分集合
        List<List<Integer>> partition = Lists.partition(list, 3);

        System.out.println(JSON.toJSONString(partition));
    }


    /**
     * 反转集合
     */
    @Test
    public void reverse(){
        LinkedList<Integer> list = Lists.newLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Lists.reverse(list);

        System.out.println(list);
    }

}
