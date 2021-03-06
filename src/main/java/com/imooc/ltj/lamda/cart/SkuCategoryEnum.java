package com.imooc.ltj.lamda.cart;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/1/25 22:33
 */
public enum SkuCategoryEnum {

    CLOTHING(10,"服装类"),
    ELECTRONICS(20,"数码类"),
    SPORTS(30,"运动类"),
    BOOKS(40,"图书类");

    private Integer code;

    private String name;

    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
