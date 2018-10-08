package multiThread;

import org.junit.Test;

import java.util.Random;

/**
 * @ClassName TestMultiThread
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/10/8  13:48
 * @Version 1.0
 **/
public class TestMultiThread {

    static int randomNum = 0;
    static Object object = new Object();
    static boolean flag = true;
    static int i = 0;

    @Test
    public void test1() throws InterruptedException {
        Random random = new Random();
        new Thread(() -> {
            synchronized (object) {
                while (flag) {
                    if (i == 10) {
                        flag = false;
                    }else {
                        object.notifyAll();
                        randomNum = random.nextInt();
                        System.out.println("第" + i + "次产生的随机数是:" + randomNum);
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object) {
                while (flag) {
                    if (i == 10) {
                        flag = false;
                    }
                    object.notifyAll();
                    System.out.println("第" + i + "次读取到的随机数是:" + randomNum);
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}

