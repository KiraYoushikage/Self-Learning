package JNDI.Service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

public class RMIService {
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        IDemo iDemo1=new IDemoImpl("demo1");
        IDemo iDemo2=new IDemoImpl("demo2");
//        Properties env = new Properties();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
//        env.put(Context.PROVIDER_URL, "rmi://localhost:1099");
//        Context ctx = new InitialContext(env);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("demo1", iDemo1);
        registry.bind("demo2", iDemo2);
    }
}
