package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface RmtServer extends Remote {
    public Date getDate() throws RemoteException;
    public Integer add(Integer a, Integer b) throws RemoteException;
    public String whichAnimal(Animal a) throws RemoteException;
}
