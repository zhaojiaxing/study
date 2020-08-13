package com.zjx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/05/07 10:21
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
//        File parent = new File("F://test/test/");
//        File file = new File("F://test/test/1/tp_baye870822_info.txt");
//        String path = file.getPath();
//        String parrentPath = parent.getPath();
//        System.out.println("主文件路径：" + path);
//        System.out.println("父文件路径：" + parrentPath);
//        String s = path.substring(parrentPath.length());
//        String zx = parent.getParent();
//        System.out.println("zx="+zx);
//        String ers = zx+File.separator+"bak"+s;
//        File er = new File(ers);
//
//        System.out.println(ers);
//        int a = 2 << 5;
//        System.out.println(a);
//        double a = 8.0;
//        double b = 7.0;
//        double c = 6.0;
//        double r1 = a-b;
//        double r2 = b-c;
//        System.out.println(r1);
//        System.out.println(r2);

        List<String> s = asList("z","c","sa","za");
        s.add("zhanger");
        s.remove(0);
        for(String a : s){
            System.out.println(a);
        }

    }

    public static <T> List<T> asList(T... a) {
        return new ArrayList<T>(Arrays.asList(a));
    }
}
