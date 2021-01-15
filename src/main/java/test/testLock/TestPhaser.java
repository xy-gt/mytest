package test.testLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 *  更强大的同步工具类
 * @Author xiongyong
 * @Date 2021/1/15
 */

public class TestPhaser {
    public static void main(String[] args) {


        Phaser phaser = new Phaser();
        phaser.bulkRegister(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        for (int i = 0; i < 9; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName()+ ":事件1");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName()+ ":事件2");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName()+ ":事件3");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName()+ ":事件4");
                phaser.arriveAndAwaitAdvance();

            });
        }
        executorService.shutdown();
    }
}
