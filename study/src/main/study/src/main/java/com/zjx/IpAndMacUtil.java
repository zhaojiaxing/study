package com.zjx;

//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/30 17:41
 */
//@Component
public class IpAndMacUtil {
//    public static String getIp(HttpServletRequest request) throws Exception {
//        String ip = request.getHeader("X-Forwarded-For");
//        if (ip != null) {
//            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
//                int index = ip.indexOf(",");
//                if (index != -1) {
//                    return ip.substring(0, index);
//                } else {
//                    return ip;
//                }
//            }
//        }
//        ip = request.getHeader("X-Real-IP");
//        if (ip != null) {
//            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
//                return ip;
//            }
//        }
//        ip = request.getHeader("Proxy-Client-IP");
//        if (ip != null) {
//            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
//                return ip;
//            }
//        }
//        ip = request.getHeader("WL-Proxy-Client-IP");
//        if (ip != null) {
//            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
//                return ip;
//            }
//        }
//        ip = request.getRemoteAddr();
//        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
//    }

    /**
     * 通过IP地址获取MAC地址
     *
     * @param ip String,127.0.0.1格式
     * @return mac String
     * @throws Exception
     */
    public static String getMACAddress(String ip) throws Exception {
        String line = "";
        String macAddress = "";
        final String MAC_ADDRESS_PREFIX = "MAC Address = ";
        final String LOOPBACK_ADDRESS = "127.0.0.1";
        //如果为127.0.0.1,则获取本地MAC地址。
        if (LOOPBACK_ADDRESS.equals(ip)) {
            InetAddress inetAddress = InetAddress.getLocalHost();
            //貌似此方法需要JDK1.6。
            byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            //下面代码是把mac地址拼装成String
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                //mac[i] & 0xFF 是为了把byte转化为正整数
                String s = Integer.toHexString(mac[i] & 0xFF);
                sb.append(s.length() == 1 ? 0 + s : s);
            }
            //把字符串所有小写字母改为大写成为正规的mac地址并返回
            macAddress = sb.toString().trim().toUpperCase();
            return macAddress;
        }
        //获取非本地IP的MAC地址
        try {
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                if (line != null) {
                    int index = line.indexOf(MAC_ADDRESS_PREFIX);
                    if (index != -1) {
                        macAddress = line.substring(index + MAC_ADDRESS_PREFIX.length()).trim().toUpperCase();
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return macAddress;
    }

    public static void main(String[] args) {

        try {
            System.out.println("MAC地址："+getMACAddress("192.168.7.109"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误");
        }
    }

}
