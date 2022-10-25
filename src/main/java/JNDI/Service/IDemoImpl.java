package JNDI.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IDemoImpl  extends UnicastRemoteObject implements IDemo{
    private String initText;

    public IDemoImpl(String initText) throws RemoteException {
        super();
        this.initText = initText;
    }

    @Override
    public void sayHello(String text) throws RemoteException  {
        if (text==null) System.out.println("this is a service demo : "+initText);
        else System.out.println("this is a service demo : "+text);
    }
}
