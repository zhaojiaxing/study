package com.zjx.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Administrator
 * @date 2020-02-01 11:49
 */
public class CopyFile {
    public static void main(String[] args) throws Exception {
//        String source = "e:\\demo\\纵天神帝.txt";
//        String target = "e:\\demo\\";
//        long time1 = System.currentTimeMillis();
//        copyFileByStream(source, target + "1.txt");
//        System.out.println("通过字节流实现文件的拷贝耗时：" + (System.currentTimeMillis() - time1));
//
//        long time2 = System.currentTimeMillis();
//        copyFileByReaderAndWriter(source, target + "2.txt");
//        System.out.println("通过字符流实现文件的拷贝耗时：" + (System.currentTimeMillis() - time2));
//
//        long time3 = System.currentTimeMillis();
//        copyFileByBuffered(source, target + "3.txt");
//        System.out.println("通过字节缓冲流实现文件的拷贝耗时：" + (System.currentTimeMillis() - time3));
//
//        long time4 = System.currentTimeMillis();
//        copyFileByBufferedChar(source, target + "4.txt");
//        System.out.println("通过字符缓冲流实现文件的拷贝耗时：" + (System.currentTimeMillis() - time4));
//
//        long time5 = System.currentTimeMillis();
//        copyFileByChannel(source, target + "5.txt");
//        System.out.println("通过JAVA NIO通道（非直接缓冲区）实现文件的拷贝耗时：" + (System.currentTimeMillis() - time5));
//
//        long time6 = System.currentTimeMillis();
//        copyFileByChannelBufferd(source, target + "6.txt");
//        System.out.println("通过JAVA NIO通道（直接缓冲区）实现文件的拷贝耗时：" + (System.currentTimeMillis() - time6));
//
//        long time7 = System.currentTimeMillis();
//        copyFileByChannelTransfer(source, target + "7.txt");
//        System.out.println("通过JAVA NIO通道传输实现文件的拷贝耗时：" + (System.currentTimeMillis() - time7));
//
//        long time8 = System.currentTimeMillis();
//        copyFileByChannelTransfer(source, target + "8.txt");
//        System.out.println("通过JAVA NIO通道传输2实现文件的拷贝耗时：" + (System.currentTimeMillis() - time8));

        long time9 = System.currentTimeMillis();
        copyFolder("e:\\demo","e:\\demo2");
        System.out.println("复制文件夹耗时："+(System.currentTimeMillis() - time9));

    }

