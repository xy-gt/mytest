package test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallable {

	public static void main(String[] args) throws Exception {
		System.out.println("���߳̿�ʼ��"+Thread.currentThread().getName());
	
		Callable ca = new Enter().en();
		FutureTask<String> future = new FutureTask(ca);
		new Thread(future).start();
		System.out.println("�첽ֵ-----------------"+future.get());
		System.out.println("���߳̽�����"+Thread.currentThread().getName());
		
		
		FutureTask<String> future2 = new FutureTask(new E1());
		new Thread(future2).start();
		System.out.println(future2.get());
	}

}

class Enter {
	public Callable en() throws Exception {
		
		Callable<String> re = new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("���߳̿�ʼ��"+Thread.currentThread().getName());
				
				return "helloworld";
			}
			
		};
	    
		return re;
	}
}


class E1 implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		return "sssssssssssssssssssss";
	}
	
}