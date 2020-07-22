package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler  implements InvocationHandler {
    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before" + method.getName());
        method.invoke(object,args);
        System.out.println("After" + method.getName());
        return null;
    }

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloInterface helloInterface = new Hello();
        ByeInterface byeInterface = new Bye();
        InvocationHandler handler = new ProxyHandler(helloInterface);
        InvocationHandler handler1 = new ProxyHandler(byeInterface);
        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(helloInterface.getClass().getClassLoader(), helloInterface.getClass().getInterfaces(), handler);
        ByeInterface proxyBye = (ByeInterface) Proxy.newProxyInstance(byeInterface.getClass().getClassLoader(),byeInterface.getClass().getInterfaces(),handler1);
        proxyHello.sayHello();
        proxyBye.sayBye();
    }
}
