package com.tkrs.test.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @ClassName Jdk8TestMethodInvoke
 * @Description 测试方法引用,把方法当作参数传入stream内部,使stream的每个元素都传入到该方法里面执行
 * @Author wangchenge
 * @Date 2018/8/11  9:15
 * @Version 1.0
 **/
public class Jdk8TestMethodInvoke {
    /**
     * 方法引用通过方法的名字来指向一个方法,使语言的构造更加紧凑简洁,减少冗余代码,方法引用使用一对冒号::
     * jdk8接口Iterable默认实现foreach方法,调用接口Consumer内的accept方法,执行传入的方法参数
     */
    @Test
    public void test(){
        //构造器引用：它的语法是Class::new
        final Car car = Car.create(Car::new);
        System.out.println(car);
        List<Car> cars = Arrays.asList(car);
        //静态方法引用:Class::static_method
        cars.forEach(Car::collide);
        //特定类的任意对象的方法引用,语法是Class::method  方法不允许有参数
        cars.forEach(Car::repair);
        cars.forEach(car1->car1.repair());
        //特定对象的方法引用:语法是instance::method
        Car car123 = Car.create(Car::new);
        cars.forEach(car123::follow);

    }
}
/*@FunctionalInterface
interface Supplier<T>{
    T get();
}*/
class Car {
    //Supplier 是jdk1.8的接口,可以和lamda一起使用
    public static Car create(final Supplier<Car> supplier){
            return supplier.get();
    }
    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }
    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }
    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}
