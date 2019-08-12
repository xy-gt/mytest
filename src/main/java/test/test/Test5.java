package test.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/29 17:19
 */
public class Test5 {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("a",1);
        System.out.println(map.put("a",2));

        System.out.println(map.put("b",3));

    }
}
