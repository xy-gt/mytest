package test.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/9/5 9:03
 */
public class TestOOM {

    public static void main(String[] args) {
        try {
            List list = new ArrayList();
            while (true) {
                list.add(new HashMap<>());
            }

        } catch (Throwable e) {
            e.printStackTrace();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}
