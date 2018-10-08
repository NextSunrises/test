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

    /**
     * wait()方法可以使调用该线程的方法释放共享资源的锁，然后从运行状态退出，进入等待队列，直到再次被唤醒。
     * notify()方法可以随机唤醒等待队列中等待同一共享资源的一个线程，并使得该线程退出等待状态，进入可运行状态
     * notifyAll()方法可以使所有正在等待队列中等待同一共享资源的全部线程从等待状态退出，进入可运行状态
     */
    @Test
    public void test1() {
        Random random = new Random();
        new Thread(() -> {
            synchronized (object) {
                while (flag) {
                    if (i == 10) {
                        flag = false;
//                        break;
                    }else {
                        object.notify();
                        randomNum = random.nextInt();
                        i++;
                        System.out.println("第" + i + "次产生的随机数是:" + randomNum);
                        try {
                        /*wait的作用是使当前执行代码的线程进行等待,
                          将当前线程置入预执行队列,所在代码处停止执行
                          直到接到通知或被中断,在调用wait之前必须获得对象的锁,
                          wait方法会释放锁
                        */
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object) {
                while (flag) {
                    if (i == 10) {
                        flag = false;
//                        break;
                    }
                    /*notify作用是若有多个线程等待,那么线程规划器随机挑选
                    出一个wait的线程,对其发出notify使它等待获取该对象的对象锁
                     */
                    object.notify();
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

