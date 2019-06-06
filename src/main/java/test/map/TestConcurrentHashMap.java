package test.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

	public static void main(String[] args) {
		Map map= new ConcurrentHashMap();
		//key 或者 value 为null 时会报错
		map.put(null, null);

	}

}
