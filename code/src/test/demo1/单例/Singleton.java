package test.demo1.单例;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Singleton {
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

class test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
        executor.execute(() -> {
            Singleton instance1 = Singleton.getInstance();
            System.out.println("1:" + instance1);}
        );
        executor.execute(() -> {
            System.out.println("开始睡眠");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("结束睡眠");
            Singleton instance2 = Singleton.getInstance();
            System.out.println("2:" + instance2);

            new Thread(() -> {
                Singleton instance1 = Singleton.getInstance();
                System.out.println("5:" + instance1);
            }).start();
        });

        /*Thread t1 = new Thread(() -> {
            Singleton instance1 = Singleton.getInstance();
            System.out.println("1:" + instance1);
        }, "t1");

        Thread t2 = new Thread(() -> {
            Singleton instance2 = Singleton.getInstance();
            System.out.println("2:" + instance2);

            new Thread(() -> {
                Singleton instance1 = Singleton.getInstance();
                System.out.println("5:" + instance1);
            }).start();
        }, "t2");

        t1.start();
        t2.start();*/
        executor.shutdown();

        Singleton instance3 = Singleton.getInstance();
        Singleton instance4 = Singleton.getInstance();
        System.out.println("3:" + instance3);
        System.out.println("4:" + instance4);
    }
}