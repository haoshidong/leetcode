package test;

import static java.lang.Thread.sleep;

public class t2 {

    public static void main(String[] args) throws InterruptedException {
//        t3 t3 = new t3();
        t3.a = 1;
        new Thread(() -> {
            t3.a = 2;
        }).start();new Thread(() -> {
            t3.a = 3;
        }).start();
        sleep(1);
        System.out.println(t3.a);
    }

}
class t3{
    public static int a;

    public int getA() throws InterruptedException {
//        sleep(1);
        return a;
    }
}