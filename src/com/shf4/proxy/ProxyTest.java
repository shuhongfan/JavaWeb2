package com.shf4.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
//        创建真实对象
        Lenovo lenovo = new Lenovo();

//        动态代理证券Lenovo对象
//        三个参数
//            1.类加载器  真实对象.getClass().getClassLoader()
//            2.接口数组  真实对象.getClass().getInterfaces()
//            3.处理器 new InvocationHandler
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
//            代理逻辑方法编写 代理对象调用的所有方法都会触发该方法执行
//            proxy 代理对象
//            method 代理对象调用的方法，被封装为的对象
//            args 代理对象调用的方法，传递的实时参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("InvocationHandler执行了");
//                System.out.println(method.getName());
//                System.out.println(args[0]);

                if(method.getName().equals("sale")){
//                    1.增强参数
                    double money = (double) args[0];
                    money=money*0.85;
                    System.out.println("专车接你");
//                    真实对象调用方法
                    Object obj = method.invoke(lenovo, money);
                    System.out.println("免费送货...");

//                    2.增强返回值
                    return obj+"_鼠标垫";
                } else{
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });

//        调用方法
        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);
    }
}
