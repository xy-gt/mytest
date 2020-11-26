package test.list;

import org.apache.commons.collections4.CollectionUtils;
import test.enums.SourceEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiongyong
 * @Date 2020/11/24
 */

public class TestList {

    public static void main(String[] args) {

        List list1 = new ArrayList();
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);

        List list11 = new ArrayList();
        list11.add(1);
        list11.add(2);
        list11.add(4);
        list11.add(3);


        System.out.println(list1.retainAll(list11));
        System.out.println(list1);
        System.out.println(list11);

        boolean equalCollection = CollectionUtils.isEqualCollection(list1, list11);
        System.out.println(equalCollection);


        list1.stream().forEach( p -> System.out.println(p));

        System.out.println("list:"+list1);
        System.out.println("分支修改");
    }
}
