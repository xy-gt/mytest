package test.testLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xiongyong
 * @Date 2021/1/15
 */

public class TestFinally {

    public static void main(String[] args) {


        ReentrantLock lock = new ReentrantLock();

        int a = 1;

        lock.lock();
        try {
            //int q = 1/0;

            System.out.println("try");
        } catch (Exception e) {

        } finally {
            lock.unlock();
            System.out.println("finally");
        }

        System.out.println("end:"+lock.getHoldCount());

    }
}
