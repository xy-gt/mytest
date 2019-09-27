package test.test;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Test11 {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1",1);
        concurrentHashMap.put("2",2);
        concurrentHashMap.put("3",3);
        concurrentHashMap.put("4",4);
        concurrentHashMap.put("5",5);

        concurrentHashMap.forEach((k,v) -> {
           concurrentHashMap.remove("3");
        });
        System.out.printf(concurrentHashMap.toString());


        Hashtable hashtable = new Hashtable();
        hashtable.put(null,"s");

       /* new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"------");
            }

        }).start();*/
    }
}
