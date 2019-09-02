package test.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 水仙花数算法 必须是三位数
 * @Author: panda
 * @Date: 2019/8/26 15:01
 */
public class Test8 {

    public static void main(String[] args) {


        List list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
           String t = String.valueOf(i);

           int sum = 0;
            for (int j = 0; j < t.length(); j++) {
              Integer v = Integer.valueOf( String.valueOf(t.charAt(j)));
              if (v == 0) {
                  continue;
              } else {
                  sum = (int) (sum + Math.pow(v, 3));
              }
            }
            if (sum == i && i != 0) {
                list.add(i);
            }

        }
        for (int i = 0; i < list.size() ; i++) {
            System.out.println("第"+i+"个水仙花数，值为："+list.get(i));
        }
    }
}
