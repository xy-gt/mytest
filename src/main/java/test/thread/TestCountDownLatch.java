package test.thread;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch c = new CountDownLatch(1000000);
		
		for (int i = 0; i< 1000000; i++) {
			new Thread(() ->  {
				System.err.println("���߳�"+Thread.currentThread().getName());
			
				try {
					c.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+ ":12313" );
			}).start();
			c.countDown();
		}
		

		//�ȴ�10��
    //    c.await(5,TimeUnit.SECONDS);
        System.out.println("���߳�");
        
		
	}

}
