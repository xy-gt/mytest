package test.string;

import java.util.HashMap;
import java.util.Map;

public class TestString1 {

	public static void main(String[] args) {
		String s = "hhkhkljojo{jmljljljl}jljljl*hhkdd%^^&@$";
		
		System.out.println(s);
		System.out.println(s.substring(3));
		System.out.println(s);
		System.out.println(s.substring(1, 3));
		System.out.println(s);

        Map map = new HashMap();
        map.put("a",221);
        map.putIfAbsent("b","fdf");

        System.out.println(  map.values() );



	}

}
