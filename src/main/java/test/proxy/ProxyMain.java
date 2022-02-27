package test.proxy;

import java.lang.reflect.Proxy;

public class ProxyMain {
    public static void main(String[] args) {


        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ProxyTest o = (ProxyTest)(Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{ProxyTest.class},
                new ProxyTestHander(new ProxyTestImpl())));

        o.t();

    }
}
