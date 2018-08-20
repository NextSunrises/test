package com.tkrs.test.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


/**
 * @ClassName TestFunctionInterface
 * @Description 函数式接口测试
 * @Author wangchenge
 * @Date 2018/8/10  20:30
 * @Version 1.0
 **/
public class TestFunctionInterface {

    /**
     * 函数式接口就是有且只有一个抽象方法,但是可以有多个非抽象方法的接口
     * 函数式接口可以隐式转换为lambda表达式,友好支持lambda
     * predicate<T>接口是一个函数式接口,接受一个输入参数T,返回一个布尔值结果,用于测试对象是true或false
     * 包含多种默认方法将predicate组合成其他复杂的逻辑(与,或,非)
     */
    @Test
    public void test(){
        //Alt+Enter 导入单个class
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //传递参数
        System.out.println("输出所有数据:");
        eval(list,n->true);
        System.out.println("输出所有偶数");
        eval(list,n -> n%2 ==0);
        System.out.println("输出大于 3 的所有数字:");
        eval(list,n -> n>3);
        //System.out.println(list);

    }
    public void eval(List<Integer> list, Predicate<Integer> predicate){
        /*for(Integer n: list) {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }*/
        list.stream().filter(param -> predicate.test(param)).forEach(System.out::println);
    }
}
