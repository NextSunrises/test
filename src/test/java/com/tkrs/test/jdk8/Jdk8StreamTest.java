package com.tkrs.test.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @ClassName Jdk8StreamTest
 * @Description Java 8 API 添加了一个新的抽象称为流Stream,以一种声明的方式处理数据
 * @Author wangchenge
 * @Date 2018/8/10  14:57
 * @Version 1.0
 **/
public class Jdk8StreamTest {

    /**
     * Stream 采用一种类似用SQL语句从数据库查询数据的方式提供对java集合运算和表达的高阶抽象
     * 流在管道中传输,并且可以在管道的节点上进行处理,如筛选,排序,聚合等
     * 流Stream是一个来自数据源的元素队列并支持聚合操作,元素是特定类型的对象,形成一个队列,stream不会存储元素,按需计算
     * 数据流的来源可以是集合,数组,I/o channel,产生器generator等
     * 聚合操作 类似SQL语句一样的操作,比如filter,map,reduce,find,match,sorted
     * stream的一大特点是数据源本身可以是无限的
     */
    @Test
    public void testStream(){
        //stream为集合创建串行流,  parallelStream()为集合创建并行流
        List<String> stringList = Arrays.asList("a", "b", "c","", "abcds", "efg", "kil","");
        //filter过滤掉空元素，并将剩下的元素收集
        List<String> filtered = stringList.stream().filter(a -> !a.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
        //Stream foreach迭代流中的每个数据,输出十个随机数,limit用于获取指定数量的流
        Random random=new Random();
        random.ints().limit(10).forEach(System.out::println);
        //map方法 用于映射每个元素到对应的结果,以下代码片段使用map输出了元素对应的平方数
        List<Integer> integers = Arrays.asList(1, 2, 11,3, 4, 5, 6, 7, 8, 9, 10,2);
        List<Integer> collect = integers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(collect);
        //sorted 对流进行排序
        List<Integer> numbers = Arrays.asList(1, 5, 8, 3, 13,2, 6, 4, 7, 0, 1,9);
        List<Integer> sortedList = numbers.stream().map(i -> i * i).distinct().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        //collectors类实现了很多归约操作,如将流转换成集合和聚合元素。collectors可用于返回列表或字符串
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
        //统计,产生统计结果的收集器
        List<Integer> numList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numList.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("最大值:"+stats.getMax());
        System.out.println("最小值:"+stats.getMin());
        System.out.println("和："+stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

    }
    
    /**
     * @Author wcg
     * @Description 测试并行流程序
     * 使用并行遍历方式时,数据被拆分成多个段,其中每一个都在不同的线程中处理,然后将结果一起输出
     * 并行操作依赖于Java7中引入的Fork/Join框架来拆分任务和加速处理过程
     * parallelStream其实就是一个并行执行的流,通过默认的ForkJoinPool提高多线程任务速度（平行处理）
     * @Date 17:27 2018/8/10
     * @Param []
     * @return void
     **/
    @Test
    public void testParallel(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //平行操作得到的有可能是任意的顺序
        numbers.parallelStream().forEach(System.out::println);
        System.out.println("=================================");
        //forEachOrdered 是按原来的Stream中的数据顺序处理,若有过滤，排序等操作时forEachOrdered会
        // 试着平行化处理,然后最终以原数据顺序处理,因此有序处理使用forEachOrdered可能会或完全失去平行化的一些优势
        //
        numbers.parallelStream().forEachOrdered(System.out::println);
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(string -> !string.isEmpty()).count();
        System.out.println("count:"+count);
    }
}
