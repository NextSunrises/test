package com.tkrs.test.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @ClassName: Jdk8Test
 * @Description: 测试jdk1.8新特性, jdk1.8是java语言开发的一个主要版本, 于14年3月发布Java8
 * 支持函数式编程,新的JavaScript引擎,新的日期API,新的Stream API等
 * @Author wcg
 * @date 2018年8月8日
 */

public class Jdk8LambdaTest {

    /**
     * @param
     * @return void    返回类型
     * @throws
     * @Title: sortListWithJdk7
     * @Description: jdk7排序list集合
     */
    @Test
    public void sortListWithJdk7() {
        System.out.println("========java 7排序语法");
        List<String> nameList = new ArrayList<>();
        nameList.add("Google ");
        nameList.add("Runoob ");
        nameList.add("Taobao ");
        nameList.add("Baidu ");
        nameList.add("Sina ");
        Collections.sort(nameList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println(nameList);
    }

    /**
     * @param
     * @return void    返回类型
     * @throws
     * @Title: sortListWithJdk8
     * @Description: jdk8排序list集合
     */
    @Test
    public void sortListWithJdk8() {
        System.out.println("========java 8 排序语法");
        List<String> nameList = new ArrayList<>();
        nameList.add("Google ");
        nameList.add("Runoob ");
        nameList.add("Taobao ");
        nameList.add("Baidu ");
        nameList.add("Sina ");
        //这里其实就是lambda表达式,将函数作为一个方法的参数
//        Collections.sort(nameList, (s1, s2) -> s1.compareTo(s2));
        Collections.sort(nameList, Comparator.comparing(String::toString));//参数1为排序元素类型,参数2为排序的key
//		Collections.sort(nameList, (s1,s2) -> {return s1.compareTo(s2);});
        System.out.println(nameList);
    }

    /**
     * @param
     * @return void    返回类型
     * @throws
     * @Title: testLambda
     * @Description:测试jdk1.8 lambda表达式作用, 允许把函数作为一个方法的参数(函数作为参数传递进方法)
     * 可以称之为闭包,可以理解为推动jdk1.8发布的最重要新特性
     * 表达式的语法格式:(parameters) -> expression 或  (parameters) -> {statements;}
     * 重要特征:(1)可选类型声明:不需要声明参数类型,编译器可以统一识别参数值;
     * (2)可选参数圆括号,一个参数无需定义圆括号,但多个参数需要定义圆括号;
     * (3)可选大括号,若只包含一个语句,就不需要使用大括号;
     * (4)可选返回关键字,若主体只有一个表达式返回值,则编译器会自动返回值,大括号需要指定明表达式返回一个数值
     */
    @Test
    public void testLambda() {
        //主要用来定义行内执行的方法类型接口,避免使用匿名方法的麻烦,给予java强大的函数化的编程力
        //在lambda表达式内部只能引用标记了final的外层局部变量,不能修改在域外定义的局部变量,
        //lambda表达式的局部变量可以不用声明为final,但是必须不可被后面的代码修改,隐性final,且不允许声明
        //同局部变量同名的参数或者局部变量
        MathOperation addition = (a, b) -> {
            return a + b;
        };
        MathOperation subtraction = (int a, int b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;
        System.out.println("10+5=" + operate(10, 5, addition));
        System.out.println("10-5=" + operate(10, 5, subtraction));
        System.out.println("10*5=" + operate(10, 5, multiplication));
        System.out.println("10/5=" + operate(10, 5, division));
        System.out.println(addition.operation(10, 2));
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
    
    /**
     * @Author wcg
     * @Description  java8方法实现 多重比较排序
     * @Date 19:56 2018/8/9
     * @Param []
     * @return void
     **/
    @Test
    public void testCompare(){
        List<Employee> list=new ArrayList<>();
        Employee smith=new Employee();
        smith.setAge(20);
        smith.setDeptNo("a");
        smith.setEmployeeId("1");
        smith.setSalary("5000");
        smith.setSex("MALE");
        list.add(smith);
        Employee alan=new Employee();
        alan.setAge(22);
        alan.setDeptNo("b");
        alan.setEmployeeId("2");
        alan.setSalary("6000");
        alan.setSex("FEMALE");
        list.add(alan);
        Employee xiaoming=new Employee();
        xiaoming.setAge(30);
        xiaoming.setDeptNo("c");
        xiaoming.setEmployeeId("3");
        xiaoming.setSalary("9000");
        xiaoming.setSex("MALE");
        list.add(xiaoming);
        Employee xiaohong=new Employee();
        xiaohong.setAge(33);
        xiaohong.setDeptNo("c");
        xiaohong.setEmployeeId("4");
        xiaohong.setSalary("8000");
        xiaohong.setSex("FEMALE");
        list.add(xiaohong);
        list.sort(Comparator.comparing(Employee::getDeptNo).thenComparing(Employee::getSalary));
        for(Employee employee:list){
            System.out.println(employee.getEmployeeId());
        }
        //ctrl+alt+v为eclipse中的ctrl+2+l,即根据左边表达式填写右边
    }



}
