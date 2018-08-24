package com.tkrs.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName programe
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/8/18  15:18
 * @Version 1.0
 **/
public class programe {
    /**
     * @return
     * @Author wcg
     * @Description 打印九九乘法口诀
     * @Date 15:19 2018/8/18
     * @Param
     **/
    @Test
    public void printMsg() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "  ");
            }
            System.out.println();
        }
    }

    @Test
    /**
     * @Author wcg
     * @Description 打印九九乘法口诀2
     * @Date 15:19 2018/8/18
     * @Param
     * @return
     **/
    public void printMsg2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.stream().forEach(num -> {
            list2.stream().forEach(num2 -> {
                if (num >= num2) {
                    System.out.print(num + "*" + num2 + "=" + num * num2 + "  ");
                }
            });
            System.out.println();
        });
    }

    /***
     * @Author wcg
     * @Description 二分法查找数组中的元素
     * @Date 15:34 2018/8/18
     * @Param
     * @return
     **/
    @Test
    public void findEleByHalfSearch() {
        int[] array = {1, 10, 9, 109, 888, 3, 6, 2, 8, 99, 1111, 98, 7, 5};
        Arrays.sort(array);
        System.out.println(array);
        Arrays.stream(array).forEach(System.out::println);//输出排序后的数组
        int searchVal = 888;
        int index = search(array, searchVal);
        System.out.println("index:" + index);
        int index2 =search1(array,searchVal,0,array.length - 1);
        System.out.println("index2:"+index2);
    }

    //非递归查询
    public int search(int[] arr, int n) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n) {
                return mid;
            }
            if (arr[mid] < n) {
                start = mid + 1;
            }
            if (arr[mid] > n) {
                end = mid - 1;
            }
        }
        return -1;
    }
    //递归
    public static int search1(int[] arr, int n, int begin, int end) {
        int mid = (begin + end) / 2;
        if (n < arr[begin] || n > arr[end] || arr[begin] > arr[end]) {
            return -1;
        }
        if (arr[mid] < n) {
            return search1(arr, n, mid + 1, end);
        } else if (arr[mid] > n) {
            return search1(arr, n, begin, mid - 1);
        } else
            return mid;
    }
    
    /***
     * @Author wcg
     * @Description 冒泡排序,一种简单的排序算法,名字的由来是因为越小的元素会经由交换慢慢浮到数列的顶端,
     * 由小到大排序
     * @Date 16:57 2018/8/18
     * @Param 
     * @return 
     **/
    @Test
    public void testOrder1(){
        int[] array={10,9,8,7,6,5,4,3,2,1,3,4,11,100,24,46,98};
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    /*交换两个数的位置*/
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        Arrays.stream(array).forEach(System.out::println);
    }
    /***
     * @Author wcg
     * @Description 快速排序,通过一趟排序将待排序记录分割成独立的两部分,其中一部分记录的关键字均比另一部分关键字小,
     * 则分别对这两部分继续进行排序,直到整个序列有效
     * 把整个序列看作一个数组,第0个位置看作中轴,和最后一个比,小则交换,大则不做任何处理,交换后再和小的那端比,小不交换,
     * 大则交换,循环往复，一趟排序完成，左边就是比中轴小的，右边就是比中轴大的，然后再用分治法，分别对这两个独立的数组进行排序\
     * 不稳定,多个相同的值的相对位置可能会在算法结束时产生变动
     * 即假定数组第一个元素为中轴元素,分别从高位和低位开始与中轴元素比较,小的数值移到中轴左侧,大的数值移到中轴右侧,
     * 再将第一个元素放入中轴位置,然后再递归对中轴两边的元素进行排序即可
     * 快速排序是被认为在同数量级的排序方法中平均性能最好的,但当初始序列按关键码有序或基本有序时反而退化为冒泡排序,
     * 通常以三者取中法选取基准记录,即将排序区间的两个端点与中点三个记录关键码居中的调整作为支点记录
     * 快速排序是一个不稳定的排序方法
     * @Date 17:38 2018/8/18
     * @Param
     * @return
     **/
    @Test
    public void testOrder2(){
        int[] numbers ={3,8,2,10,4,5,7,9,6,12,234,345,666,1,11,33,22,20,1};
        //i=0,j=18-1=17,key=numbers[0]=3作为关键元素,从17开始向前搜索,找到第一个小的元素numbers[13]
        // ,交换得到{1,8,2,10,4,5,7,9,6,12,234,345,666,3,11,33,22,20}
        quickSort(numbers, 0, numbers.length-1);
        System.out.println("======================");
        Arrays.stream(numbers).forEach(System.out::println);
        System.out.println(numbers.length);
    }

    /**
     * @param numbers 带排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public void quickSort(int[] numbers, int low, int high) {
        if(low<high){
            int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
            System.out.print("middle:"+middle+"===>");
            Arrays.stream(numbers).forEach(number->System.out.print(number+","));
            System.out.println();
            quickSort(numbers, low, middle-1);   //对低字段表进行递归排序
            quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }
    }

    /**
     * @param numbers  带查找数组
     * @param low 开始位置
     * @param high 结束位置
     * @return  中轴所在位置
     */
    public int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low]; //数组的第一个作为中轴
        while(low < high)
        {//{3,8,2,10,4,5,7,9,6,12,234,345,666,1,11,33,22,20,1}
            while(low < high && (numbers[high] > temp || numbers[high]==temp) )
            {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while(low < high && numbers[low] < temp)
            {
                low++;
            }
            numbers[high] = numbers[low] ; //比中轴大的记录移到高端
        }
        numbers[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    }

    /***
     * @Author wcg
     * @Description 选择排序,在要排序的一组数中,选出最小的一个数与第一个位置的数交换,然后在剩下的数中再找最小的
     * 与第二个位置的数交换,如此循环到倒数第二个数和最后一个数比较为止
     * @Date 11:02 2018/8/22
     * @Param
     * @return
     **/
    @Test
    public void testOrder3(){
        int[] numbers={33,1,22,44,88,14};
        int temp;//用于交换值的中间变量
        for(int i=0;i<numbers.length;i++){
            int k=i;//k用于表示记录第i个最小值的下标
            for(int j = i; j < numbers.length ; j++){
                if(numbers[j]<numbers[k]){
                    k=j;
                }
            }
            temp= numbers[i];
            numbers[i]=numbers[k];
            numbers[k]=temp;
        }
        Arrays.stream(numbers).forEach(number->System.out.print(number+","));
    }
    
    /***
     * @Author wcg
     * @Description 插入排序,从第一个元素开始,此元素可以认为已经排序,取出下一个元素,在已经排序的元素序列中从后向前扫描
     * 若该元素大于新元素,将该元素移到下一位置,一直重复,直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中,一直重复即可
     * @Date 14:09 2018/8/22
     * @Param 
     * @return 
     **/
    @Test
    public void testOrder4(){
        int[] numbers={45,23,77,1,89,9,5,99,3};
        int temp,j;//用于交换的中间变量
        for (int i=0;i<numbers.length;i++){
            temp=numbers[i];
            for(j=i;j>0 && temp < numbers[j-1];j--){
                numbers[j]=numbers[j-1];
            }
            numbers[j]=temp;
        }
        Arrays.stream(numbers).forEach(number->System.out.print(number+","));
    }

    /***
     * @Author wcg
     * @Description   希尔算法
     * @Date 18:58 2018/8/22
     * @Param 
     * @return 
     **/
}
