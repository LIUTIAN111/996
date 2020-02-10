package com.imooc.ltj.lamda.cart;

/**
 * 对Sku的商品类型为图书类的判断标准
 * @author LTJ
 * @version 1.0
 * @date 2020/1/26 13:52
 */
public class SkuBooksCategoryPredicate implements SkuPredicate {

    @Override
    public boolean test(Sku sku) {
        return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategoy());
    }
}
