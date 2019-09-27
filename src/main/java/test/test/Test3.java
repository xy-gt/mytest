package test.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/29 15:07
 */
public class Test3 {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("a");
        new Test4().test4(list);
        System.out.println(list);
    }

}
class Test4{
    public void test4(List list) {

        list.clear();
        list.add("b");
        System.out.println("清除list的值");



        new Thread(() -> {
            synchronized (this) {
                System.out.println("子线程1开始");
                try {
                    this.wait();
                    System.out.println("wait1 等待了5秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }).start();

        new Thread(() -> {
            synchronized (this) {
                System.out.println("子线程3开始");
                try {
                    this.wait();
                    System.out.println("wait3 等待了5秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }).start();

        new Thread(() -> {
            synchronized (this) {
                System.out.println("子线程2开始");
                System.out.println("2---------------------->");
                // this.wait(5000);
                try {
                    Thread.currentThread().sleep(2000);
                    System.out.println("唤醒：");
                    notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();
    }

}