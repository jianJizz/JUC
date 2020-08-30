package com.usc.javase;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jianjianduan
 * @date 2020/8/30 10:36 下午
 */
public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(3333);
        new Thread(() -> {
                while(true){
                    try {
                        Socket socket = ss.accept();
                        // 来一个请求 开一个新的线程处理数据
                        new Thread(() -> {
                            try {
                                InputStream is = socket.getInputStream();
                                byte[] buffer = new byte[1024];
                                int len = -1;
                                while((len = is.read(buffer)) != -1){
                                    System.out.println(new String(buffer, 0, len));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }).start();
    }
}
