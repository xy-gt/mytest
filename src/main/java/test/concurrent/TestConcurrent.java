package test.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 测试并发
 * @author panda
 *
 */
public class TestConcurrent {

	static int a = 0;
	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(100);
		ExecutorService ex1 = Executors.newFixedThreadPool(20);
		
		
		for (int i = 0; i < 100; i++) {
			ex1.execute(() -> {
				new TestConcurrent().doTest(Thread.currentThread().getName());
				/*
				 * try { //System.out.println("--------------"); //countDownLatch.await(); }
				 * catch (InterruptedException e) { e.printStackTrace(); }
				 */
			});
			/*
			 * new Thread(() -> { try { //System.out.println("--------------");
			 * countDownLatch.await(); doTest(Thread.currentThread().getName()); } catch
			 * (InterruptedException e) { e.printStackTrace(); }
			 * 
			 * 
			 * }).start();
			 */
			//countDownLatch.countDown();
		}
		Thread.sleep(2000);
		System.out.println("end a:"+a);
		ex1.shutdown();
		
//		
	}
	
	  void  doTest(String name) {
		synchronized (TestConcurrent.class) {
			
			a++;
			System.out.println("线程名："+name+",a:"+a);
		}

	}

}
