package com.zjx.file;

import java.io.*;

/**
 * @author zhaojiaxing
 * @date 2020-02-01 21:25
 */
public class Book implements Serializable {

    private String title;

    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "SerializableTest{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

class SerializableTest{
    public static void main(String[] args) throws Exception{
//        ser();
        dser();
    }

    /**
     * 序列化
     * @throws Exception
     */
    public static void ser() throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                new File("E:\\demo\\book.txt")));
        //序列化对象
        oos.writeObject(new Book("java编程思想",121));
        oos.close();
    }

    /**
     * 反序列化
     * @throws Exception
     */
    public static void dser() throws Exception{
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                new File("E:\\demo\\book.txt")
        ));
        //反序列化
        Object obj = inputStream.readObject();

        Book book = (Book)obj;
        System.out.println(book);

        inputStream.close();
    }

}
