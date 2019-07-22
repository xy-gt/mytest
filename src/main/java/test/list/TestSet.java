package test.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestSet {

	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("1");
		l.add("1");
		l.add("1");
       System.out.println(l);
	   System.out.println( String.join(",", l));


	   new Thread(() -> {
           List list = new ArrayList();
           Long start = System.currentTimeMillis();
           for (int i = 0; i <= 10000000; i++) {
               list.add(i);
           }
           Long end = System.currentTimeMillis();
           System.out.println("addList耗时1:"+ (end-start));

           Long start2 = System.currentTimeMillis();
           for (int i = 10000000; i > 0; i--) {
               list.remove(i);
           }
           Long end2 = System.currentTimeMillis();
           System.out.println("remList耗时1:"+ (end2-start2));

       }).start();

        new Thread(() -> {
            List link = new LinkedList();
            Long start = System.currentTimeMillis();
            for (int i = 0; i <= 10000000; i++) {
                link.add(i);
            }
            Long end = System.currentTimeMillis();
            System.out.println("addLink耗时2:"+ (end-start));

            Long start2 = System.currentTimeMillis();
            for (int i = 10000000; i > 0; i--) {
                link.remove(i);
            }

            Long end2 = System.currentTimeMillis();
            System.out.println("remLink耗时2:"+ (end2-start2));


        }).start();


	}

}
