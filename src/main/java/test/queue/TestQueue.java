package test.queue;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @Author xiongyong
 * @Date 2021/1/12
 */

public class TestQueue {


    public static void main(String[] args) {

        Integer a[] = new Integer[100000000];
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < 100000000; i++) {
            a[i] =  i;//random.nextInt(100000);
        }
        System.out.println("==============================================");

        List<Integer> integers = Arrays.asList(a);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y-x);
        integers.forEach(p2 -> {
            priorityQueue.add(p2);
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(priorityQueue.remove());

        }
    }
}
