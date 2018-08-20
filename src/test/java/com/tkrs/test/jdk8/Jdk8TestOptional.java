package com.tkrs.test.jdk8;

import org.junit.Test;

import java.util.Optional;

/**
 * @ClassName Jdk8TestOptional
 * @Description Java Optional类测试 避免空指针
 * @Author wangchenge
 * @Date 2018/8/10  14:17
 * @Version 1.0
 **/
public class Jdk8TestOptional {

    /**
     * Optional类是一个可以为null的容器对象,若值存在则isPresent()方法返回true,调用get()方法会返回该对象
     * Optional是一个容器,可以保存类型T的值,或者仅保存null,optional类的引入很好的解决空指针异常,不用进行显式空值检测
     */
    @Test
    public void testOptional(){
        Integer value1=null;
        Integer value2=new Integer(100);
        //ofNullable如果为非空,返回Optional描述的指定值,否则返回空的Optional
        Optional<Integer> a = Optional.ofNullable(value1);
        System.out.println(a);
        System.out.println(a.isPresent());
        //System.out.println(a.get());  //no value present exception
        //of 返回一个指定非null值的Optional
        Optional<Integer> b = Optional.ofNullable(value2);
        System.out.println(b);
        System.out.println(b.isPresent());
        System.out.println(b.get());
        String str="";
        Optional<String> sss = Optional.ofNullable(str);
        System.out.println(sss);
        System.out.println(sss.isPresent());
        System.out.println(sss.get());
        Integer sum = sum(a, b);
        System.out.println(sum);
    }

    public Integer sum(Optional<Integer> a,Optional<Integer> b){
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());
        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));
        //Optional.get - 获取值，值需要存在
        Integer value2 = b.orElse(new Integer(0));
        return value1 + value2;
    }
}
