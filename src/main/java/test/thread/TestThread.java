package test.thread;

public class TestThread {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("start�ʼ");
		
		T t = new T();
		T2 t2 = new T2();
		T3 t3 = new T3();
		
		t.start();
		t.setPriority(10);
		
		//t2.start();
		t3.start();
		t3.setPriority(2);
	    
		
		Thread.sleep(10000);
		System.out.println("end");
	}

}

class T extends Thread{
	
	public void run() {
		while(true) {
			try {
				this.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  System.out.println("���߳�1��ʼ--------------------------------------------11111111111111111111111------------");
		}
		
	}
}

class T3 extends Thread{
	
	public void run() {
		while(true) {
			Thread.currentThread().yield();
			System.out.println("���߳�3----------------------------3333333333333333333-------");
		try {
			this.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
}

class T2 extends Thread{
	
	public void run() {
		while (true) {
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("���߳�2��ʼ---------------------------------------------------------------------------------2222222222222222222");
		}
	}
} 