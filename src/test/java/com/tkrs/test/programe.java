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
     * @Description 快速排序,
     * @Date 17:38 2018/8/18
     * @Param
     * @return
     **/
}
