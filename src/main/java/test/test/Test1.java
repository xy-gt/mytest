package test.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author xiongyong
 * @Date 2022/2/23
 */

public class Test1 {

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(() -> {
            try {
                while (true) {
                    System.out.println(queue.take());

                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        executorService.execute(() -> {
            while (true) {
                try {
                    queue.put("aaa");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
