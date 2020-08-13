package com.zjx.file;

import java.io.File;

public class FileDirectory {

    public static void main(String[] args) {
        File file = new File("E:"+File.separator+"demo");
//        String[] fileNames = file.list();
//        for(String fileName : fileNames){
//            System.out.println(fileName);
//        }
//
//        //列出子目录
//        File[] files = file.listFiles();
//        for(File file1 : files){
//            System.out.println(file1.getName()+"  "+(file1.isDirectory()?"文件夹":"文件"));
//        }
        print(file);
    }

    /**
     * 列出某个目录下的所有文件，如果是目录则继续列出
     * @param file
     */
    public static void print(File file){
        //列出子目录
        File[] files = file.listFiles();
        if(files != null){
            for(File file1 : files){
                boolean isDirectory = file1.isDirectory();
                if(isDirectory){
                    print(file1);
                }
                System.out.println(file1.getPath()+"  "+(isDirectory?"文件夹":"文件"));
                file1.delete();
            }
        }

    }
}
