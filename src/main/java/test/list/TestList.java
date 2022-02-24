package test.list;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author xiongyong
 * @Date 2020/11/24
 */

public class TestList {
    final Pattern pattern = Pattern.compile("");

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


        ArrayList<Integer> integers = Lists.newArrayList(1, 343, 554, 52, 32, 32);

        System.out.println(integers);
        integers.remove(0);
        System.out.println(integers);





    }
}
