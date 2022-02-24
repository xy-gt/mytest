package test.string;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringUtils;

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

        String a = "hljljljl";
		System.out.println(a.contains("h"));
		System.out.println(a.contentEquals("hljljljl"));


		String aa = "";
		String aa2 = "sa";
		String aa3 = "a";

		System.out.println("ssssssssssssssssssss");
		System.out.println(StringUtils.isAnyBlank(aa, aa2, aa3));


	}

}
