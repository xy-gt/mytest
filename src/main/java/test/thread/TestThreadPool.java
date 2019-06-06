package test.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestThreadPool {

	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		for(int i = 1; i <= 15; i++) {
		    MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			//Thread.sleep(1000);
			
			System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
			executor.getQueue().size()+"，已执行完别的任务数目："+executor.getCompletedTaskCount());
		}
		//System.out.println(executor.getCompletedTaskCount());
		executor.shutdown();
	}

}

class MyTask implements Runnable{
	
	private int taskNum;

	public MyTask() {
		
	}
	public MyTask(int num) {
	  this.taskNum = num;
	}
	
	 @Override
	public void run() {
		 System.err.println(Thread.currentThread().getName());
		 System.out.println("正在执行task "+taskNum);
		/* try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		 System.out.println("task"+taskNum+"执行完毕");
	}
	
	
}
