package test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author xiongyong
 * @Date 2021/1/29
 */

public class TestThreadaa {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(11);

        executorService.execute(() -> {
            System.out.println("ssssssss");
            throw new RuntimeException("sssaa");
        });

        Thread.sleep(2000);
        System.out.println("lllll");

    }
}
