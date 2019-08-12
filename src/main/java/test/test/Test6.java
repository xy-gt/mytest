package test.test;

import java.util.*;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/8/3 18:10
 */
public class Test6 {

    public static void main(String[] args) {

        List<User> list = Arrays.asList(
                new User(1,"a",""),
                new User(2,"b","a"),
                new User(3,"c","b"),
                new User(4,"d","c"),
                new User(5,"e","d"),
                new User(6,"f","e"),
                new User(7,"g","b"),
                new User(8,"h","a")

        );

        List list1 = new ArrayList();
        int i = 0;
        for (User pnodeMap : list) {
            if (pnodeMap.getParentName() == "") {
                list1.add(pnodeMap);
            }

            for (User cnodeMap : list) {
                if (pnodeMap.getName().equals(cnodeMap.getParentName())) {
                    List<User> l = pnodeMap.getChild();
                    if (l == null) {
                        l = new ArrayList<>();
                    }
                    l.add(cnodeMap);
                    pnodeMap.setChild(l);
                    i++;
                }
            }
        }
        System.out.println(i);
        System.out.println(list1);

        //-------------------------------------------------------------------------------


        List<Map> list2 = new ArrayList<>();
        Map map1 = new HashMap();
        map1.put("id",1);
        map1.put("name","a");
        map1.put("par","z");
        Map map2 = new HashMap();
        map2.put("id",2);
        map2.put("name","b");
        map2.put("par","a");
        Map map3 = new HashMap();
        map3.put("id",3);
        map3.put("name","c");
        map3.put("par","b");
        Map map4 = new HashMap();
        map4.put("id",4);
        map4.put("name","d");
        map4.put("par","c");
        Map map5 = new HashMap();
        map5.put("id",5);
        map5.put("name","e");
        map5.put("par","d");
        Map map6 = new HashMap();
        map6.put("id",6);
        map6.put("name","f");
        map6.put("par","c");

        Map map7 = new HashMap();
        map7.put("id",7);
        map7.put("name","g");
        map7.put("par","a");

        Map map8 = new HashMap();
        map8.put("id",8);
        map8.put("name","h");
        map8.put("par","z");

        list2.add(map1);
        list2.add(map2);
        list2.add(map3);
        list2.add(map4);
        list2.add(map5);
        list2.add(map6);
        list2.add(map7);
        list2.add(map8);

        List<Map> trees = new ArrayList<>();

        for (Map parMap : list2) {
            if (parMap.get("par") == "z") {
                trees.add(parMap);
            }

            int a =0;
            for (Map cnodeMap : list2) {
                //System.out.println("pnodeMap:"+pnodeMap+":cnodeMap:"+cnodeMap);
                if (parMap.get("name").equals(cnodeMap.get("par"))) {
                    parMap.put("children"+a,cnodeMap);
                    a++;
                }
            }
        }

       // System.out.println(trees);








    }
}
