package rmi;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class RMIClientApp {

  public static void main(String args[]) throws RemoteException {
    //System.setProperty("java.rmi.server.codebase","http://localhost/java/");
    System.setProperty("java.security.policy", "file:/D:/java.policy");
    RMISecurityManager rmiSecurityManager = new RMISecurityManager();
    System.setSecurityManager(rmiSecurityManager);
    MyClient client = new MyClient("127.0.0.1", 1099);
    System.out.println(client.getRmtDate());
    //System.out.println(client.getRmtDate());
    //System.out.println(client.rmtAdd(1, 2));
  }
}
