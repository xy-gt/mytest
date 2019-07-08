package test.test;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/5 13:59
 */
public class Test {
    public static void main1(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.scheduleAtFixedRate(() -> {
                    System.out.println("sssssssssssss");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },1, 5,TimeUnit.SECONDS);
        }
     /********************************************************************************************************/
     public static void main(String[] args) {
         BlockingQueue<Integer> queue = new SynchronousQueue<>();
         System.out.print(queue.offer(1) + " ");
         System.out.print(queue.offer(2) + " ");
         System.out.print(queue.offer(3) + " ");
         try {
             System.out.print(queue.take() + " ");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(queue.size());
     }
}