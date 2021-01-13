package test.test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import test.enums.SourceEnum;

import java.sql.SQLOutput;
import java.util.Optional;

/**
 * @Author xiongyong
 * @Date 2020/12/23
 */

public class Test111 {

    public static void main(String[] args) {

        Integer s2 = 0;
        User user = null;
        User user1 = new User();
        Integer s = 33;
         // orElse 不管s 是否为空都会执行
        //Optional.ofNullable(s).orElse(21);
         Optional.ofNullable(s).orElseGet(() -> {
             System.out.println("s");
             return 2212;
         });


    }
}
