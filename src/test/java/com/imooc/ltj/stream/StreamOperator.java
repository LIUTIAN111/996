package com.imooc.ltj.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.ltj.lamda.cart.CartService;
import com.imooc.ltj.lamda.cart.Sku;
import com.imooc.ltj.lamda.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

/**
 * 演示流的各种操作
 *
 * @author LTJ
 * @version 1.0
 * @date 2020/1/28 13:32
 */
public class StreamOperator {

    List<Sku> list;

    @Before
    public void init() {
        list = CartService.getCartSkuList();
    }

    @Test
    public void filterTest() {
        list.stream()
                .filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategoy()))
                .forEach(item -> {
                    System.out.println(JSON.toJSONString(item, true));
                });
    }

    /**
     * map的使用：将一个元素替换成另一个元素
     */
    @Test
    public void mapTest() {
        list.stream()
                .map(sku -> sku.getSkuName())//映射 用SkuName 替换 Sku对象
                .forEach(item -> {
                    System.out.println(JSON.toJSONString(item, true));
                });
    }

    /**
     * flatMap的使用:将一个对象转换成流
     */
    @Test
    public void flatMapTest() {
        list.stream()
                .flatMap(sku ->
                        Arrays.stream(sku.getSkuName().split(""))
                )
                .forEach(item -> {
                    System.out.println(JSON.toJSONString(item, true));
                });
    }

    /**
     * peek的使用：对流中的元素进行遍历操作，不会销毁流元素
     */
    @Test
    public void peekTest() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(item -> {
                    System.out.println(JSON.toJSONString(item, true));
                });
    }

    /**
     * sort的使用：对流中的元素进行排序，可以选择自然排序或指定排序规则
     */
    @Test
    public void sortTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(item -> {
                    System.out.println(JSON.toJSONString(item, true));
                });
    }

    /**
     * distinct的使用：对流元素去重
     */
    @Test
    public void distinctTest() {
        list.stream()
                .map(sku -> sku.getSkuCategoy())
                .distinct()
                .forEach(item -> {
                    System.out.println(JSON.toJSONString(item, true));
                });
    }

    /**
     * skip使用：跳过指定个数的元素
     */
    @Test
    public void skipTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(item -> {
                    System.out.println(JSON.toJSONString(item, true));
                });
    }

    /**
     * limit的使用：截断前N条记录
     */
    @Test
    public void limitTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                //skip+limit 可以实现集合的分页
                .limit(3)
                .forEach(item -> {
                    System.out.println(JSON.toJSONString(item, true));
                });
    }

    /**
     *allMatch使用：所有匹配
     */
    @Test
    public void allMatchTest() {
        boolean match = list.stream()
                .allMatch(sku -> sku.getTotalPrice() > 1000);
        System.out.println(match);
    }

    /**
     * anyMatch使用：任意匹配
     */
    @Test
    public void anyMatchTest() {
        boolean match = list.stream()
                .anyMatch(sku -> sku.getTotalPrice() > 1000);
        System.out.println(match);
    }

    /**
     * noneMatch使用：没有匹配
     */
    @Test
    public void noneMatchTest(){
        boolean match = list.stream()
                .noneMatch(sku -> sku.getTotalPrice() > 1000);
        System.out.println(match);
    }

    /**
     * 找到第一个
     */
    @Test
    public void findFirstTest() {
        Optional<Sku> optionalSku=list.stream()
                .findFirst();
        System.out.println(JSON.toJSONString(optionalSku.get(),true));
    }

    /**
     * 找到任意一个
     */
    @Test
    public void findAnyTest() {
        Optional<Sku> optionalSku=list.stream()
                .findAny();
        System.out.println(JSON.toJSONString(optionalSku.get(),true));
    }

    @Test
    public void maxTest(){
        OptionalDouble optionalDouble=list.stream()
                .mapToDouble(Sku::getTotalPrice)
                .max();
        System.out.println(optionalDouble.getAsDouble());
    }

    @Test
    public void minTest(){
        OptionalDouble optionalDouble=list.stream()
                .mapToDouble(Sku::getTotalPrice)
                .min();
        System.out.println(optionalDouble.getAsDouble());
    }

    @Test
    public void countTest(){
        long count=list.stream().count();
        System.out.println(count);
    }
}
