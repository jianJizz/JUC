package com.usc.javase;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jianjianduan
 * @date 2020/8/30 6:43 下午
 *
 * NIO学习
 */
public class NIODemo {
    public static void main(String[] args) throws Exception{
        testChannel();
    }

    public static void testChannel() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("/Users/duanjianjian/code/temp/season.out", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
