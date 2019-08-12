package test.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/29 15:07
 */
public class Test3 {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("a");
        new Test4().test4(list);
        System.out.println(list);
    }

}
class Test4{
    public void test4(List list) {

        list.clear();
        list.add("b");
        System.out.println("清除list的值");
    }

}