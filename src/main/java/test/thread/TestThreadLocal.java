package test.thread;

/**
 * @Author xiongyong
 * @Date 2020/12/2
 */

public class TestThreadLocal {

    private static ThreadLocal local1 = new ThreadLocal();

    public static void main(String[] args) {

        local1.set(1);

        local1.set(2);

        System.out.println(local1.get());

    }
}
