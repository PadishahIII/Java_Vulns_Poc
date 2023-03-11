package jndi;

import java.rmi.RMISecurityManager;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIClient {

  public static void main(String[] args) throws NamingException {
    System.setProperty("java.security.policy", "file://D:/java.policy");
    System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
    System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
    SecurityManager securityManager = new SecurityManager();
    System.setSecurityManager(securityManager);

    Hashtable env = new Hashtable();
    env.put(
      Context.INITIAL_CONTEXT_FACTORY,
      "com.sun.jndi.rmi.registry.RegistryContextFactory"
    );
    env.put(Context.PROVIDER_URL, "rmi://localhost:1099");
    Context context = new InitialContext(env);
    Fruit fruit = (Fruit) context.lookup("JNDI");
    System.out.println(fruit.getName());
  }
}
