package com.imooc.ltj.lamda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/1/25 23:03
 */
public class Version2Test {
    @Test
    public void filterSkusByCategory(){
        List<Sku> cartSkuList =CartService.getCartSkuList();
        List<Sku> result=CartService.filterSkusByCategory(cartSkuList,SkuCategoryEnum.BOOKS);

        System.out.println(JSON.toJSONString(result,true));
    }
}


