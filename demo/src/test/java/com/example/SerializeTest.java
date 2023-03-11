package com.example;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class SerializeTest {
    @Test
    public void EmployeeTest() throws IOException, ClassNotFoundException{
        Employee employee = new Employee(1, "I'm a string");
        FileOutputStream fileOutputStream = new FileOutputStream("employee.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("employee.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Employee e2 =  (Employee)objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(e2.toString());
        
    }
}
