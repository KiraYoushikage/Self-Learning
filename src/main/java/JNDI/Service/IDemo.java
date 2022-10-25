package JNDI.Service;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDemo extends Remote {
    void sayHello(String text) throws RemoteException;
}
