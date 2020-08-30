package com.usc.javase;

import java.io.IOException;
import java.net.Socket;

/**
 * @author jianjianduan
 * @date 2020/8/30 10:36 下午
 */
public class Client {
    public static void main(String[] args) {
        // 创建多个线程 模拟多个客户端的请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                Socket socket = null;
                try {
                    socket = new Socket("127.0.0.1", 3333);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    while(true){
                        socket.getOutputStream().write((Thread.currentThread().getName() + " hello world!").getBytes());
                        Thread.sleep(3000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
