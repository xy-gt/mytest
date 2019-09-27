package test.test;

/**
 * 父类静态块
 * 子类静态块
 * 父类动态块
 * 父类构造
 * 子类动态块
 * 子类构造
 */


public class Test10 {

    public static void main(String[] args) {
        new Test102();
    }
}
class Test101 {
    static {
        System.out.println("父类静态块");
    }
    {
        System.out.println("父类动态块");
    }
    public Test101() {
        System.out.println("父类构造");
    }
}
class Test102 extends Test101{
    static {
        System.out.println("子类静态块");
    }
    {
        System.out.println("子类动态块");
    }
    public Test102() {
        System.out.println("子类构造");
    }
}