package test.concurrent;

import java.util.concurrent.*;
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
    static TestConcurrent testConcurrent = new TestConcurrent();
	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(10);
		ExecutorService ex1 = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
		
		for (int i = 0; i < 10; i++) {
			ex1.execute(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testConcurrent.doTest(Thread.currentThread().getName());
			});
			countDownLatch.countDown();
		}
		Thread.sleep(5000);
		System.err.println("end a:"+a);
		ex1.shutdown();

	}
    void doTest3(String n) {
	    synchronized (this) {
            a++;
            System.out.println("thread name:"+n+",a:"+a);
        }
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
         } finally {
             lock.unlock();
         }
	}
}
