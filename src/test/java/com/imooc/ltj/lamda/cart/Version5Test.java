package com.imooc.ltj.lamda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * 通过匿名类筛选商品
 * @author LTJ
 * @version 1.0
 * @date 2020/1/26 14:06
 */
public class Version5Test {
    @Test
    public void filterSkus(){
        List<Sku> cartSkuList =CartService.getCartSkuList();
        List<Sku> result=CartService.filterSkus(cartSkuList, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getSkuPrice()>1000;
            }
        });

        System.out.println(JSON.toJSONString(result,true));
    }
}