    /**
     * 通过字节流实现文件的拷贝
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void copyFileByStream(String sourcePath, String targetPath) {
        //源文件路径
        File source = new File(sourcePath);
        //目标文件路径
        File target = new File(targetPath);

        //如果源文件不存在则不能拷贝
        if (!source.exists()) {
            return;
        }
        //如果目标文件目录不存在则创建
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }

        try {
            //实现文件的拷贝
            InputStream inputStream = new FileInputStream(source);
            OutputStream outputStream = new FileOutputStream(target);
            int temp = 0;
            //每次读取1024个字节
            byte[] data = new byte[1024];
            //将每次读取的数据保存到字节数组里面，并且返回读取的个数
            while ((temp = inputStream.read(data)) != -1) {
                //输出数组
                outputStream.write(data, 0, temp);
            }

            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过字符流实现文件的拷贝
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void copyFileByReaderAndWriter(String sourcePath, String targetPath) {
        //源文件路径
        File source = new File(sourcePath);
        //目标文件路径
        File target = new File(targetPath);

        //如果源文件不存在则不能拷贝
        if (!source.exists()) {
            return;
        }
        //如果目标文件目录不存在则创建
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }

        FileReader in = null;
        FileWriter out = null;
        try {
            //字符输入流和字符输出流
            in = new FileReader(source);
            out = new FileWriter(target);

            char[] c = new char[1024];
            int temp = 0;
            //每次读取1024个字符
            while ((temp = in.read(c)) != -1) {
                //输出到文件
                out.write(c, 0, temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过字节缓冲流实现文件的拷贝
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void copyFileByBuffered(String sourcePath, String targetPath) {
        //源文件路径
        File source = new File(sourcePath);
        //目标文件路径
        File target = new File(targetPath);

        //如果源文件不存在则不能拷贝
        if (!source.exists()) {
            return;
        }
        //如果目标文件目录不存在则创建
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }

        InputStream in = null;
        OutputStream out = null;
        try {
            //字节缓冲输入流和字节缓冲输出流
            in = new BufferedInputStream(new FileInputStream(source));
            out = new BufferedOutputStream(new FileOutputStream(target));

            byte[] b = new byte[1024];
            int temp = 0;
            //每次读取一个1024的字节数组
            while ((temp = in.read(b)) != -1) {
                //输出到文件
                out.write(b, 0, temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 通过字符缓冲流实现文件的拷贝
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void copyFileByBufferedChar(String sourcePath, String targetPath) {
        //源文件路径
        File source = new File(sourcePath);
        //目标文件路径
        File target = new File(targetPath);

        //如果源文件不存在则不能拷贝
        if (!source.exists()) {
            return;
        }
        //如果目标文件目录不存在则创建
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }

        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            //字符缓冲输入流和字符缓冲输出流
            in = new BufferedReader(new FileReader(source));
            out = new BufferedWriter(new FileWriter(target));

            //读取文件（每次读取一行）
            String temp = null;
            while ((temp = in.readLine()) != null) {
                //输出到文件
                out.write(temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过JAVA NIO 非直接缓冲区拷贝文件
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void copyFileByChannel(String sourcePath, String targetPath) {
        FileChannel outChannel = null;
        FileChannel inChannel = null;

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(sourcePath);
            fos = new FileOutputStream(targetPath);

            //获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (inChannel.read(buf) != -1) {
                //转换为读取数据模式
                buf.flip();
                //写入到磁盘
                outChannel.write(buf);
                //清空缓冲区
                buf.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (outChannel != null) {
                    outChannel.close();
                }
                if (inChannel != null) {
                    inChannel.close();
                }
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过JAVA NIO 直接缓冲区拷贝文件（内存映射文件）
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void copyFileByChannelBufferd(String sourcePath, String targetPath) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            //获取通道,StandardOpenOption.READ表示可读，StandardOpenOption.WRITE表示可写，StandardOpenOption.CREATE表示可以创建
            inChannel = FileChannel.open(Paths.get(sourcePath), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get(targetPath), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            //创建内存映射文件
            MappedByteBuffer inMapped = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMapped = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接操作内存映射文件
            byte[] buf = new byte[inMapped.limit()];
            inMapped.get(buf);
            outMapped.put(buf);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (outChannel != null) {
                    outChannel.close();
                }
                if (inChannel != null) {
                    inChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  通过JAVA NIO 通道传输拷贝文件
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void copyFileByChannelTransfer(String sourcePath, String targetPath) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            //获取通道
            inChannel = FileChannel.open(Paths.get(sourcePath), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get(targetPath),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

            inChannel.transferTo(0,inChannel.size(),outChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            try {
                if (outChannel != null) {
                    outChannel.close();
                }
                if (inChannel != null) {
                    inChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  通过JAVA NIO 通道传输拷贝文件
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void copyFileByChannelTransfer2(String sourcePath, String targetPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream(sourcePath);
            fos = new FileOutputStream(targetPath);

            //获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            inChannel.transferTo(0,inChannel.size(),outChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            try {
                if (outChannel != null) {
                    outChannel.close();
                }
                if (inChannel != null) {
                    inChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 复制文件夹(使用缓冲字节流)
     * @param sourcePath 源文件夹路径
     * @param targetPath 目标文件夹路径
     */
    public static void copyFolder(String sourcePath,String targetPath) throws Exception{
        //源文件夹路径
        File sourceFile = new File(sourcePath);
        //目标文件夹路径
        File targetFile = new File(targetPath);

        if(!sourceFile.exists()){
            throw new Exception("文件夹不存在");
        }
        if(!sourceFile.isDirectory()){
            throw new Exception("源文件夹不是目录");
        }
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        if(!targetFile.isDirectory()){
            throw new Exception("目标文件夹不是目录");
        }

        File[] files = sourceFile.listFiles();
        if(files == null || files.length == 0){
            return;
        }

        for(File file : files){
            //文件要移动的路径
            String movePath = targetFile+File.separator+file.getName();
            if(file.isDirectory()){
                //如果是目录则递归调用
                copyFolder(file.getAbsolutePath(),movePath);
            }else {
                //如果是文件则复制文件
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(movePath));

                byte[] b = new byte[1024];
                int temp = 0;
                while((temp = in.read(b)) != -1){
                    out.write(b,0,temp);
                }
                out.close();
                in.close();
            }
        }
    }

}
