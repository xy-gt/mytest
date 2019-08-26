package test.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/8/7 15:25
 */
public class Test7 {

    public static void main(String[] args) {
       /* List list = new ArrayList();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(6);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);


        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("a","aaaaaa");
        linkedHashMap.put("a","aass");

        System.out.println(linkedHashMap.get("a"));*/
        System.out.println(Math.round(-1.3));

        List<Integer> l = new ArrayList();
        l.add(1);
        l.add(3);
        l.add(4);

        for (Integer ll : l) {
            if (ll == 3) {
                ll = -ll;
                l.set(1,ll);
            }
        }
        System.out.println(l);

      /*  String s = (String) l.stream().map(p -> String.valueOf(p)).collect(Collectors.joining(","));
        System.out.println(s);*/

        String patternCredits = "^([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$";

        System.out.println("glob uk Silver Silver is 34 Credits".matches(patternCredits));


      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("1");
      stringBuilder.append("2");
      stringBuilder.append("3");

        for (int i = 0; i < stringBuilder.toString().length(); i++) {
            System.out.println(stringBuilder.charAt(i));
        }

        System.out.println(a2r(17));

        System.out.println(romanToInt("IVXVII"));

        System.out.println(te());




    }

    public static boolean te() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                return false;
            }
        }
        return true;
    }

    public static int romanToInt(String s) {
        char[] chars = {'I','V','X','L','C','D','M'};
        int[] ints = {1,5,10,50,100,500,1000};
        int[] answer = new int[s.length()];
        int sign = 0;
        for (int i = 0; i <s.length() ; i++) {
            for (int j = 0; j <chars.length ; j++) {
                if (s.charAt(i) == chars[j]) {
                    answer[i] = ints[j];
                }
            }
        }
        if (answer.length == 1) {
            return answer[0];
        }
        boolean bool = true;
        for (int i = 0; i <answer.length-1 ; i++) {
            bool = answer[i+1] > answer[i];
            if (bool) {
                sign += answer[i+1] - answer[i];
                i += 1;
                if (i == answer.length-2) {
                    sign += answer[answer.length-1];
                }
            }
            if (!bool) {
                sign += answer[i];
            }

        }
        if (!bool) {
            sign += answer[answer.length-1];
        }
        return sign;
    }
    public static String a2r(int number) {
        String rNumber = "";
        int[] aArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rArray = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

            for (int i = 0; i < aArray.length; i++) {
                while (number >= aArray[i]) {
                    rNumber += rArray[i];
                    number -= aArray[i];
                }
            }

        return rNumber;
    }

}
