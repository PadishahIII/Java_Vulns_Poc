package rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;

public class RMIServerApp {

  public static void main(String args[]) throws ClassNotFoundException {
    try {
      System.setProperty("java.rmi.server.codebase", "http://127.0.0.1:8888/");
      System.setProperty("java.security.policy", "file://D:/java.policy");

      RMISecurityManager rmiSecurityManager = new RMISecurityManager();
      System.setSecurityManager(rmiSecurityManager);

      Registry registry = LocateRegistry.createRegistry(1099);

    //  ClassLoader rmi = RMIClassLoader.getClassLoader("http://localhost/java/");
    //  Class cl = rmi.loadClass("rmi.Dog");
    //  System.out.println(cl.toString());

      RmtServer rmtServer = new Evil();
      registry.rebind("MyServer", rmtServer);
    } catch (java.io.IOException e) {
      e.printStackTrace();
    }
  }
}
