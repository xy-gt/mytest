package test.algorithm;

import com.google.errorprone.annotations.Var;
import org.apache.catalina.startup.LifecycleListenerRule;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author xiongyong
 * @Date 2022/1/12
 */

public class Lru extends LinkedHashMap {

    public Lru(int initialCapacity,
               float loadFactor,
               boolean accessOrder) {
        super(initialCapacity,loadFactor,accessOrder);
    }

    public static void main(String[] args) {

        Lru lru = new Lru(10,0.75F,false);


        lru.put("a",13);
        lru.put("b",54);
        lru.put("c",3);
        lru.put("d",103);
        lru.put("e",24);

        lru.get("d");
        lru.get("a");
        lru.get("c");


        lru.forEach((k,v) -> {
            System.out.println(v);
        });

    }



    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {

        return size() > 3;
    }
}
