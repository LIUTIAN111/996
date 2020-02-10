package com.imooc.ltj.lamda.cart;

/**
 * Sku选择谓词接口
 * @author LTJ
 * @version 1.0
 * @date 2020/1/26 13:35
 */
public interface SkuPredicate {

    /**
     * 选择判断标准
     * @param sku
     * @return
     */
    boolean test(Sku sku);
}
