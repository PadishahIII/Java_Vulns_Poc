package com.example;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
  private static final long serialVersionUID = 1L;
  private transient int id;
  private String s;

  public Employee(int id, String s) {
    this.id = id;
    this.s = s;
  }

  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }

  private void readObject(ObjectInputStream ois)
    throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }

  @Override
  public String toString() {
    return "Employee:id:" + Integer.toString(id) + ":s:" + s;
  }
}
