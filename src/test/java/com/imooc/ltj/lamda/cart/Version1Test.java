package com.imooc.ltj.lamda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/1/25 22:51
 */


public class Version1Test {

    @Test
    public void  filterElectronicsSkus(){
        List<Sku> cartSkuList =CartService.getCartSkuList();
        List<Sku> result=CartService.filterElectronicsSkus(cartSkuList);

        System.out.println(JSON.toJSONString(result,true));
    }
}
