package test.demo1;

public class threadLocalDemo {
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 10;
        }
    };

    int a = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Thread-1:" + threadLocal.get());
            threadLocal.set(100);
            System.out.println("Thread-1:" + threadLocal.get());
        }).start();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        new Thread(() -> {
            System.out.println("Thread-2:" + threadLocal.get());
            threadLocal.set(200);
            System.out.println("Thread-2:" + threadLocal.get());
        }).start();
//        threadLocalDemo demo = new threadLocalDemo();
//        new Thread(() -> {
//            System.out.println("Thread-1:" + demo.a);
//            demo.a += 1;
//            System.out.println("Thread-1:" + demo.a);
//        }).start();
//
//        new Thread(() -> {
//            System.out.println("Thread-2:" + demo.a);
//            demo.a += 1;
//            System.out.println("Thread-2:" + demo.a);
//        }).start();
    }
}
