package com.imooc.ltj.lamda.cart;

/**
 *  对Sku的商品总价大于2000的判断标准
 * @author LTJ
 * @version 1.0
 * @date 2020/1/26 13:59
 */
public class SkuTotalPricePredicate implements SkuPredicate {
    @Override
    public boolean test(Sku sku) {
        return sku.getTotalPrice() > 2000;
    }
}
