package com.imooc.ltj.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.ltj.lamda.cart.CartService;
import com.imooc.ltj.lamda.cart.Sku;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 常见预定义收集器使用
 * @author LTJ
 * @version 1.0
 * @date 2020/1/28 16:00
 */
public class StreamCollector {

    @Test
    public void toList(){
        List<Sku> list= CartService.getCartSkuList();

        List<Sku> result=list.stream()
                .filter(sku->sku.getTotalPrice()>100)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(result,true));
    }

    @Test
    public void toGroup(){
        List<Sku> list= CartService.getCartSkuList();

        Map<Object,List<Sku>> group=list.stream().collect(Collectors.groupingBy(sku->sku.getSkuCategoy()));
        System.out.println(JSON.toJSONString(group,true));
    }

    @Test
    public void partition(){
        List<Sku> list= CartService.getCartSkuList();
        Map<Boolean,List<Sku>> partition=list.stream().collect(Collectors.partitioningBy(sku -> sku.getTotalPrice()>1000));
        System.out.println(JSON.toJSONString(partition,true));
    }
}


