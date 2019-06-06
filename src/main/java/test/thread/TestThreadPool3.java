package test.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestThreadPool3 {

	public static void main(String[] args) {
	//	ExecutorService executor =  Executors.newFixedThreadPool(3);
		List list = new ArrayList();	
		long start =System.currentTimeMillis();
		//System.out.println(start);
	/*	executor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					//list.clear();
					
					for (int i = 0; i < 1000; i++) {
						list.add(i);
					}
					
					
				}
			});
			executor.execute(new Runnable() {
				@Override
				public void run() {
				//	list.clear();
					System.out.println(Thread.currentThread().getName());
					for (int i = 1000; i < 2000; i++) {
						list.add(i);
					}
					
				}
			});
			executor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					for (int i = 2000; i < 3000; i++) {
						list.add(i);
					}
					
				}
			});
			executor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					for (int i = 3000; i < 4000; i++) {
						list.add(i);
					}
				}
			});*/
		Map map  = new HashMap();
		for (int i = 0; i < 4000; i++) {
			map.put(i, i);
			list.add(map);
		}
			long end = System.currentTimeMillis();
			//Thread.sleep(2000);
			System.out.println(list);
			System.out.println(end - start);
		}

}
