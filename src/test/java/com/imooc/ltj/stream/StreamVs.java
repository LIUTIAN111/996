package com.imooc.ltj.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.ltj.lamda.cart.CartService;
import com.imooc.ltj.lamda.cart.Sku;
import com.imooc.ltj.lamda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 对比：原始集合操作与Stream集合操作
 *
 * @author LTJ
 * @version 1.0
 * @date 2020/1/27 23:54
 */
public class StreamVs {

    /**
     * 原始集合操作
     */
    @Test
    public void oldCartHandle() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        //打印所有商品
        for (Sku sku : cartSkuList) {
            System.out.println(JSON.toJSONString(sku, true));
        }

        //过滤图书类商品
        List<Sku> notBooksSkuList = new ArrayList<>();

        for (Sku sku : cartSkuList) {
            if (!SkuCategoryEnum.BOOKS.equals(sku.getSkuCategoy())) {
                notBooksSkuList.add(sku);
            }
        }

        //排序
        notBooksSkuList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku o1, Sku o2) {
                if (o1.getTotalPrice() > o2.getTotalPrice()) {
                    return -1;
                } else if (o1.getTotalPrice() < o2.getTotalPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        List<Sku> top2SkuList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            top2SkuList.add(notBooksSkuList.get(i));
        }

        Double money = 0.0;
        for (Sku sku : top2SkuList) {
            money += sku.getTotalPrice();
        }

        List<String> resultSkuNameList = new ArrayList<>();
        for (Sku sku : top2SkuList) {
            resultSkuNameList.add(sku.getSkuName());
        }

        System.out.println("-----------------------------------------------------");
        System.out.println(JSON.toJSONString(resultSkuNameList, true));
        System.out.println("商品总价：" + money);

    }

    /**
     * 以Stream流方式实现需求
     */
    @Test
    public void newCartHandle() {

        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));
        List<String> resultSkuNameList = CartService.getCartSkuList().stream()
                //打印商品
                .peek(sku -> System.out.println(
                        JSON.toJSONString(sku, true)))
                //过滤
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategoy()))
                //排序 默认从小到大0
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .limit(2)
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                .map(sku -> sku.getSkuName())
                //收集
                .collect(Collectors.toList());

        System.out.println("-----------------------------------------------------");
        System.out.println(JSON.toJSONString(resultSkuNameList, true));
        System.out.println("商品总价：" + money.get());
    }
}
