package test.algorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程顺序打印1和2
 * @Author xiongyong
 * @Date 2021/1/13
 */

public class Test1 {

    private static int i = 0;

    private static Lock lock = new ReentrantLock();

    public static void add(Thread thread) {
        i += 1;
        String name = thread.getName();
        System.out.println("name:" + name + "  " + i);
    }

    public static void main(String[] args) {
        Condition condition = lock.newCondition();
        Condition condition2 = lock.newCondition();

        Thread thread1 = new Thread(() -> {
            for (int j = 1; j <= 100; j++) {
                if (i % 2 == 0) {
                    lock.lock();
                    add(Thread.currentThread());

                    condition2.signal();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }

        });
        Thread thread2 = new Thread(() -> {
            for (int j = 1; j <= 100; j++) {
                if (i % 2 != 0) {
                    lock.lock();
                    add(Thread.currentThread());

                    condition.signal();
                } else {
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        thread1.setName("print1");
        thread2.setName("print2");

        thread1.start();
        thread2.start();

    }

}
