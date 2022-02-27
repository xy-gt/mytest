package test.proxy;

import java.lang.reflect.Proxy;

public class ProxyTestImpl implements ProxyTest {
    @Override
    public void t() {
        System.out.println("t");
    }
}
