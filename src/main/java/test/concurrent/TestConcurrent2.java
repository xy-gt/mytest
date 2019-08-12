package test.concurrent;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试锁
 * @author panda
 *
 */
public class TestConcurrent2 {

	 int a = 0;
    static TestConcurrent testConcurrent2 = new TestConcurrent();
	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(1000);
		ExecutorService ex1 = new ThreadPoolExecutor(100, 100,
                                        0L, TimeUnit.MILLISECONDS,
                                         new LinkedBlockingQueue<Runnable>());
		
		for (int i = 0; i < 1000; i++) {
			ex1.execute(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testConcurrent2.doTest3(Thread.currentThread().getName());
			});
			countDownLatch.countDown();
		}
		ex1.shutdown();

	}

	public  void test3(String name) throws InterruptedException {
        Random random = new Random();

	    Thread.sleep(random.nextInt(200));
	    a++;
        System.out.println(name+":"+a);
    }
}
