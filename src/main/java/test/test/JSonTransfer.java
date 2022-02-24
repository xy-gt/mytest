package test.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiongyong
 * @Date 2021/8/10
 */

public class JSonTransfer {


    public static void main(String[] args) {


        AA aa = new AA();
        aa.setA_s("ssssssssss_sfs");

        SerializeConfig config = new SerializeConfig();
        config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        System.out.println(JSON.toJSONString(aa, config));



       // ParserConfig.getGlobalInstance().propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;

        String s = "{\"a\":1,\"a_s2\":\"ssssss ssss_sfs\",\"name\":\"test\"}";
   /*     AA aa2 = JSON.parseObject(s, AA.class);
        System.out.println(aa2);*/


        System.setProperty("abc",s);
        System.out.println(System.getProperty("abc"));


    }


}
