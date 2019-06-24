package test.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {

	
	public static void main(String[] args) throws Exception {
		
		CountDownLatch c = new CountDownLatch(1000);
		
		ExecutorService ex = Executors.newFixedThreadPool(10);
		B b = new B();
		for (int i = 1; i<= 1000; i++) {
			ex.execute(() ->  {
				try {
					c.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					doTest(b);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			c.countDown();
		}
		Thread.sleep(30000);
		ex.shutdown();
        System.out.println("主线程:"+b.getAge());
        
		
	}
	 static synchronized void doTest(B b) throws InterruptedException {
		
		Random random = new Random();
		Integer b1 = b.getAge();
		b.setAge(b1+1);
		Thread.sleep(random.nextInt(200));
		System.out.println(Thread.currentThread().getName()+"："+ b1);
		
		
		
	}

}
class B{
	Integer age = 0;
	String name = "ceshi";
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
