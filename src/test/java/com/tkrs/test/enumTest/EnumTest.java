package com.tkrs.test.enumTest;

import org.junit.Test;

/**
 * @ClassName EnumTest
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/10/22  15:11
 * @Version 1.0
 **/
public class EnumTest {

    @Test
    public void test1(){
        Color color = Color.BLUE;
        switch (color){
            case RED : System.out.println(color.getIndex());break;
            case GREEN : System.out.println("2");break;
            case BLUE : System.out.println(color.getIndex());break;
            case YELLOW : System.out.println("4");break;
            case BLACK : System.out.println("5");break;
            case WHITE : System.out.println("6");break;
        }
        for(Color ccc:Color.values()){
            System.out.println(ccc.toString());
        }
        int ordinal = color.ordinal();
        System.out.println("==="+ordinal);
    }

    @Test
    public void test2(){
        for (Food.Dessert dessertEnum : Food.Dessert.values()) {
            System.out.print(dessertEnum + "  ");
        }
        for (Food.Coffee coffee : Food.Coffee.values()) {
            System.out.print(coffee + "  ");
        }
        Food food = Food.Dessert.CAKE;
        System.out.println(food);
        food = Food.Coffee.BLACK_COFFEE;
        System.out.println(food);
        String sss=String.valueOf(Food.Coffee.BLACK_COFFEE);
        System.out.println(sss);
        System.out.println(Food.Coffee.BLACK_COFFEE.name());
    }

}
