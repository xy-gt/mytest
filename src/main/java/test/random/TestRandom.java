package test.random;

import java.security.SecureRandom;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/6/11 14:20
 */
public class TestRandom {
    public static void main(String[] args) {

        SecureRandom random=new SecureRandom();
        //加入种子数每次生成的随机数会一样
        //random.setSeed(100);
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(100));
        }
    }
}
