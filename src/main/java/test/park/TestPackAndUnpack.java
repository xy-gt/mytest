package test.park;

import java.util.concurrent.locks.LockSupport;

/**
 * ????pack ??unpack
 * @author soonsmile
 *
 */
public class TestPackAndUnpack {

	public static void main(String[] args) {

        Thread t = new Thread(() -> {

                System.out.println("子线程 park");
                LockSupport.park();
                System.out.println("子线程解除park");

            });
        t.start();
        new Thread(() -> {

            System.err.println("子线程2");
            try {
                Thread.sleep(5000);
                System.err.println("子线程2 休眠了5秒准备unpark");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(t);
        }).start();

    }
}
