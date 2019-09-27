package test.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition 实现多线程顺序打印
 */
public class ThreadPrint2 {


    static volatile int index = 1;
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        new Thread(() -> {
          while (true){
            try {
                lock.lock();
                if (index != 1) {
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+":"+ atomicInteger.incrementAndGet());
                index = 2;
                condition2.signal();
            }finally {
                lock.unlock();
                System.out.println("------------------："+index);
            }
          }
        }).start();

        new Thread(() -> {
           while (true) {
             try {
                 lock.lock();
                 if (index != 2) {
                     try {
                         condition2.await();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 System.out.println(Thread.currentThread().getName()+":"+ atomicInteger.incrementAndGet());
                 index = 3;
                 condition3.signal();
             } finally {
                 lock.unlock();
                 System.out.println("------------------："+index);
             }
           }
        }).start();

        new Thread(() -> {
           while (true) {
              try {
                  lock.lock();
                  if (index != 3) {
                      try {
                          condition3.await();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                  System.out.println(Thread.currentThread().getName()+":"+ atomicInteger.incrementAndGet());
                  index = 1;
                  condition1.signal();
              }finally {
                  lock.unlock();
                  System.out.println("------------------："+index);
              }
           }
        }).start();

    }
}

