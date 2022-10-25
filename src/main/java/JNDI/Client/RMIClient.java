package JNDI.Client;

import JNDI.Service.IDemo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class RMIClient {
    public static void main(String[] args) throws NamingException, RemoteException {
        Context ctx=new InitialContext();
        //原来JNDI可以通过协议头RMI默认加载对应的环境
        // Properties env = new Properties();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
//        env.put(Context.PROVIDER_URL, "rmi://localhost:1099");
//        Context ctx = new InitialContext(env);
        IDemo iDemo1 = (IDemo) ctx.lookup("rmi://localhost:1099/demo1");
        IDemo iDemo2 = (IDemo) ctx.lookup("rmi://localhost:1099/demo2");
        System.out.println(iDemo1);
        System.out.println(iDemo2);
        iDemo1.sayHello("test1");
        iDemo2.sayHello("text2");
    }
}
