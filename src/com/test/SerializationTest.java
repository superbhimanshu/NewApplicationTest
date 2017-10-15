package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest {

    public static class Q implements Serializable {
        private int x;
        public Q() {
            x = 10;
        }
        public void printValue() {
            System.out.println(x);
        }
    }

    public static void main(String[] args) throws Exception {
        Q q = new Q();
        FileOutputStream fos = new FileOutputStream("c:\\temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(q);
        fos.close();

        FileInputStream fis = new FileInputStream("c:\\temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        Q q2 = (Q)oin.readObject();
        fis.close();
        q2.printValue();

    }
}
