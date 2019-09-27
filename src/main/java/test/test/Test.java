package test.test;

import java.text.Collator;
import java.util.*;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/5 13:59
 */
public  class Test {
    public static void main1(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.scheduleAtFixedRate(() -> {
                    System.out.println("sssssssssssss");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },1, 5,TimeUnit.SECONDS);
        }
    /********************************************************************************************************/
     public static void main2(String[] args) {
         BlockingQueue<Integer> queue = new SynchronousQueue<>();
         System.out.print(queue.offer(1) + " ");
         System.out.print(queue.offer(2) + " ");
         System.out.print(queue.offer(3) + " ");
         try {
             System.out.print(queue.take() + " ");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(queue.size());
     }
    /********************************************************************************************************/
    public static void main(String[] args) {
        byte a = -112;
        byte b = 87;
        System.out.println("a&b:"+( a & 0xff));

        Map map = new HashMap();
        System.out.println(map.put("q","sssssss"));
        System.out.println(map.put("q2","aassas"));
        System.out.println(map.put("q","aasjiljljlsas"));



        User user = new User();
        user.setId(156);
        user.setName("ss");
        User user2 = new User();
        user2.setId(2);
        user2.setName("sss");
        User user3 = new User();
        user3.setId(3);
        user3.setName("ssss");


        List list = new ArrayList();
        list.add(user);
        list.add(user2);
        list.add(user3);

        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
            }
        });
        System.out.println(list);

        StringBuilder stringBuilder = new StringBuilder("aaa,bbb");
        System.out.println(stringBuilder.indexOf("asaa") == -1);

        List l = new ArrayList();
        l.add("1");
        l.add("2");
        System.out.println(l.indexOf("11"));


        String q = "srfsfsdf";
        System.out.printf(q.intern());



    }




}