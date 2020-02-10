package com.imooc.ltj.lamda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/1/26 0:04
 */
public class Version3Test {
    @Test
    public void filterSkus(){
        List<Sku> cartSkuList =CartService.getCartSkuList();
        List<Sku> result=CartService.filterSkus(cartSkuList,SkuCategoryEnum.BOOKS,500.00,true);

        System.out.println(JSON.toJSONString(result,true));
    }
}
