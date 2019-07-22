package test.test;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/19 8:58
 */
public class Test2 {
    static   boolean  flag = true;
    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            int i = 0;
            while (flag) {
                i++;
               // System.out.println(i);
            }
            System.out.println("---------");
        }).start();

        Thread.sleep(1000);

        flag = false;
        System.out.println("end");

    }
}
