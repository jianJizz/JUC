package com.usc.juc.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.*;


/**
 * @author jianjianDuan
 * @date 2021/6/2 6:27 下午
 */
public class Demo1 {
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d-").build();

    private static ExecutorService pool = new ThreadPoolExecutor(23, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void test(String[] args){
        System.out.println(Arrays.toString(args));
    }
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            pool.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    Class<?> threadClazz = Class.forName("com.usc.juc.threadpool.Demo1");
                    Method method = threadClazz.getMethod("test", String[].class);
                    System.out.println(Thread.currentThread().getName());
                    method.invoke(threadClazz, new Object[]{args});
                    Thread.sleep(1000);
                }
            });

        }
        pool.shutdown();
    }
}
