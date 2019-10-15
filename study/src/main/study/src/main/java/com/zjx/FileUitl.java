package com.zjx;

import java.io.*;
import java.util.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class FileUitl {

    /**
     * 将文件转成base64 字符串
     *
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * 将base64字符解码保存文件
     *
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */
    public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();

    }

    public static void base64ToFile(String destPath,String base64, String fileName) {
        File file = null;
        //创建文件目录
        String filePath=destPath;
        File  dir=new File(filePath);
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdirs();
        }
        BufferedOutputStream bos = null;
        java.io.FileOutputStream fos = null;
        try {
            byte[] bytes = Base64.getDecoder().decode(base64);
            file=new File(filePath+"/"+fileName);
            fos = new java.io.FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将base64字符保存文本文件
     *
     * @param base64Code
     * @param targetPath
     * @return:
     * @author: zhaojiaxing
     * @createTime: 2019/5/30 0030 14:32
     */
    public static void toFile(String base64Code, String targetPath) throws Exception {
        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    public static void main(String[] args) {
        try {

//            String base64Code = encodeBase64File("E:/谷歌浏览器下载/应用程序/2011年考研数学三真题及答案解析[doc.xuehai.net].doc");
//            System.out.println(base64Code);
            String base64Code = "e1xydGYxXGFkZWZsYW5nMTAyNVxhbnNpXGFuc2ljcGc5MzZcdWMyXGFkZWZmMFxkZWZmMFxzdHNo\n" +
                    "ZmRiY2gxM1xzdHNoZmxvY2gwXHN0c2hmaGljaDBcc3RzaGZiaTBcZGVmbGFuZzEwMzNcZGVmbGFu\n" +
                    "Z2ZlMjA1MntcZm9udHRibHtcZjBcZnJvbWFuXGZjaGFyc2V0MFxmcHJxMntcKlxwYW5vc2UgMDIw\n" +
                    "MjA2MDMwNTA0MDUwMjAzMDR9VGltZXMgTmV3IFJvbWFuO317XGYxM1xmbmlsXGZjaGFyc2V0MTM0\n" +
                    "XGZwcnEye1wqXHBhbm9zZSAwMjAxMDYwMDAzMDEwMTAxMDEwMX1cJ2NiXCdjZVwnY2NcJ2U1e1wq\n" +
                    "XGZhbHQgU2ltU3VufTt9DQp7XGYzNlxmbmlsXGZjaGFyc2V0MTM0XGZwcnEye1wqXHBhbm9zZSAw\n" +
                    "MjAxMDYwMDAzMDEwMTAxMDEwMX1AXCdjYlwnY2VcJ2NjXCdlNTt9e1xmMzhcZnJvbWFuXGZjaGFy\n" +
                    "c2V0MjM4XGZwcnEyIFRpbWVzIE5ldyBSb21hbiBDRTt9e1xmMzlcZnJvbWFuXGZjaGFyc2V0MjA0\n" +
                    "XGZwcnEyIFRpbWVzIE5ldyBSb21hbiBDeXI7fXtcZjQxXGZyb21hblxmY2hhcnNldDE2MVxmcHJx\n" +
                    "MiBUaW1lcyBOZXcgUm9tYW4gR3JlZWs7fQ0Ke1xmNDJcZnJvbWFuXGZjaGFyc2V0MTYyXGZwcnEy\n" +
                    "IFRpbWVzIE5ldyBSb21hbiBUdXI7fXtcZjQzXGZiaWRpIFxmcm9tYW5cZmNoYXJzZXQxNzdcZnBy\n" +
                    "cTIgVGltZXMgTmV3IFJvbWFuIChIZWJyZXcpO317XGY0NFxmYmlkaSBcZnJvbWFuXGZjaGFyc2V0\n" +
                    "MTc4XGZwcnEyIFRpbWVzIE5ldyBSb21hbiAoQXJhYmljKTt9e1xmNDVcZnJvbWFuXGZjaGFyc2V0\n" +
                    "MTg2XGZwcnEyIFRpbWVzIE5ldyBSb21hbiBCYWx0aWM7fQ0Ke1xmNDZcZnJvbWFuXGZjaGFyc2V0\n" +
                    "MTYzXGZwcnEyIFRpbWVzIE5ldyBSb21hbiAoVmlldG5hbWVzZSk7fXtcZjE3MFxmbmlsXGZjaGFy\n" +
                    "c2V0MFxmcHJxMiBTaW1TdW4gV2VzdGVybntcKlxmYWx0IFNpbVN1bn07fXtcZjQwMFxmbmlsXGZj\n" +
                    "aGFyc2V0MFxmcHJxMiBAXCdjYlwnY2VcJ2NjXCdlNSBXZXN0ZXJuO319e1xjb2xvcnRibDtccmVk\n" +
                    "MFxncmVlbjBcYmx1ZTA7XHJlZDBcZ3JlZW4wXGJsdWUyNTU7XHJlZDBcZ3JlZW4yNTVcYmx1ZTI1\n" +
                    "NTsNClxyZWQwXGdyZWVuMjU1XGJsdWUwO1xyZWQyNTVcZ3JlZW4wXGJsdWUyNTU7XHJlZDI1NVxn\n" +
                    "cmVlbjBcYmx1ZTA7XHJlZDI1NVxncmVlbjI1NVxibHVlMDtccmVkMjU1XGdyZWVuMjU1XGJsdWUy\n" +
                    "NTU7XHJlZDBcZ3JlZW4wXGJsdWUxMjg7XHJlZDBcZ3JlZW4xMjhcYmx1ZTEyODtccmVkMFxncmVl\n" +
                    "bjEyOFxibHVlMDtccmVkMTI4XGdyZWVuMFxibHVlMTI4O1xyZWQxMjhcZ3JlZW4wXGJsdWUwO1xy\n" +
                    "ZWQxMjhcZ3JlZW4xMjhcYmx1ZTA7DQpccmVkMTI4XGdyZWVuMTI4XGJsdWUxMjg7XHJlZDE5Mlxn\n" +
                    "cmVlbjE5MlxibHVlMTkyO317XHN0eWxlc2hlZXR7XHFqIFxsaTBccmkwXG5vd2lkY3RscGFyXHdy\n" +
                    "YXBkZWZhdWx0XGFzcGFscGhhXGFzcG51bVxmYWF1dG9cYWRqdXN0cmlnaHRccmluMFxsaW4wXGl0\n" +
                    "YXAwIFxydGxjaFxmY3MxIFxhZjBcYWZzMjRcYWxhbmcxMDI1IFxsdHJjaFxmY3MwIA0KXGZzMjFc\n" +
                    "bGFuZzEwMzNcbGFuZ2ZlMjA1MlxrZXJuaW5nMlxsb2NoXGYwXGhpY2hcYWYwXGRiY2hcYWYxM1xj\n" +
                    "Z3JpZFxsYW5nbnAxMDMzXGxhbmdmZW5wMjA1MiBcc25leHQwIE5vcm1hbDt9e1wqXGNzMTAgXGFk\n" +
                    "ZGl0aXZlIFxzc2VtaWhpZGRlbiBEZWZhdWx0IFBhcmFncmFwaCBGb250O317XCoNClx0czExXHRz\n" +
                    "cm93ZFx0cmZ0c1dpZHRoQjNcdHJwYWRkbDEwOFx0cnBhZGRyMTA4XHRycGFkZGZsM1x0cnBhZGRm\n" +
                    "dDNcdHJwYWRkZmIzXHRycGFkZGZyM1x0cmNicGF0MVx0cmNmcGF0MVx0YmxpbmQwXHRibGluZHR5\n" +
                    "cGUzXHRzY2VsbHdpZHRoZnRzMFx0c3ZlcnRhbHRcdHNicmRydFx0c2JyZHJsXHRzYnJkcmJcdHNi\n" +
                    "cmRyclx0c2JyZHJkZ2xcdHNicmRyZGdyXHRzYnJkcmhcdHNicmRydiANClxxbCBcbGkwXHJpMFx3\n" +
                    "aWRjdGxwYXJcd3JhcGRlZmF1bHRcYXNwYWxwaGFcYXNwbnVtXGZhYXV0b1xhZGp1c3RyaWdodFxy\n" +
                    "aW4wXGxpbjBcaXRhcDAgXHJ0bGNoXGZjczEgXGFmMFxhZnMyMCBcbHRyY2hcZmNzMCBcZnMyMFxs\n" +
                    "YW5nMTAyNFxsYW5nZmUxMDI0XGxvY2hcZjBcaGljaFxhZjBcZGJjaFxhZjEzXGNncmlkXGxhbmdu\n" +
                    "cDEwMjRcbGFuZ2ZlbnAxMDI0IFxzbmV4dDExIFxzc2VtaWhpZGRlbiBOb3JtYWwgVGFibGU7fXsN\n" +
                    "ClxzMTVccWMgXGxpMFxyaTBcbm93aWRjdGxwYXJcYnJkcmJcYnJkcnNcYnJkcncxNVxicnNwMjAg\n" +
                    "XHRxY1x0eDQxNTNcdHFyXHR4ODMwNlx3cmFwZGVmYXVsdFxhc3BhbHBoYVxhc3BudW1cZmFhdXRv\n" +
                    "XG5vc25hcGxpbmVncmlkXGFkanVzdHJpZ2h0XHJpbjBcbGluMFxpdGFwMCBccnRsY2hcZmNzMSBc\n" +
                    "YWYwXGFmczE4XGFsYW5nMTAyNSBcbHRyY2hcZmNzMCANClxmczE4XGxhbmcxMDMzXGxhbmdmZTIw\n" +
                    "NTJca2VybmluZzJcbG9jaFxmMFxoaWNoXGFmMFxkYmNoXGFmMTNcY2dyaWRcbGFuZ25wMTAzM1xs\n" +
                    "YW5nZmVucDIwNTIgXHNiYXNlZG9uMCBcc25leHQxNSBcc3R5cnNpZDE1MDk4NjIzIGhlYWRlcjt9\n" +
                    "e1xzMTZccWwgXGxpMFxyaTBcbm93aWRjdGxwYXINClx0cWNcdHg0MTUzXHRxclx0eDgzMDZcd3Jh\n" +
                    "cGRlZmF1bHRcYXNwYWxwaGFcYXNwbnVtXGZhYXV0b1xub3NuYXBsaW5lZ3JpZFxhZGp1c3RyaWdo\n" +
                    "dFxyaW4wXGxpbjBcaXRhcDAgXHJ0bGNoXGZjczEgXGFmMFxhZnMxOFxhbGFuZzEwMjUgXGx0cmNo\n" +
                    "XGZjczAgXGZzMThcbGFuZzEwMzNcbGFuZ2ZlMjA1MlxrZXJuaW5nMlxsb2NoXGYwXGhpY2hcYWYw\n" +
                    "XGRiY2hcYWYxM1xjZ3JpZFxsYW5nbnAxMDMzXGxhbmdmZW5wMjA1MiANClxzYmFzZWRvbjAgXHNu\n" +
                    "ZXh0MTYgXHN0eXJzaWQxNTA5ODYyMyBmb290ZXI7fXtcKlxjczE3IFxhZGRpdGl2ZSBccnRsY2hc\n" +
                    "ZmNzMSBcYWYwIFxsdHJjaFxmY3MwIFx1bFxjZjIgXHNiYXNlZG9uMTAgXHN0eXJzaWQxNTA5ODYy\n" +
                    "MyBIeXBlcmxpbms7fX17XCpcbGF0ZW50c3R5bGVzXGxzZHN0aW1heDE1Nlxsc2Rsb2NrZWRkZWYw\n" +
                    "fXtcKlxwZ3B0Ymwge1xwZ3BcaXBncDBcaXRhcDBcbGkwXHJpMFxzYjBcc2EwfX17XCpccnNpZHRi\n" +
                    "bCBccnNpZDY1NTc2NA0KXHJzaWQ4MTEzNThccnNpZDEwNjkwMTJccnNpZDEzMTg3ODZccnNpZDE0\n" +
                    "NjI1NDJccnNpZDIyMzEyOTBccnNpZDI4NDcwMTBccnNpZDI5MDkzNTBccnNpZDMxNDY1MjlccnNp\n" +
                    "ZDMxNTIzNjhccnNpZDMxNTM2NDRccnNpZDM0MDk1NDlccnNpZDM4Njk0OTZccnNpZDQwMDEwODRc\n" +
                    "cnNpZDQ0MTk2NDJccnNpZDQ0NzcwOTBccnNpZDU4NDg4MTJccnNpZDY0OTMzNjhccnNpZDc5Mzkw\n" +
                    "OThccnNpZDg2NzQ2NzdccnNpZDg5NDQ0MzhccnNpZDk0NDkwOTYNClxyc2lkMTAyMzY3MjdccnNp\n" +
                    "ZDEwMjQ2OTA0XHJzaWQxMDUwNTY2OFxyc2lkMTA4OTc1NDJccnNpZDExMjgyMTg2XHJzaWQxMTk0\n" +
                    "MTg5M1xyc2lkMTI2Njk4MjFccnNpZDEzMzEyMjYzXHJzaWQxMzc3MzE3Nlxyc2lkMTQ3MDc1NjRc\n" +
                    "cnNpZDE1MDk4NjIzXHJzaWQxNTIyMjg3M1xyc2lkMTU2MTE3ODJccnNpZDE1NjY1NzAzXHJzaWQx\n" +
                    "NTgxNzM2N1xyc2lkMTU4NjYzNjFccnNpZDE2MDgwNzMwXHJzaWQxNjE5NTQwNFxyc2lkMTY1MTc2\n" +
                    "NjENClxyc2lkMTY2MDc4OTh9e1wqXGdlbmVyYXRvciBNaWNyb3NvZnQgV29yZCAxMS4wLjAwMDA7\n" +
                    "fXtcaW5mb3tcdGl0bGUgMjAxMcTqv7zR0Mr90afI/dXmzOK8sLTwsLi94s72fXtcc3ViamVjdCAy\n" +
                    "MDExxOq/vNHQyv3Rp8j91ebM4rywtPCwuL3izvZ9e1xhdXRob3IgXCdjZVwnYzRcJ2I1XCdiNVwn\n" +
                    "Y2ZcJ2MyXCdkNFwnZDhcJ2NkXCdmOH17XGtleXdvcmRzIFwnY2VcJ2M0XCdiNVwnYjVcJ2NmXCdj\n" +
                    "MlwnZDRcJ2Q4fXtcZG9jY29tbSBodHRwOi8vZG9jLnh1ZWhhaS5uZXQvYjQzMzIyOGUyZTk5OTRh\n" +
                    "OTUzZDhjNWFiOTYyMDMyZjEzY2NkYjllYzcuaHRtbH17XG9wZXJhdG9yIGRvYy54dWVoYWkubmV0\n" +
                    "fQ0Ke1xjcmVhdGltXHlyMjAxMFxtbzlcZHkyOFxocjIyXG1pbjl9e1xyZXZ0aW1ceXIyMDEzXG1v\n" +
                    "MTFcZHkxMFxocjEwXG1pbjU5fXtcdmVyc2lvbjIwfXtcZWRtaW5zMTA2NX17XG5vZnBhZ2VzMX17\n" +
                    "XG5vZndvcmRzNTR9e1xub2ZjaGFyczMwOH17XCpcbWFuYWdlciBodHRwczovL2RvYy54dWVoYWku\n" +
                    "bmV0L317XCpcY29tcGFueSBodHRwczovL2RvYy54dWVoYWkubmV0L317XCpcY2F0ZWdvcnkgXCdj\n" +
                    "ZVwnYzRcJ2I1XCdiNVwnY2ZcJ2MyXCdkNFwnZDh9DQp7XG5vZmNoYXJzd3MzNjF9e1x2ZXJuMjQ2\n" +
                    "MTN9e1wqXHBhc3N3b3JkIDAwMDAwMDAwfX17XCpceG1sbnN0Ymwge1x4bWxuczEgaHR0cDovL3Nj\n" +
                    "aGVtYXMubWljcm9zb2Z0LmNvbS9vZmZpY2Uvd29yZC8yMDAzL3dvcmRtbH17XHhtbG5zMiB1cm46\n" +
                    "c2NoZW1hcy1taWNyb3NvZnQtY29tOm9mZmljZTpzbWFydHRhZ3N9fQ0KXHBhcGVydzExOTA2XHBh\n" +
                    "cGVyaDE2ODM4XG1hcmdsMTEzNFxtYXJncjExMzRcbWFyZ3QxMTM0XG1hcmdiMTEzNFxndXR0ZXIw\n" +
                    "XGx0cnNlY3QgDQpcZGVmdGFiNDIwXGZ0bmJqXGFlbmRkb2NcZG9ub3RlbWJlZHN5c2ZvbnQxXGRv\n" +
                    "bm90ZW1iZWRsaW5nZGF0YTBcZ3JmZG9jZXZlbnRzMFx2YWxpZGF0ZXhtbDFcc2hvd3BsYWNlaG9s\n" +
                    "ZHRleHQwXGlnbm9yZW1peGVkY29udGVudDBcc2F2ZWludmFsaWR4bWwwXHNob3d4bWxlcnJvcnMx\n" +
                    "XGZvcm1zaGFkZVxob3J6ZG9jXGRnbWFyZ2luXGRnaHNwYWNlMTgwXGRndnNwYWNlMTU2XGRnaG9y\n" +
                    "aWdpbjExMzRcZGd2b3JpZ2luMTEzNFxkZ2hzaG93MA0KXGRndnNob3cyXGpjb21wcmVzc1xsbm9u\n" +
                    "Z3JpZFx2aWV3a2luZDFcdmlld3NjYWxlODVcc3BseXR3bmluZVxmdG5seXR3bmluZVxodG1hdXRz\n" +
                    "cFx1c2VsdGJhbG5cYWxudGJsaW5kXGx5dGNhbGN0Ymx3ZFxseXR0YmxydGdyXGxuYnJrcnVsZVxu\n" +
                    "b2Jya3dycHRibFxzbmFwdG9ncmlkaW5jZWxsXGFsbG93ZmllbGRlbmRzZWxcd3JwcHVuY3RcYXNp\n" +
                    "YW5icmtydWxlXHJzaWRyb290Mzg2OTQ5NlxuZXd0YmxzdHlydWxzXG5vZ3Jvd2F1dG9maXQgDQp7\n" +
                    "XCpcZmNoYXJzIA0KISksLjpcJzNiP11cJzdkXCdhMVwnYTdcJ2ExXCdhNFwnYTFcJ2E2XCdhMVwn\n" +
                    "YTVcJ2E4XCc0NFwnYTFcJ2FjXCdhMVwnYWZcJ2ExXCdiMVwnYTFcJ2FkXCdhMVwnYzNcJ2ExXCdh\n" +
                    "MlwnYTFcJ2EzXCdhMVwnYThcJ2ExXCdhOVwnYTFcJ2I1XCdhMVwnYjdcJ2ExXCdiOVwnYTFcJ2Ji\n" +
                    "XCdhMVwnYmZcJ2ExXCdiM1wnYTFcJ2JkXCdhM1wnYTFcJ2EzXCdhMlwnYTNcJ2E3XCdhM1wnYTlc\n" +
                    "J2EzXCdhY1wnYTNcJ2FlXCdhM1wnYmFcJ2EzXCdiYlwnYTNcJ2JmXCdhM1wnZGRcJ2EzXCdlMFwn\n" +
                    "YTNcJ2ZjXCdhM1wnZmRcJ2ExXCdhYlwnYTFcJ2U5DQp9e1wqXGxjaGFycyAoW1wnN2JcJ2ExXCdh\n" +
                    "NFwnYTFcJ2FlXCdhMVwnYjBcJ2ExXCdiNFwnYTFcJ2I2XCdhMVwnYjhcJ2ExXCdiYVwnYTFcJ2Jl\n" +
                    "XCdhMVwnYjJcJ2ExXCdiY1wnYTNcJ2E4XCdhM1wnYWVcJ2EzXCdkYlwnYTNcJ2ZiXCdhMVwnZWFc\n" +
                    "J2EzXCdhNH1cZmV0MHtcKlx3Z3JmZm10ZmlsdGVyIDAxM2Z9XGlsZm9tYWNhdGNsbnVwMHtcKlx0\n" +
                    "ZW1wbGF0ZSANCkM6XFxEb2N1bWVudHMgYW5kIFNldHRpbmdzXFxBZG1pbmlzdHJhdG9yXFxcJ2Q3\n" +
                    "XCdjMFwnYzNcJ2U2XFxkb2MuZG90fXtcKlxmdG5zZXAgXGx0cnBhciBccGFyZFxwbGFpbiBcbHRy\n" +
                    "cGFyXHFqIFxsaTBccmkwXG5vd2lkY3RscGFyXHdyYXBkZWZhdWx0XGFzcGFscGhhXGFzcG51bVxm\n" +
                    "YWF1dG9cYWRqdXN0cmlnaHRccmluMFxsaW4wXGl0YXAwIFxydGxjaFxmY3MxIFxhZjBcYWZzMjRc\n" +
                    "YWxhbmcxMDI1IFxsdHJjaFxmY3MwIA0KXGZzMjFcbGFuZzEwMzNcbGFuZ2ZlMjA1MlxrZXJuaW5n\n" +
                    "Mlxsb2NoXGFmMFxoaWNoXGFmMFxkYmNoXGFmMTNcY2dyaWRcbGFuZ25wMTAzM1xsYW5nZmVucDIw\n" +
                    "NTIge1xydGxjaFxmY3MxIFxhZjAgXGx0cmNoXGZjczAgXGluc3JzaWQxNDcwNzU2NCBcY2hmdG5z\n" +
                    "ZXAgDQpccGFyIH19e1wqXGZ0bnNlcGMgXGx0cnBhciBccGFyZFxwbGFpbiBcbHRycGFyXHFqIFxs\n" +
                    "aTBccmkwXG5vd2lkY3RscGFyXHdyYXBkZWZhdWx0XGFzcGFscGhhXGFzcG51bVxmYWF1dG9cYWRq\n" +
                    "dXN0cmlnaHRccmluMFxsaW4wXGl0YXAwIFxydGxjaFxmY3MxIFxhZjBcYWZzMjRcYWxhbmcxMDI1\n" +
                    "IFxsdHJjaFxmY3MwIA0KXGZzMjFcbGFuZzEwMzNcbGFuZ2ZlMjA1MlxrZXJuaW5nMlxsb2NoXGFm\n" +
                    "MFxoaWNoXGFmMFxkYmNoXGFmMTNcY2dyaWRcbGFuZ25wMTAzM1xsYW5nZmVucDIwNTIge1xydGxj\n" +
                    "aFxmY3MxIFxhZjAgXGx0cmNoXGZjczAgXGluc3JzaWQxNDcwNzU2NCBcY2hmdG5zZXBjIA0KXHBh\n" +
                    "ciB9fXtcKlxhZnRuc2VwIFxsdHJwYXIgXHBhcmRccGxhaW4gXGx0cnBhclxxaiBcbGkwXHJpMFxu\n" +
                    "b3dpZGN0bHBhclx3cmFwZGVmYXVsdFxhc3BhbHBoYVxhc3BudW1cZmFhdXRvXGFkanVzdHJpZ2h0\n" +
                    "XHJpbjBcbGluMFxpdGFwMCBccnRsY2hcZmNzMSBcYWYwXGFmczI0XGFsYW5nMTAyNSBcbHRyY2hc\n" +
                    "ZmNzMCANClxmczIxXGxhbmcxMDMzXGxhbmdmZTIwNTJca2VybmluZzJcbG9jaFxhZjBcaGljaFxh\n" +
                    "ZjBcZGJjaFxhZjEzXGNncmlkXGxhbmducDEwMzNcbGFuZ2ZlbnAyMDUyIHtccnRsY2hcZmNzMSBc\n" +
                    "YWYwIFxsdHJjaFxmY3MwIFxpbnNyc2lkMTQ3MDc1NjQgXGNoZnRuc2VwIA0KXHBhciB9fXtcKlxh\n" +
                    "ZnRuc2VwYyBcbHRycGFyIFxwYXJkXHBsYWluIFxsdHJwYXJccWogXGxpMFxyaTBcbm93aWRjdGxw\n" +
                    "YXJcd3JhcGRlZmF1bHRcYXNwYWxwaGFcYXNwbnVtXGZhYXV0b1xhZGp1c3RyaWdodFxyaW4wXGxp\n" +
                    "bjBcaXRhcDAgXHJ0bGNoXGZjczEgXGFmMFxhZnMyNFxhbGFuZzEwMjUgXGx0cmNoXGZjczAgDQpc\n" +
                    "ZnMyMVxsYW5nMTAzM1xsYW5nZmUyMDUyXGtlcm5pbmcyXGxvY2hcYWYwXGhpY2hcYWYwXGRiY2hc\n" +
                    "YWYxM1xjZ3JpZFxsYW5nbnAxMDMzXGxhbmdmZW5wMjA1MiB7XHJ0bGNoXGZjczEgXGFmMCBcbHRy\n" +
                    "Y2hcZmNzMCBcaW5zcnNpZDE0NzA3NTY0IFxjaGZ0bnNlcGMgDQpccGFyIH19XGx0cnBhciBcc2Vj\n" +
                    "dGQgXGx0cnNlY3RcbGluZXgwXGhlYWRlcnk4NTFcZm9vdGVyeTk5Mlxjb2xzeDQyNVxlbmRuaGVy\n" +
                    "ZVxzZWN0bGluZWdyaWQzMTJcc2VjdHNwZWNpZnlsXHNlY3Ryc2lkNjQ5MzM2OFxzZnRuYmoge1xo\n" +
                    "ZWFkZXJyIFxsdHJwYXIgXHBhcmRccGxhaW4gXGx0cnBhclxzMTVccWMgXGxpMFxyaTBcbm93aWRj\n" +
                    "dGxwYXJcYnJkcmJcYnJkcnNcYnJkcncxNVxicnNwMjAgDQpcdHFjXHR4NDE1M1x0cXJcdHg4MzA2\n" +
                    "XHdyYXBkZWZhdWx0XGFzcGFscGhhXGFzcG51bVxmYWF1dG9cbm9zbmFwbGluZWdyaWRcYWRqdXN0\n" +
                    "cmlnaHRccmluMFxsaW4wXGl0YXAwIFxydGxjaFxmY3MxIFxhZjBcYWZzMThcYWxhbmcxMDI1IFxs\n" +
                    "dHJjaFxmY3MwIFxmczE4XGxhbmcxMDMzXGxhbmdmZTIwNTJca2VybmluZzJcbG9jaFxhZjBcaGlj\n" +
                    "aFxhZjBcZGJjaFxhZjEzXGNncmlkXGxhbmducDEwMzNcbGFuZ2ZlbnAyMDUyIHtccnRsY2hcZmNz\n" +
                    "MSANClxhZjBcYWZzMjQgXGx0cmNoXGZjczAgXGJcZjEzXGZzMjRcY2Y2XGluc3JzaWQxMTk0MTg5\n" +
                    "MyBcbG9jaFxhZjEzXGhpY2hcYWYxM1xkYmNoXGYxMyBcJ2NlXCdjNFwnYjVcJ2I1fXtccnRsY2hc\n" +
                    "ZmNzMSBcYWYwXGFmczI0IFxsdHJjaFxmY3MwIFxiXGYxM1xmczI0XGNmNlxpbnNyc2lkNjQ5MzM2\n" +
                    "OFxjaGFycnNpZDE1MDk4NjIzIFxsb2NoXGFmMTNcaGljaFxhZjEzXGRiY2hcZjEzIFwnY2ZcJ2My\n" +
                    "XCdkNFwnZDh9e1xydGxjaFxmY3MxIA0KXGFmMFxhZnMyNCBcbHRyY2hcZmNzMCBcYlxmMTNcZnMy\n" +
                    "NFxjZjZcaW5zcnNpZDY0OTMzNjhcY2hhcnJzaWQxNTA5ODYyMyBcaGljaFxhZjEzXGRiY2hcYWYx\n" +
                    "M1xsb2NoXGYxMyAgfXtccnRsY2hcZmNzMSBcYWYwXGFmczI0IFxsdHJjaFxmY3MwIFxiXGYxM1xm\n" +
                    "czI0XGNmNlxpbnNyc2lkNjQ5MzM2OFxjaGFycnNpZDE1MDk4NjIzIFxsb2NoXGFmMTNcaGljaFxh\n" +
                    "ZjEzXGRiY2hcZjEzIFwnYzNcJ2UyXCdiN1wnZDFcJ2NlXCdjNFwnYjVcJ2I1DQpcJ2NmXCdjMlwn\n" +
                    "ZDRcJ2Q4fXtccnRsY2hcZmNzMSBcYWYwXGFmczI0IFxsdHJjaFxmY3MwIFxiXGZzMjRcY2Y2XGxv\n" +
                    "Y2hcYWYxM1xpbnNyc2lkNjQ5MzM2OFxjaGFycnNpZDE1MDk4NjIzIA0KXHBhciB9e1xmaWVsZFxm\n" +
                    "bGRlZGl0e1wqXGZsZGluc3Qge1xydGxjaFxmY3MxIFxhZjBcYWZzMzIgXGx0cmNoXGZjczAgXGYx\n" +
                    "M1xmczMyXGNmNlxpbnNyc2lkMzE0NjUyOSBcaGljaFxhZjEzXGRiY2hcYWYxM1xsb2NoXGYxMyBI\n" +
                    "WVBFUkxJTksgImh0dHBzOi8vZG9jLnh1ZWhhaS5uZXQvIn17XHJ0bGNoXGZjczEgXGFmMFxhZnMz\n" +
                    "MiBcbHRyY2hcZmNzMCBcZjEzXGZzMzJcY2Y2XGluc3JzaWQzMTQ2NTI5XGNoYXJyc2lkMzE0NjUy\n" +
                    "OSB7XCpcZGF0YWZpZWxkIA0KMDBkMGM5ZWE3OWY5YmFjZTExOGM4MjAwYWEwMDRiYTkwYjAyMDAw\n" +
                    "MDAwMDMwMDAwMDBlMGM5ZWE3OWY5YmFjZTExOGM4MjAwYWEwMDRiYTkwYjQ2MDAwMDAwNjgwMDc0\n" +
                    "MDA3NDAwNzAwMDNhMDAyZjAwMmYwMDY0MDA2ZjAwNjMwMDJlMDA3NzAwNjUwMDZlMDA2NDAwNmYw\n" +
                    "MDYzMDAyZTAwNjMwMDZmMDA2ZDAwMmYwMDAwMDA3OTU4ODFmNDNiMWQ3ZjQ4YWYyYzgyNWRjNDg1\n" +
                    "Mjc2MzAwMDAwMDAwYTVhYjAwMDB9fX17XGZsZHJzbHQgew0KXHJ0bGNoXGZjczEgXGFmMFxhZnMz\n" +
                    "MiBcbHRyY2hcZmNzMCBcY3MxN1xmMTNcZnMzMlx1bFxjZjJcaW5zcnNpZDMxNDY1MjkgXGhpY2hc\n" +
                    "YWYxM1xkYmNoXGFmMTNcbG9jaFxmMTMgaHR0cHM6Ly9kb2MueHVlaGFpLm5ldC99fX1cc2VjdGQg\n" +
                    "XGxpbmV4MFxlbmRuaGVyZVxzZWN0ZGVmYXVsdGNsXHNmdG5iaiB7XHJ0bGNoXGZjczEgXGFmMFxh\n" +
                    "ZnMzMiBcbHRyY2hcZmNzMCANClxmczMyXGNmNlxsb2NoXGFmMTNcaW5zcnNpZDY0OTMzNjhcY2hh\n" +
                    "cnJzaWQxNTA5ODYyMyANClxwYXIgfX17XCpccG5zZWNsdmwxXHBudWNybVxwbnN0YXJ0MVxwbmlu\n" +
                    "ZGVudDcyMFxwbmhhbmcge1xwbnR4dGEgXGRiY2ggLn19e1wqXHBuc2VjbHZsMlxwbnVjbHRyXHBu\n" +
                    "c3RhcnQxXHBuaW5kZW50NzIwXHBuaGFuZyB7XHBudHh0YSBcZGJjaCAufX17XCpccG5zZWNsdmwz\n" +
                    "XHBuZGVjXHBuc3RhcnQxXHBuaW5kZW50NzIwXHBuaGFuZyB7XHBudHh0YSBcZGJjaCAufX17XCpc\n" +
                    "cG5zZWNsdmw0XHBubGNsdHJccG5zdGFydDFccG5pbmRlbnQ3MjBccG5oYW5nIA0Ke1xwbnR4dGEg\n" +
                    "XGRiY2ggKX19e1wqXHBuc2VjbHZsNVxwbmRlY1xwbnN0YXJ0MVxwbmluZGVudDcyMFxwbmhhbmcg\n" +
                    "e1xwbnR4dGIgXGRiY2ggKH17XHBudHh0YSBcZGJjaCApfX17XCpccG5zZWNsdmw2XHBubGNsdHJc\n" +
                    "cG5zdGFydDFccG5pbmRlbnQ3MjBccG5oYW5nIHtccG50eHRiIFxkYmNoICh9e1xwbnR4dGEgXGRi\n" +
                    "Y2ggKX19e1wqXHBuc2VjbHZsN1xwbmxjcm1ccG5zdGFydDFccG5pbmRlbnQ3MjBccG5oYW5nIHtc\n" +
                    "cG50eHRiIFxkYmNoICh9DQp7XHBudHh0YSBcZGJjaCApfX17XCpccG5zZWNsdmw4XHBubGNsdHJc\n" +
                    "cG5zdGFydDFccG5pbmRlbnQ3MjBccG5oYW5nIHtccG50eHRiIFxkYmNoICh9e1xwbnR4dGEgXGRi\n" +
                    "Y2ggKX19e1wqXHBuc2VjbHZsOVxwbmxjcm1ccG5zdGFydDFccG5pbmRlbnQ3MjBccG5oYW5nIHtc\n" +
                    "cG50eHRiIFxkYmNoICh9e1xwbnR4dGEgXGRiY2ggKX19XHBhcmRccGxhaW4gXGx0cnBhclxxaiBc\n" +
                    "bGkwXHJpMFxzbDE4MFxzbG11bHQwDQpcbm93aWRjdGxwYXJcd3JhcGRlZmF1bHRcYXNwYWxwaGFc\n" +
                    "YXNwbnVtXGZhYXV0b1xhZGp1c3RyaWdodFxyaW4wXGxpbjBcaXRhcDBccGFyYXJzaWQ2NDkzMzY4\n" +
                    "IFxydGxjaFxmY3MxIFxhZjBcYWZzMjRcYWxhbmcxMDI1IFxsdHJjaFxmY3MwIFxmczIxXGxhbmcx\n" +
                    "MDMzXGxhbmdmZTIwNTJca2VybmluZzJcbG9jaFxhZjBcaGljaFxhZjBcZGJjaFxhZjEzXGNncmlk\n" +
                    "XGxhbmducDEwMzNcbGFuZ2ZlbnAyMDUyIHtccnRsY2hcZmNzMSBcYWYwIA0KXGx0cmNoXGZjczAg\n" +
                    "XGluc3JzaWQ2NDkzMzY4IFxsb2NoXGFmMFxoaWNoXGFmMFxkYmNoXGYxMyBcJ2ExXCdhMVwnYTFc\n" +
                    "J2ExfXtccnRsY2hcZmNzMSBcYWYwIFxsdHJjaFxmY3MwIFxpbnNyc2lkNjQ5MzM2OCANClxwYXIg\n" +
                    "fVxwYXJkIFxsdHJwYXJccWMgXGxpMFxyaTBcc2wxODBcc2xtdWx0MFxub3dpZGN0bHBhclx3cmFw\n" +
                    "ZGVmYXVsdFxhc3BhbHBoYVxhc3BudW1cZmFhdXRvXGFkanVzdHJpZ2h0XHJpbjBcbGluMFxpdGFw\n" +
                    "MFxwYXJhcnNpZDEzMTg3ODYge1xydGxjaFxmY3MxIFxhZjBcYWZzMzYgXGx0cmNoXGZjczAgXGJc\n" +
                    "ZjEzXGZzMzZcaW5zcnNpZDEzMTg3ODZcY2hhcnJzaWQxNTg2NjM2MSBcaGljaFxhZjEzXGRiY2hc\n" +
                    "YWYxM1xsb2NoXGYxMyAyMDExxOq/vNHQyv3Rp8j91ebM4rywtPCwuL3izvZ9DQp7XHJ0bGNoXGZj\n" +
                    "czEgXGFmMFxhZnMzNiBcbHRyY2hcZmNzMCBcYlxmczM2XGluc3JzaWQxMzE4Nzg2XGNoYXJyc2lk\n" +
                    "MTU4NjYzNjEgDQpccGFyIH1ccGFyZCBcbHRycGFyXHFjIFxsaTBccmkwXHNsMTgwXHNsbXVsdDBc\n" +
                    "bm93aWRjdGxwYXJcd3JhcGRlZmF1bHRcYXNwYWxwaGFcYXNwbnVtXGZhYXV0b1xhZGp1c3RyaWdo\n" +
                    "dFxyaW4wXGxpbjBcaXRhcDBccGFyYXJzaWQxNTgxNzM2NyB7XHJ0bGNoXGZjczEgXGFmMCBcbHRy\n" +
                    "Y2hcZmNzMCBcZnMyNFxpbnNyc2lkMTMxODc4NiANClxwYXIgDQpccGFyIH17XHJ0bGNoXGZjczEg\n" +
                    "XGFmMCBcbHRyY2hcZmNzMCBcZnMyNFxpbnNyc2lkNjQ5MzM2OFxjaGFycnNpZDY0OTMzNjggXGxv\n" +
                    "Y2hcYWYwXGhpY2hcYWYwXGRiY2hcZjEzIFwnYjFcJ2JlXCdjZVwnYzRcJ2I1XCdiNVwnY2ZcJ2My\n" +
                    "XCdkNFwnZDhcJ2Q3XCdkNH17XGZpZWxkXGZsZGVkaXR7XCpcZmxkaW5zdCB7XHJ0bGNoXGZjczEg\n" +
                    "XGFmMCBcbHRyY2hcZmNzMCBcZnMyNFxjZjExXGluc3JzaWQzMTQ2NTI5IA0KXGhpY2hcYWYwXGRi\n" +
                    "Y2hcYWYxM1xsb2NoXGYwIEhZUEVSTElOSyAiaHR0cHM6Ly9kb2MueHVlaGFpLm5ldC8ifXtccnRs\n" +
                    "Y2hcZmNzMSBcYWYwIFxsdHJjaFxmY3MwIFxmczI0XGNmMTFcaW5zcnNpZDMxNDY1MjlcY2hhcnJz\n" +
                    "aWQzMTQ2NTI5IHtcKlxkYXRhZmllbGQgDQowMGQwYzllYTc5ZjliYWNlMTE4YzgyMDBhYTAwNGJh\n" +
                    "OTBiMDIwMDAwMDAwMzAwMDAwMGUwYzllYTc5ZjliYWNlMTE4YzgyMDBhYTAwNGJhOTBiNDYwMDAw\n" +
                    "MDA2ODAwNzQwMDc0MDA3MDAwM2EwMDJmMDAyZjAwNjQwMDZmMDA2MzAwMmUwMDc3MDA2NTAwNmUw\n" +
                    "MDY0MDA2ZjAwNjMwMDJlMDA2MzAwNmYwMDZkMDAyZjAwMDAwMDc5NTg4MWY0M2IxZDdmNDhhZjJj\n" +
                    "ODI1ZGM0ODUyNzYzMDAwMDAwMDBhNWFiMDAwMH19fXtcZmxkcnNsdCB7DQpccnRsY2hcZmNzMSBc\n" +
                    "YWYwIFxsdHJjaFxmY3MwIFxjczE3XGZzMjRcdWxcY2YyXGluc3JzaWQxMTk0MTg5MyBcbG9jaFxh\n" +
                    "ZjBcaGljaFxhZjBcZGJjaFxmMTMgXCdjZVwnYzRcJ2I1XCdiNX17XHJ0bGNoXGZjczEgXGFmMCBc\n" +
                    "bHRyY2hcZmNzMCBcY3MxN1xmczI0XHVsXGNmMlxpbnNyc2lkNjQ5MzM2OFxjaGFycnNpZDY0OTMz\n" +
                    "NjggXGxvY2hcYWYwXGhpY2hcYWYwXGRiY2hcZjEzIFwnY2ZcJ2MyXCdkNFwnZDhcJ2NkXCdmOH19\n" +
                    "fVxzZWN0ZCANClxsaW5leDBcaGVhZGVyeTg1MVxmb290ZXJ5OTkyXGNvbHN4NDI1XGVuZG5oZXJl\n" +
                    "XHNlY3RsaW5lZ3JpZDMxMlxzZWN0c3BlY2lmeWxcc2VjdHJzaWQ2NDkzMzY4XHNmdG5iaiB7XHJ0\n" +
                    "bGNoXGZjczEgXGFmMCBcbHRyY2hcZmNzMCBcZnMyNFxpbnNyc2lkMTY2MDc4OTggXGxvY2hcYWYw\n" +
                    "XGhpY2hcYWYwXGRiY2hcZjEzIFwnYTNcJ2FjXCdjNFwnZGFcJ2M4XCdkZH17XHJ0bGNoXGZjczEg\n" +
                    "XGFmMCBcbHRyY2hcZmNzMCANClxmczI0XGluc3JzaWQ2NDkzMzY4XGNoYXJyc2lkNjQ5MzM2OCBc\n" +
                    "bG9jaFxhZjBcaGljaFxhZjBcZGJjaFxmMTMgXCdiZlwnYzlcJ2M0XCdkY1wnYjJcJ2JiXCdjZFwn\n" +
                    "ZWFcJ2Q1XCdmYlwnYTNcJ2FjXCdjNFwnZmFcJ2JmXCdjOVwnZDJcJ2Q0fXtccnRsY2hcZmNzMSBc\n" +
                    "YWYwIFxsdHJjaFxmY3MwIFxmczI0XGluc3JzaWQ4Njc0Njc3IFxsb2NoXGFmMFxoaWNoXGFmMFxk\n" +
                    "YmNoXGYxMyBcJ2I4XCdiNFwnZDZcJ2M2fXtccnRsY2hcZmNzMSBcYWYwIA0KXGx0cmNoXGZjczAg\n" +
                    "XGZzMjRcaW5zcnNpZDY0OTMzNjhcY2hhcnJzaWQ2NDkzMzY4IFxsb2NoXGFmMFxoaWNoXGFmMFxk\n" +
                    "YmNoXGYxMyBcJ2QyXCdkNFwnY2ZcJ2MyXCdjZFwnZjhcJ2Q2XCdiN1wnYmNcJ2NjXCdkMFwnZjhc\n" +
                    "J2Q0XCdjNFwnYjZcJ2MxXCdiYlwnZjJcJ2NmXCdjMlwnZDRcJ2Q4fXtccnRsY2hcZmNzMSBcYWYw\n" +
                    "IFxsdHJjaFxmY3MwIFxmczI0XGluc3JzaWQ2NDkzMzY4IFxsb2NoXGFmMFxoaWNoXGFmMFxkYmNo\n" +
                    "XGYxMyBcJ2EzXCdiYX17DQpccnRsY2hcZmNzMSBcYWYwIFxsdHJjaFxmY3MwIFxmczI0XGluc3Jz\n" +
                    "aWQ2NDkzMzY4IA0KXHBhciB9XHBhcmQgXGx0cnBhclxxYyBcbGkwXHJpMFxzbDE4MFxzbG11bHQw\n" +
                    "XG5vd2lkY3RscGFyXHdyYXBkZWZhdWx0XGFzcGFscGhhXGFzcG51bVxmYWF1dG9cYWRqdXN0cmln\n" +
                    "aHRccmluMFxsaW4wXGl0YXAwXHBhcmFyc2lkMzg2OTQ5NiB7XGZpZWxke1wqXGZsZGluc3Qge1xy\n" +
                    "dGxjaFxmY3MxIFxhZjAgXGx0cmNoXGZjczAgXGZzMjRcaW5zcnNpZDMxNDY1MjkgXGhpY2hcYWYw\n" +
                    "XGRiY2hcYWYxM1xsb2NoXGYwIA0KSFlQRVJMSU5LICJodHRwczovL2RvYy54dWVoYWkubmV0LyJ9\n" +
                    "e1xydGxjaFxmY3MxIFxhZjAgXGx0cmNoXGZjczAgXGZzMjRcaW5zcnNpZDMxNDY1MjlcY2hhcnJz\n" +
                    "aWQzMTQ2NTI5IHtcKlxkYXRhZmllbGQgDQowMGQwYzllYTc5ZjliYWNlMTE4YzgyMDBhYTAwNGJh\n" +
                    "OTBiMDIwMDAwMDAwMzAwMDAwMGUwYzllYTc5ZjliYWNlMTE4YzgyMDBhYTAwNGJhOTBiNDYwMDAw\n" +
                    "MDA2ODAwNzQwMDc0MDA3MDAwM2EwMDJmMDAyZjAwNjQwMDZmMDA2MzAwMmUwMDc3MDA2NTAwNmUw\n" +
                    "MDY0MDA2ZjAwNjMwMDJlMDA2MzAwNmYwMDZkMDAyZjAwMDAwMDc5NTg4MWY0M2IxZDdmNDhhZjJj\n" +
                    "ODI1ZGM0ODUyNzYzMDAwMDAwMDBhNWFiMDAwMH19fXtcZmxkcnNsdCB7DQpccnRsY2hcZmNzMSBc\n" +
                    "YWYwIFxsdHJjaFxmY3MwIFxjczE3XGZzMjRcdWxcY2YyXGluc3JzaWQzODY5NDk2XGNoYXJyc2lk\n" +
                    "MTU4NjYzNjEgXGhpY2hcYWYwXGRiY2hcYWYxM1xsb2NoXGYwIGh0dHA6Ly9kb2MueHVlaGFpLm5l\n" +
                    "dC9iNDMzMjI4ZTJlOTk5NGE5NTNkOGM1YWI5NjIwMzJmMTNjY2RiOWVjNy5odG1sfX19XHNlY3Rk\n" +
                    "IFxsaW5leDBcaGVhZGVyeTg1MVxmb290ZXJ5OTkyXGNvbHN4NDI1XGVuZG5oZXJlXHNlY3RsaW5l\n" +
                    "Z3JpZDMxMlxzZWN0c3BlY2lmeWxcc2VjdHJzaWQ2NDkzMzY4XHNmdG5iaiANCntccnRsY2hcZmNz\n" +
                    "MSBcYWYwIFxsdHJjaFxmY3MwIFxmczI0XGluc3JzaWQ2NDkzMzY4XGNoYXJyc2lkNjQ5MzM2OCAN\n" +
                    "ClxwYXIgfVxwYXJkIFxsdHJwYXJccWogXGxpMFxyaTBcc2wxODBcc2xtdWx0MFxub3dpZGN0bHBh\n" +
                    "clx3cmFwZGVmYXVsdFxhc3BhbHBoYVxhc3BudW1cZmFhdXRvXGFkanVzdHJpZ2h0XHJpbjBcbGlu\n" +
                    "MFxpdGFwMFxwYXJhcnNpZDY0OTMzNjgge1xydGxjaFxmY3MxIFxhZjAgXGx0cmNoXGZjczAgXGlu\n" +
                    "c3JzaWQ2NDkzMzY4IA0KXHBhciANClxwYXIgDQpccGFyIH1ccGFyZCBcbHRycGFyXHFqIFxsaTBc\n" +
                    "cmkwXHNsMzYwXHNsbXVsdDFcbm93aWRjdGxwYXJcd3JhcGRlZmF1bHRcYXNwYWxwaGFcYXNwbnVt\n" +
                    "XGZhYXV0b1xhZGp1c3RyaWdodFxyaW4wXGxpbjBcaXRhcDBccGFyYXJzaWQxNTg2NjM2MSB7XHJ0\n" +
                    "bGNoXGZjczEgXGFmMCBcbHRyY2hcZmNzMCBcZjEzXGZzMjRcaW5zcnNpZDM4Njk0OTZcY2hhcnJz\n" +
                    "aWQxNTg2NjM2MSBcaGljaFxhZjEzXGRiY2hcYWYxM1xsb2NoXGYxMyAyMDExxOq/vNHQyv3Rp8j9\n" +
                    "1ebM4rywtPCwuL3izvZccGFyXHBhcg0KW7TLtKbNvMaszrTPwtTYs8m5pl1ccGFyXHBhcg0KMjAx\n" +
                    "McTqv7zR0Mr90aejqMj9o6nV5szivLC08LC4z+q94lxwYXJccGFyDQrSu6Ou0aHU8cziXHBhclxw\n" +
                    "YXINCjEu0tHWqrWxtO3O86OhzrTV0rW90v3Tw9S0oaMweCCh+sqxo6y6r8r9KCkzc2luIHNpbjNm\n" +
                    "IHggeCB4ID0ttO3O86OhzrTV0rW90v3Tw9S0oaPT62tccGFyXHBhcg0KY3ggyse1yLzbzt7H7tCh\n" +
                    "o6zU8lxwYXJccGFyDQqjqEEgo6kgMSw0ayBjID09ICAgo6hCIKOpMSw0ayBjID09LVxwYXJccGFy\n" +
                    "DQqjqEMgo6kgtO3O86OhzrTV0rW90v3Tw9S0oaMgICCjqEQgo6kzLDRrIGMgPT0tXHBhclxwYXIN\n" +
                    "CjKjrtLR1qooKWYgeCDU2jB4ID20pr/JtbyjrMfSKCkwMGYgPaOs1PIoKSgpXHBhclxwYXINCjIz\n" +
                    "M1xwYXJccGFyDQogXHBhclxwYXINCjJsaW1ccGFyXHBhcg0KeCB4IGYgeCBmIHggeFxwYXJccGFy\n" +
                    "DQqh+i09XHBhclxwYXINCqOoQSCjqSgpJzIwZiAtICAgICAgICAgICAgICAgICAgICCjqEIgo6ko\n" +
                    "KScwZiAtXHBhclxwYXINCihDKSAoKScwZiAgICAgICAgICAgICAgICAgICAgICAgIChEKTAgM6Ou\n" +
                    "yeh7fW4gdSDKx8r9wdCjrNTyz8LB0MP8zOLV/ci3tcTKxyAgICCjqEEgo6nI9FxwYXJccGFyDQox\n" +
                    "blxwYXJccGFyDQpuIHVccGFyXHBhcg0Kod5ccGFyXHBhcg0KPaHGytXBsqOs1PJccGFyXHBhcg0K\n" +
                    "KCkyMVxwYXJccGFyDQoyMVxwYXJccGFyDQpuIG4gbiB1XHBhclxwYXINCnUgod5ccGFyXHBhcg0K\n" +
                    "LT0gocbK1cGyXHBhclxwYXINCqOoQiCjqcj0XHBhclxwYXINCigpMjFccGFyXHBhcg0KMjFuIG4g\n" +
                    "biB1XHBhclxwYXINCnUgod5ccGFyXHBhcg0KLT0gocbK1cGyo6zU8jFccGFyXHBhcg0KbiBuIHUg\n" +
                    "od5ccGFyXHBhcg0KPaHGytXBslxwYXJccGFyDQqjqEMgo6nI9FxwYXJccGFyDQoxblxwYXJccGFy\n" +
                    "DQpuIHVccGFyXHBhcg0Kod5ccGFyXHBhcg0KPaHGytXBsqOs1PJccGFyXHBhcg0KKCkyMVxwYXJc\n" +
                    "cGFyDQoyMVxwYXJccGFyDQpuIG4gbiB1XHBhclxwYXINCnUgod5ccGFyXHBhcg0KLT0tocbK1cGy\n" +
                    "XHBhclxwYXINCqOoRCCjqcj0XHBhclxwYXINCigpMjFccGFyXHBhcg0KMjFccGFyXHBhcg0KbiBu\n" +
                    "IG4gdVxwYXJccGFyDQp1IKHeXHBhclxwYXINCi09LaHGytXBsqOs1PIxXHBhclxwYXINCm4gbiB1\n" +
                    "IKHeXHBhclxwYXINCj2hxsrVwbJccGFyaHR0cDovL2RvYy54dWVoYWkubmV0L2I0MzMyMjhlMmU5\n" +
                    "OTk0YTk1M2Q4YzVhYjk2MjAzMmYxM2NjZGI5ZWM3Lmh0bWxccGFyDQo0o67J6DQ0NDBccGFyXHBh\n" +
                    "cg0KIFxwYXJccGFyDQpsbiBzaW4gLGxuIGNvdCAsbG4gY29zIEkgeGR4IEogeGR4IEsgeGR4IKbQ\n" +
                    "ptCm0D1ccGFyXHBhcg0KPT0/XHBhclxwYXINCj8/o6zU8iwsSSBKIEsgtcS089ChudjPtcrHXHBh\n" +
                    "clxwYXINCqOoQSCjqUkgSiBLIFxwYXJccGFyDQo1o67J6EEgzqozvde+2NXzo6y9q0EgtcS12rb+\n" +
                    "wdC807W9tdrSu8HQtcO+2NXzQiCjrNTZvbu7u0IgtcS12rb+0NDT67Xa0rvQ0LXDtaXOu77Y1fMu\n" +
                    "XHBhclxwYXINCrzHMTEwMDExMDAwMVAgPz8/Pz0/Pz8/Pz8sMjEwMDAwMTAxMFAgPz9ccGFyXHBh\n" +
                    "cg0KPz89Pz8/Pz8/XHBhclxwYXINCizU8kEgPVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1Nizybmm\n" +
                    "XVxwYXJccGFyDQqjqEEgo6kxMlBQICAgICAgICAgICAgICAgICAgICAgICAgo6hCIKOpMVxwYXJc\n" +
                    "cGFyDQoxMlAgUCAtIKOoQyCjqTIxUCBQICAgICAgICAgICAgICAgICAgICAgICAgo6hEIKOpMTIx\n" +
                    "UCBQIC1ccGFyXHBhcg0KNqOuyehBIM6qNDM/vtjV86OsMTIzLCymx6bHpsfKx7fHxuu0zs/f0NS3\n" +
                    "vbPM1+lBeCCmwj21xDO49s/f0NTO3rnYtcS94qOsMTIsayBrIM6qyM7S4rOjyv2jrNTyQXggpsI9\n" +
                    "tcTNqL3izqogo6hBIKOpXHBhclxwYXINCigpMjNccGFyXHBhcg0KMTIxMmsgpsemx6bHpscgIC0g\n" +
                    "ICAgICAgICAgICAgIKOoQiCjqVxwYXJccGFyDQooKTIzXHBhclxwYXINCjIyMTJccGFyXHBhcg0K\n" +
                    "ayCmx6bHpsemxy0gLVxwYXJccGFyDQqjqEMgo6koKSgpMlxwYXJccGFyDQozMTMxMjIxMmsgayCm\n" +
                    "x6bHpsemx6bHpscgIC0gLSAgIKOoRCCjqSgpKCkyMzIyMTMzMTJccGFyXHBhcg0KayBrIKbHpsdc\n" +
                    "cGFyXHBhcg0Kpsemx6bHpsctIC0gLSA3o67J6CgpKCkxMixGIHggRiB4IM6qwb249rfWsry6r8r9\n" +
                    "o6zG5M/g06a1xLjFwsrD3LbIKCkoKTEyLGYgeCBmIHggysfBrND4uq/K/aOs1PKx2M6quMXCysPc\n" +
                    "tsi1xMrHXHBhclxwYXINCqOoQSCjqSgpKCkxMmYgeCBmIHggICAgICAgICAgICAgICAgICAgICAg\n" +
                    "IKOoQiCjqSgpKCkyMTJmIHggRiB4XHBhclxwYXINCqOoQyCjqSgpKCkxMmYgeCBGIHggICAgICAg\n" +
                    "ICAgICAgICAgICAgICAgIKOoRCCjqSgpKCkoKSgpMTIyMWYgeCBGIHggZiB4IEYgeCAgIDijrsno\n" +
                    "19zM5Vggt/6007LOyv3Oqmh0dHA6Ly9kb2MueHVlaGFpLm5ldC9iNDMzMjI4ZTJlOTk5NGE5NTNk\n" +
                    "OGM1YWI5NjIwMzJmMTNjY2RiOWVjNy5odG1spstccGFyXHBhcg0KKCkwpss+tcSytMvJt9ayvKOs\n" +
                    "KCkxMiwsLDJuIFggWCBYIG4god0gzqrAtNfU19zM5bXEvPK1pcvmu/rR+bG+o6xccGFyXHBhcg0K\n" +
                    "1PK21NOmtcTNs7zGwb8xMTFuIGkgaSBUIFggbiA9PaHGo6wxMjExMVxwYXJccGFyDQoxbiBpXHBh\n" +
                    "clxwYXINCm4gaSBUIFggWCBuIG5ccGFyXHBhcg0KLT09IC2hxiCjqEEgo6kxMjEyLEVUIEVUIERU\n" +
                    "IERUID4+IKOoQiCjqTEyMTIsRVQgRVQgRFQgRFQgPiCjqEQgo6kxMjEyLEVUIEVUIERUIERUIFxw\n" +
                    "YXJccGFyDQq2/qGizO6/1cziXHBhclxwYXINCjmjrsnoMFxwYXJccGFyDQooKWxpbSAoMTMpeFxw\n" +
                    "YXJccGFyDQp0XHBhclxwYXINCnQgZiB4IHggdCCh+j0go6zU8igpZiB4ICc9XHBhclxwYXINCjEw\n" +
                    "o67J6Lqvyv0oMSl4XHBhclxwYXINCnkgeFxwYXJccGFyDQp6IHlccGFyXHBhcg0KPSCjrNTyKDEs\n" +
                    "MClkeiA9XHBhclxwYXINCjExo67H+s/fdGFuKCk0XHBhclxwYXINCnkgeCB5IGUgptBccGFyXHBh\n" +
                    "cg0KICA91Nq14ygwLDAptKa1xMfQz9+3vbPMzqpccGFyXHBhcg0KMTJccGFyXHBhcg0Ko67H+s/f\n" +
                    "eSA9XHBhclxwYXINCjJ4ID28sHgg1uHL+c6ns8m1xMa9w+bNvNDOyMZ4INbh0P3Xqsv5s8m1xND9\n" +
                    "16rM5bXEzOW7/c6qXHBhclxwYXINClu0y7SmzbzGrM60z8LU2LPJuaZdXHBhclxwYXINClu0y7Sm\n" +
                    "zbzGrM60z8LU2LPJuaZdXHBhclxwYXINCjEzo67J6Lb+tM7QzTEyMygsLClUIGYgeCB4IHggeCBB\n" +
                    "eCA9tcTWyM6qMaOsQSDW0NDQ1KrL2Nauus3OqjOjrNTyZiDU2tX9vbux5Lu7z8J4IFF5ID21xLHq\n" +
                    "17zOqlxwYXJccGFyDQoxNKOuyei2/s6sy+a7+rHkwb8oLClYIFkgt/600zIyKCw7LDswKU4gpsym\n" +
                    "zKbSptKjrNTyMigpRSBYWSA9XHBhclxwYXINCsj9oaK94rTwzOJccGFyXHBhcg0KMTVccGFyXHBh\n" +
                    "cg0KW7TLtKbNvMaszrTPwtTYs8m5pl1ccGFyXHBhcg0Ko67H87yrz94wXHBhclxwYXINCnggofpc\n" +
                    "cGFyXHBhcg0KIFxwYXJccGFyDQoxNi7S0daquq/K/SgsKWYgdSB2IL7f09DBrND4tcS2/r3Xxqu1\n" +
                    "vMr9o6woMSwxKTJmID3KxygsKWYgdSB2ILXEvKvWtaOsXHBhclxwYXINCltdKCksKCwpeiBmIHgg\n" +
                    "eSBmIHggeSA9IKGjx/NccGFyXHBhcg0KMigxLDEpXHBhclxwYXINCnpccGFyXHBhcg0KeCB5XHBh\n" +
                    "clxwYXINCj8/P1xwYXJccGh0dHA6Ly9kb2MueHVlaGFpLm5ldC9iNDMzMjI4ZTJlOTk5NGE5NTNk\n" +
                    "OGM1YWI5NjIwMzJmMTNjY2RiOWVjNy5odG1sYXINCjE3XHBhclxwYXINCqOux/NccGFyXHBhcg0K\n" +
                    "W7TLtKbNvMaszrTPwtTYs8m5pl1ccGFyXHBhcg0KIFxwYXJccGFyDQoxOFxwYXJccGFyDQqjrtak\n" +
                    "w/c0NGFyY3RhbiAwM1xwYXJccGFyDQp4IHggptBccGFyXHBhcg0KW7TLtKbNvMaszrTPwtTYs8m5\n" +
                    "pl1ccGFyXHBhcg0KLSA9x6HT0DLKtbj5LlxwYXJccGFyDQogXHBhclxwYXINCjE5o64nXHBhclxw\n" +
                    "YXINCicoKSgwKTEoKSgpdFxwYXJccGFyDQp0XHBhclxwYXINCkQgRCBmIHggZiBmXHBhclxwYXIN\n" +
                    "CnggeSBkeGR5IGYgeCB5IGR4ZHkgPSA9ID8/Pz/U2lswLDFd09DBrND4tcS1vMr9o6yjrMfSXHBh\n" +
                    "clxwYXINCiBccGFyXHBhcg0KW7TLtKbNvMaszrTPwtTYs8m5pl1ccGFyXHBhcg0Ke30oLCl8MCww\n" +
                    "KDAxKSwoKXQgRCB4IHkgeSB0IHggdCB0IGYgeCA9odyh3KHcodxccGFyXHBhcg0KIFxwYXJccGFy\n" +
                    "DQoyMKOuKCkoKSgpMTIzMSwwLDEsMCwxLDEsMSwzLDVUXHBhclxwYXINClRccGFyXHBhcg0KVFxw\n" +
                    "YXJccGFyDQqmwabBpsE9PT2yu8Tc08koKSgpKCkxMjMxLCwxLDEsMiwzLDEsMyw1VFxwYXJccGFy\n" +
                    "DQpUXHBhclxwYXINClRccGFyXHBhcg0KYSCmwqbCpsI9PT3P39DUse2z9qGjotnH82Ego7ui2r2r\n" +
                    "MTIzLCymwqbCpsLTyTEyMyymwabBpsHP39DUse2z9qGjXHBhclxwYXINCjIxo65BIM6qyP2918q1\n" +
                    "vtjV86OsKCkyUiBBID2jrMfSMTExMTAwMDAxMTExQSAtPz8/PyA/ID9ccGFyXHBhcg0KPSA/ID8g\n" +
                    "PyA/LT8/Pz9ccGFyXHBhcg0KIFxwYXJccGFyDQqjqDGjqcfzQSC1xMzY1ffWtdPrzNjV98/ywb+j\n" +
                    "qDKjqcfzQVxwYXJccGFyDQoyMi5ccGFyXHBhcg0KW7TLtKbNvMaszrTPwtTYs8m5pl1ccGFyXHBh\n" +
                    "cg0KW7TLtKbNvMaszrTPwtTYs8m5pl1ccGFyXHBhcg0KKCkyMjFQIFggWSA9PVxwYXJccGFyDQrH\n" +
                    "86O6o6gxo6koKSxYIFkgtcS31rK8o7ujqDKjqVogWFkgPbXEt9ayvKO7o6gzo6lYWSCm0S5ccGFy\n" +
                    "XHBhcg0KMjMuICgpLFggWSDU2kcgyc+3/rTTvvnUyLfWsryjrEcg08kwLDJ4IHkgeCB5IC09ID3T\n" +
                    "6zB5ID3Op7PJoaMgotnH87Hf1LXD3LbIKClYIGYgeCCju6Lax/N8KHwpWCBZIGYgeCB5XHBhclxw\n" +
                    "YXINClu0y7SmzbzGrM60z8LU2LPJuaZdXHBhclxwYXINClu0y7SmzbzGrM60z8LU2LPJuaZdXHBh\n" +
                    "clxwYWh0dHA6Ly9kb2MueHVlaGFpLm5ldC9iNDMzMjI4ZTJlOTk5NGE5NTNkOGM1YWI5NjIwMzJm\n" +
                    "MTNjY2RiOWVjNy5odG1scg0KIFxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFy\n" +
                    "DQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJc\n" +
                    "cGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxw\n" +
                    "YXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1Nizybmm\n" +
                    "XVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1Niz\n" +
                    "ybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C\n" +
                    "1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzO\n" +
                    "tM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28\n" +
                    "xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0\n" +
                    "ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpb\n" +
                    "tMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFy\n" +
                    "DQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJccGFyDQpbtMu0ps28xqzOtM/C1NizybmmXVxwYXJc\n" +
                    "cGFyDQp9ew0KXHJ0bGNoXGZjczEgXGFmMCBcbHRyY2hcZmNzMCBcZnMyNFxsb2NoXGFmMTNcaW5z\n" +
                    "cnNpZDY0OTMzNjhcY2hhcnJzaWQxNTg2NjM2MSANClxwYXIgfVxwYXJkIFxsdHJwYXJccWogXGxp\n" +
                    "MFxyaTBcc2wxODBcc2xtdWx0MFxub3dpZGN0bHBhclx3cmFwZGVmYXVsdFxhc3BhbHBoYVxhc3Bu\n" +
                    "dW1cZmFhdXRvXGFkanVzdHJpZ2h0XHJpbjBcbGluMFxpdGFwMFxwYXJhcnNpZDY0OTMzNjgge1xy\n" +
                    "dGxjaFxmY3MxIFxhZjAgXGx0cmNoXGZjczAgXGluc3JzaWQ2NDkzMzY4IA0KXHBhciANClxwYXIg\n" +
                    "DQpccGFyIA0KXHBhciANClxwYXIgfXtccnRsY2hcZmNzMSBcYWYwXGFmczI4IFxsdHJjaFxmY3Mw\n" +
                    "IFxmMTNcZnMyOFxpbnNyc2lkMTU4MTczNjdcY2hhcnJzaWQxNTgxNzM2NyBcbG9jaFxhZjEzXGhp\n" +
                    "Y2hcYWYxM1xkYmNoXGYxMyBcJ2NlXCdjNH17XHJ0bGNoXGZjczEgXGFmMFxhZnMyOCBcbHRyY2hc\n" +
                    "ZmNzMCBcZjEzXGZzMjhcaW5zcnNpZDExOTQxODkzIFxsb2NoXGFmMTNcaGljaFxhZjEzXGRiY2hc\n" +
                    "ZjEzIFwnYjVcJ2I1fXtccnRsY2hcZmNzMSBcYWYwXGFmczI4IA0KXGx0cmNoXGZjczAgXGYxM1xm\n" +
                    "czI4XGluc3JzaWQxNTgxNzM2N1xjaGFycnNpZDE1ODE3MzY3IFxsb2NoXGFmMTNcaGljaFxhZjEz\n" +
                    "XGRiY2hcZjEzIFwnY2ZcJ2MyXCdkNFwnZDhcJ2NkXCdmOFwnY2FcJ2M3XCdkN1wnYThcJ2QyXCdi\n" +
                    "NVwnYjVcJ2M0XCdjM1wnZTJcJ2I3XCdkMVwnY2VcJ2M0XCdiNVwnYjVcJ2NiXCdkMVwnY2JcJ2Y3\n" +
                    "XCdkM1wnZWJcJ2NmXCdjMlwnZDRcJ2Q4XCdjZFwnZjhcJ2Q1XCdiZVwnYTNcJ2FjXCdjY1wnZTFc\n" +
                    "J2I5XCdhOQ0KXCdkMFwnZDBcJ2QyXCdiNVwnZDdcJ2NhXCdjMVwnY2ZcJ2EzXCdhY1wnYmZcJ2Jj\n" +
                    "XCdjYVwnZDRcJ2Q3XCdjYVwnYzFcJ2NmXCdhM1wnYWNcJ2JkXCdjY1wnZDFcJ2E3XCdiZlwnY2Vc\n" +
                    "J2JjXCdmZVwnYTNcJ2FjXCdkMVwnYTdcJ2NhXCdmNVwnYzJcJ2RiXCdjZVwnYzRcJ2EzXCdhY1wn\n" +
                    "YmNcJ2JjXCdjYVwnZjVcJ2Q3XCdjYVwnYzFcJ2NmXCdhM1wnYWNcJ2QxXCdkMFwnYmVcJ2JmXCdi\n" +
                    "MVwnYThcJ2I4XCdlNlwnYTNcJ2FjXCdiOVwnYTQNClwnZDdcJ2Y3XCdiN1wnYjZcJ2NlXCdjNFwn\n" +
                    "YTNcJ2FjXCdkN1wnY2FcJ2I4XCdmMVwnYmZcJ2JjXCdjYVwnZDRcJ2EzXCdhY317XHJ0bGNoXGZj\n" +
                    "czEgXGFmMFxhZnMyOCBcbHRyY2hcZmNzMCBcZjEzXGZzMjhcaW5zcnNpZDE1ODE3MzY3XGNoYXJy\n" +
                    "c2lkMTU4MTczNjcgXGhpY2hcYWYxM1xkYmNoXGFmMTNcbG9jaFxmMTMgd29yZH17XHJ0bGNoXGZj\n" +
                    "czEgXGFmMFxhZnMyOCBcbHRyY2hcZmNzMCANClxmMTNcZnMyOFxpbnNyc2lkMTU4MTczNjdcY2hh\n" +
                    "cnJzaWQxNTgxNzM2NyBcbG9jaFxhZjEzXGhpY2hcYWYxM1xkYmNoXGYxMyBcJ2NlXCdjNFwnYjVc\n" +
                    "J2I1XCdhM1wnYWNcJ2Q3XCdhOFwnZDJcJ2I1XCdjZVwnYzRcJ2NmXCdkN1wnYTNcJ2FjXCdkM1wn\n" +
                    "YTZcJ2QzXCdjM1wnY2VcJ2M0XCdjYVwnZTlcJ2EzXCdhY1wnZDBcJ2QwXCdkMlwnYjVcJ2MyXCdk\n" +
                    "YlwnY2VcJ2M0XCdiNVwnYzhcJ2NlXCdjNFwnYjVcJ2I1XCdjYlwnZDFcJ2NiXCdmNw0KXCdkM1wn\n" +
                    "ZWJcJ2NlXCdjNFwnYjVcJ2I1XCdjZlwnYzJcJ2Q0XCdkOFwnYTNcJ2FjXCdjYVwnYzdcJ2M0XCdm\n" +
                    "YVwnY2VcJ2M0XCdiNVwnYjVcJ2QwXCdiNFwnZDdcJ2Y3XCdiYVwnY2RcJ2IyXCdlOVwnZDVcJ2Qy\n" +
                    "XCdiMlwnY2VcJ2JmXCdiY1wnZDdcJ2NhXCdjMVwnY2ZcJ2I1XCdjNFwnYjFcJ2Q4XCdiMVwnYjhc\n" +
                    "J2NkXCdmOFwnZDVcJ2JlXCdhMVwnYTN9e1xydGxjaFxmY3MxIFxhZjBcYWZzMjggXGx0cmNoXGZj\n" +
                    "czAgDQpcZnMyOFxsb2NoXGFmMTNcaW5zcnNpZDE1ODE3MzY3IA0KXHBhciB9e1xydGxjaFxmY3Mx\n" +
                    "IFxhZjBcYWZzMjggXGx0cmNoXGZjczAgXGYxM1xmczI4XGNmMTFcaW5zcnNpZDExOTQxODkzIFxs\n" +
                    "b2NoXGFmMTNcaGljaFxhZjEzXGRiY2hcZjEzIFwnY2VcJ2M0XGxvY2hcYWYxM1xoaWNoXGFmMTNc\n" +
                    "ZGJjaFxmMTMgXCdiNVwnYjV9e1xydGxjaFxmY3MxIFxhZjBcYWZzMjggXGx0cmNoXGZjczAgXGYx\n" +
                    "M1xmczI4XGNmMTFcaW5zcnNpZDY0OTMzNjhcY2hhcnJzaWQ2NDkzMzY4IA0KXGxvY2hcYWYxM1xo\n" +
                    "aWNoXGFmMTNcZGJjaFxmMTMgXCdjZlwnYzJcJ2Q0XCdkOH17XHJ0bGNoXGZjczEgXGFmMFxhZnMy\n" +
                    "OCBcbHRyY2hcZmNzMCBcZjEzXGZzMjhcY2YxMVxpbnNyc2lkNjQ5MzM2OFxjaGFycnNpZDY0OTMz\n" +
                    "NjggXGhpY2hcYWYxM1xkYmNoXGFmMTNcbG9jaFxmMTMgIH17XGZpZWxkXGZsZGVkaXR7XCpcZmxk\n" +
                    "aW5zdCB7XHJ0bGNoXGZjczEgXGFmMFxhZnMyOCBcbHRyY2hcZmNzMCBcZjEzXGZzMjhcY2YxMVxp\n" +
                    "bnNyc2lkMzE0NjUyOSANClxoaWNoXGFmMTNcZGJjaFxhZjEzXGxvY2hcZjEzIEhZUEVSTElOSyAi\n" +
                    "aHR0cHM6Ly9kb2MueHVlaGFpLm5ldC8ifXtccnRsY2hcZmNzMSBcYWYwXGFmczI4IFxsdHJjaFxm\n" +
                    "Y3MwIFxmMTNcZnMyOFxjZjExXGluc3JzaWQzMTQ2NTI5XGNoYXJyc2lkMzE0NjUyOSB7XCpcZGF0\n" +
                    "YWZpZWxkIA0KMDBkMGM5ZWE3OWY5YmFjZTExOGM4MjAwYWEwMDRiYTkwYjAyMDAwMDAwMDMwMDAw\n" +
                    "MDBlMGM5ZWE3OWY5YmFjZTExOGM4MjAwYWEwMDRiYTkwYjQ2MDAwMDAwNjgwMDc0MDA3NDAwNzAw\n" +
                    "MDNhMDAyZjAwMmYwMDY0MDA2ZjAwNjMwMDJlMDA3NzAwNjUwMDZlMDA2NDAwNmYwMDYzMDAyZTAw\n" +
                    "NjMwMDZmMDA2ZDAwMmYwMDAwMDA3OTU4ODFmNDNiMWQ3ZjQ4YWYyYzgyNWRjNDg1Mjc2MzAwMDAw\n" +
                    "MDAwYTVhYjAwMDB9fX17XGZsZHJzbHQgew0KXHJ0bGNoXGZjczEgXGFmMFxhZnMyOCBcbHRyY2hc\n" +
                    "ZmNzMCBcY3MxN1xmMTNcZnMyOFx1bFxjZjJcaW5zcnNpZDMxNDY1MjkgXGhpY2hcYWYxM1xkYmNo\n" +
                    "XGFmMTNcbG9jaFxmMTMgaHR0cHM6Ly9kb2Mud2VuXGhpY2hcYWYxM1xkYmNoXGFmMTNcbG9jaFxm\n" +
                    "MTMgZG9jLmNvbS99fX1cc2VjdGQgDQpcbGluZXgwXGhlYWRlcnk4NTFcZm9vdGVyeTk5Mlxjb2xz\n" +
                    "eDQyNVxlbmRuaGVyZVxzZWN0bGluZWdyaWQzMTJcc2VjdHNwZWNpZnlsXHNlY3Ryc2lkNjQ5MzM2\n" +
                    "OFxzZnRuYmoge1xydGxjaFxmY3MxIFxhZjBcYWZzMjggXGx0cmNoXGZjczAgXGZzMjhcY2YxMVxs\n" +
                    "b2NoXGFmMTNcaW5zcnNpZDY0OTMzNjhcY2hhcnJzaWQ2NDkzMzY4IA0KXHBhciB9e1xydGxjaFxm\n" +
                    "Y3MxIFxhZjBcYWZzMjggXGx0cmNoXGZjczAgXGYxM1xmczI4XGNmMTFcaW5zcnNpZDExOTQxODkz\n" +
                    "IFxsb2NoXGFmMTNcaGljaFxhZjEzXGRiY2hcZjEzIFwnZDJcJ2RhXCdjZFwnZjJ9e1xydGxjaFxm\n" +
                    "Y3MxIFxhZjBcYWZzMjggXGx0cmNoXGZjczAgXGYxM1xmczI4XGNmMTFcaW5zcnNpZDEzMTg3ODYg\n" +
                    "XGxvY2hcYWYxM1xoaWNoXGFmMTNcZGJjaFxmMTMgXCdjZVwnYzRcJ2I1XCdiNVwnZDdcJ2NhXCdj\n" +
                    "MVwnY2ZcJ2EzXCdhYw0KXCdiNVwnYzhcJ2M0XCdlM1wnYzBcJ2I0fXtccnRsY2hcZmNzMSBcYWYw\n" +
                    "XGFmczI4IFxsdHJjaFxmY3MwIFxmMTNcZnMyOFxjZjExXGluc3JzaWQ4Njc0Njc3IFxsb2NoXGFm\n" +
                    "MTNcaGljaFxhZjEzXGRiY2hcZjEzIFwnYzNcJ2UyXCdiN1wnZDF9e1xydGxjaFxmY3MxIFxhZjBc\n" +
                    "YWZzMjggXGx0cmNoXGZjczAgXGYxM1xmczI4XGNmMTFcaW5zcnNpZDEzMTg3ODYgXGxvY2hcYWYx\n" +
                    "M1xoaWNoXGFmMTNcZGJjaFxmMTMgXCdjZlwnYzJcJ2Q0XCdkOH17DQpccnRsY2hcZmNzMSBcYWYw\n" +
                    "XGFmczI4IFxsdHJjaFxmY3MwIFxmczI4XGNmMTFcbG9jaFxhZjEzXGluc3JzaWQxNTA5ODYyM1xj\n" +
                    "aGFycnNpZDY0OTMzNjggDQpccGFyIH19";

            decoderBase64File(base64Code, "E:/谷歌浏览器下载/2011年考研数学三真题及答案解析[doc.xuehai.net].doc");
//            toFile(base64Code, "D:\\three.txt");

            String str = "data:application/octet-stream;base64,";
            if(str.startsWith("data:application/octet-stream")){
                System.out.println("这是doc文件");
            }else {
                System.out.println("其他文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}