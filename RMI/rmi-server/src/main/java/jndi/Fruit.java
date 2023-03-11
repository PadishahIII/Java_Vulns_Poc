package jndi;

import java.io.Serializable;

public class Fruit implements Serializable {
  public String name;

  public Fruit(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
