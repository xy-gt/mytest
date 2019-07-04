package test.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/4 9:48
 */
public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (SourceEnum s : SourceEnum.values()) {
            Map map = new HashMap();
            map.put("code", s.getCode());
            map.put("remark",s.getRemark());
            list.add(map);
        }
        System.out.println(list);
    }
}
