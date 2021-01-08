package test.test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Optional;

/**
 * @Author xiongyong
 * @Date 2020/12/23
 */

public class Test111 {

    public static void main(String[] args) {

        User user = new User(1,"a",null);
        String s = null;
         s = Optional.ofNullable(s).orElse("sssssssssss");

        String s2 = "s";
        s2 = Optional.ofNullable(s2).orElse("8990");

        System.out.println(s);
        System.out.println(s2);
    }
}
