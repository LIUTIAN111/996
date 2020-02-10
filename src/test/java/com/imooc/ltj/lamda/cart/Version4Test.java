package com.imooc.ltj.lamda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/1/26 13:23
 */
public class Version4Test {

    @Test
    public void filterSkus(){
        List<Sku> cartSkuList =CartService.getCartSkuList();
        List<Sku> result=CartService.filterSkus(cartSkuList,new SkuTotalPricePredicate());

        System.out.println(JSON.toJSONString(result,true));
    }
}
