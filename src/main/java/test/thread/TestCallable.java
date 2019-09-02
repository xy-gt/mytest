package test.thread;

import java.util.concurrent.*;

public class TestCallable {

	public static void main(String[] args) throws Exception {
        System.out.println("主线程："+Thread.currentThread().getName());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable ca = new Enter().en();
        Future<String> future = executorService.submit(ca);

		System.out.println("结果-----------------"+future.get());

	}

}

class Enter {
	public Callable en() throws Exception {
		
		Callable<String> re = () -> {
            System.out.println("call线程："+Thread.currentThread().getName());

            return "helloworld";
		};
	    
		return re;
	}
}
