package com.xinyu.test;

import java.io.*;

public class TestSerializable {
    public static void main(String[] args) {
        Person p = new Person();
        p.age = 20;
//        p.name = "yu";
        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("text"));
//            objectOutputStream.writeObject(p);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("text"));
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person.name2);
            System.out.println(person.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
class Person implements Serializable {
    private static final long serialVersionUID = 3585795484935631052L;
    //    private static final long serialVersionUID = 7123493762777832743L;
    public int age;
    public int sage;
    public String name2;

}
