package com.imooc.ltj.lamda.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车服务类
 *
 * @author LTJ
 * @version 1.0
 * @date 2020/1/25 22:28
 */
public class CartService {

    /**
     * 加入购物车的商品信息
     */
    private static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(654032, "无人机",
                    4999.00, 1,
                    4999.00, SkuCategoryEnum.ELECTRONICS));

            add(new Sku(654033, "VR一体机",
                    2999.00, 1,
                    2999.00, SkuCategoryEnum.ELECTRONICS));

            add(new Sku(645321, "纯色衬衫",
                    409.00, 3,
                    1227.00, SkuCategoryEnum.CLOTHING));

            add(new Sku(654327, "牛仔裤",
                    528.00, 1,
                    528.00, SkuCategoryEnum.CLOTHING));

            add(new Sku(675489, "跑步机",
                    2699.00, 1,
                    2699.00, SkuCategoryEnum.SPORTS));

            add(new Sku(644564, "Java编程思想",
                    79.80, 1,
                    79.80, SkuCategoryEnum.BOOKS));

            add(new Sku(678678, "Java核心技术",
                    149.00, 1,
                    149.00, SkuCategoryEnum.BOOKS));

            add(new Sku(697894, "算法",
                    78.20, 1,
                    78.20, SkuCategoryEnum.BOOKS));

            add(new Sku(696968, "TensorFlow进阶指南",
                    85.10, 1,
                    85.10, SkuCategoryEnum.BOOKS));
        }
    };

    /**
     * 获取商品信息列表
     *
     * @return
     */
    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     * 找出购物车中所有的电子产品
     *
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filterElectronicsSkus(List<Sku> cartSkuList) {
        List<Sku> electronics = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {
            if (SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCategoy())) {
                electronics.add(sku);
            }
        }
        return electronics;
    }

    /**
     * 根据传入的商品类型参数，找出购物车中同种商品类型的商品列表
     *
     * @param cartSkuList
     * @param category
     * @return
     */
    public static List<Sku> filterSkusByCategory(List<Sku> cartSkuList, SkuCategoryEnum category) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {
            if (category.equals(sku.getSkuCategoy())) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * 支持通过商品类型或总价来过滤商品
     * @param cartSkuList
     * @param category
     * @param totalPrice
     * @param categoryOrPrice true 根据商品信息过滤，false 根据总价过滤商品
     * @return
     */
    public static List<Sku> filterSkus(List<Sku> cartSkuList, SkuCategoryEnum category, Double totalPrice, Boolean categoryOrPrice) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {
            if(categoryOrPrice && category.equals(sku.getSkuCategoy()) || !categoryOrPrice && sku.getTotalPrice()>totalPrice){
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * 根据不同的Sku判断标准，对Sku列表进行过滤
     * @param cartSkuList
     * @param predicate 不同的Sku判断标准策略
     * @return
     */
    public static List<Sku> filterSkus(List<Sku> cartSkuList,SkuPredicate predicate){
        List<Sku> result = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {
            if(predicate.test(sku)){
                result.add(sku);
            }
        }
        return result;
    }
}
