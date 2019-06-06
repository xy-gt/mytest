package test.park;

import java.util.concurrent.locks.LockSupport;

/**
 * ????pack ??unpack
 * @author soonsmile
 *
 */
public class TestPackAndUnpack {

	public static void main(String[] args) {
		System.out.println("???????");
		
	Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("?????1?????????");
				LockSupport.park();
				System.out.println("?????1??????????");
				
			}
		});
	    t.start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.err.println("?????2 5???????????");
				try {
					Thread.sleep(5000);
					System.err.println("?????2????????");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LockSupport.unpark(t);
			
				
			}
		}).start();
		
	}

}
