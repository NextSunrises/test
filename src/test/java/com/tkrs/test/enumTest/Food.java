package com.tkrs.test.enumTest;

/**
 * @InterfaceName Food
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/11/5  10:14
 * @Version 1.0
 **/
public interface Food {
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum Dessert implements Food {
        FRUIT, CAKE, GELATO
    }
}

