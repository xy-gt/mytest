package test.concurrent;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/29 16:10
 */
public class CyclicBarrierExample {

    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(20);

    public static void main(String[] args) throws Exception {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            threadPool.execute(() -> {
                try {
                    cyclicBarrier.await();
                    System.out.println("-------------------------"+Thread.currentThread().getName()+"------------------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }
}
