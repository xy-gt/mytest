package test.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/8/7 15:25
 */
public class Test7 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(6);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
