package rmi;

import java.rmi.*;
import java.util.Date;

public class MyServer 
 extends java.rmi.server.UnicastRemoteObject
 implements RmtServer{
    public MyServer()throws RemoteException{}
    
    public Date getDate() throws RemoteException{
        return new Date();
    }
    public Integer add(Integer a, Integer b) throws RemoteException{
        return a + b;
    }
    public String whichAnimal(Animal a) throws RemoteException{
        return a.toString();
    }
}
