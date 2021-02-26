package test.algorithm;

/**
 * @Author xiongyong
 * @Date 2021/2/25
 */

public class TestThread {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 10 ; i++) {
                    Thread.sleep(1000);
                    System.out.println("sssss子线程sssssss");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();

        System.out.println("主线程end");

    }
}
