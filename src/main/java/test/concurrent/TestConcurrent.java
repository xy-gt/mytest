package test.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试锁
 * @author panda
 *
 */
public class TestConcurrent {

	static int a = 0;
    Lock lock = new ReentrantLock(false);
	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(1000);
		ExecutorService ex1 = Executors.newFixedThreadPool(1);
		
		for (int i = 0; i < 1000; i++) {
			ex1.execute(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new TestConcurrent().doTest(Thread.currentThread().getName());
			});
			countDownLatch.countDown();
		}
		Thread.sleep(60000);
		System.err.println("end a:"+a);
		ex1.shutdown();

	}

	synchronized void doTest2(String n){
        a++;
        System.out.println("thread name:"+n+",a:"+a);
    }
	  void  doTest(String name) {
         lock.lock();
         try {
             a++;
             System.out.println("thread name:"+name+",a:"+a);
             if (a== 349) {
                 throw new RuntimeException("手动抛出异常");
             }
         } finally {
             lock.unlock();
         }
	}
}
