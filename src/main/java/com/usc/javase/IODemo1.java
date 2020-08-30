package com.usc.javase;

import java.io.*;
import java.util.ArrayList;

/**
 * @author jianjianduan
 * @date 2020/8/29 9:31 下午
 *
 *  字符字节流之前的转换操作:
 *
 *  OutputStreamWriter 是字符流通向字节流的桥梁
 *
 *  InputStreamReader 是字节流通向字符流的桥梁
 */
public class IODemo1 {
    public static void main(String[] args) throws Exception {
        String inPath = "/Users/duanjianjian/code/temp/season.out";
        String outPath = "/Users/duanjianjian/code/temp/test.out";

//        testFIS("/Users/duanjianjian/code/temp/season.out");
//        testFOS("/Users/duanjianjian/code/temp/season.out", "/Users/duanjianjian/code/temp/test.out");

//        test1();
//        testBS(inPath, outPath);
//        testBR();

//        writeObject("/Users/duanjianjian/code/temp/object.out");
          readObject("/Users/duanjianjian/code/temp/object.out");

    }

    // 对象流 - 写出对象
    // 1.读取顺序和写入顺序一定要一致，不然会读取出错。
    //2.在对象属性前面加transient关键字，则该对象的属性不会被序列化
    public static void writeObject(String outPath) throws Exception{
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outPath));
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(Season.SPRING);
        oos.close();
        bos.close();
    }

    // 对象流 - 读取对象
    public static void readObject(String inPath) throws Exception{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inPath));
        ObjectInputStream ois = new ObjectInputStream(bis);

        Season o = (Season) ois.readObject();
        System.out.println(o);

        ois.close();
        bis.close();
    }

    // BufferedReader/BufferedWriter
    public static void testBR() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while((str = br.readLine()) != null){
            if (str.equals("exit")) System.exit(1);
            bw.write(str);
            bw.flush(); // 必须要flush否则不会有写出去
        }

        br.close();
        bw.close();
    }


    // FileInputStream
    public static void testFIS(String inPath) throws Exception {
        FileInputStream fis = new FileInputStream(new File(inPath));
        byte[] buffer = new byte[1024];
        int readLen = -1;
        int sum = 0;
        while((readLen = fis.read(buffer)) != -1){
            sum += readLen;
//            System.out.println(new String(buffer, 0, readLen));
        }

        fis.close();
        System.out.println(sum);
    }


    // FileOutputStream
    public static void testFOS(String inPath, String outPath) throws Exception {
        FileInputStream fis = new FileInputStream(inPath);
        FileOutputStream fos = new FileOutputStream(outPath);
        byte[] buffer = new byte[1024];
        int readLen = -1;
        while((readLen = fis.read(buffer)) != -1){
            fos.write(buffer, 0, readLen);
        }

        fos.close();
        fis.close();
    }

    public static void testBS(String inPath, String outPath) throws Exception {
        InputStream in;
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inPath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outPath));

        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = bis.read(buffer)) != -1){
            bos.write(buffer, 0, len);
        }

        // 只需要关闭上层的流，java底层会帮助关闭下层的流
        bos.close();
        bis.close();
    }

    // 字符流转字节流
    public static void test1() throws IOException {
        File f = new File("/Users/duanjianjian/code/temp/test.out");

        OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(f), "utf-8");

        o.write("字符流转字节流test");
        o.close();
    }
}
