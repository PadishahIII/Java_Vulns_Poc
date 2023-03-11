package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class MyClient {
  private RmtServer server;

  public MyClient(String host, int port) {
    try {
      Registry registry = LocateRegistry.getRegistry(host, port);
      server = (RmtServer) registry.lookup("MyServer");
    } catch (RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NotBoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public Date getRmtDate() throws RemoteException {
    return server.getDate();
  }

  public Integer rmtAdd(Integer a, Integer b) throws RemoteException {
    return server.add(a, b);
  }

  public String animal(Animal a) {
    String s = "";
    try {
      s = server.whichAnimal(a);
    } catch (RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return s;
  }
}
