package test.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class ABCOutCBA {

    public static void main(String[] args) {
        CountDownLatch A = new CountDownLatch(1);
        CountDownLatch B = new CountDownLatch(1);
//        Thread threadA = new Thread(new cdl("A"));
//        Thread threadB = new Thread(new cdl("B"));
//        Thread threadC = new Thread(new cdl("C"));
        Thread threadA = new Thread(new cdl("A", A, B));
        Thread threadB = new Thread(new cdl("B", A, B));
        Thread threadC = new Thread(new cdl("C", A, B));
        ABCOutCBA abcOutCBA = new ABCOutCBA();
        System.out.println("线程执行的顺序: A B C");
        System.out.println("线程实际执行的顺序:");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class cdl implements Runnable {
    String name;
    CountDownLatch A = new CountDownLatch(1);
    CountDownLatch B = new CountDownLatch(1);

    cdl(String name) {
        this.name = name;
    }

    cdl(String name, CountDownLatch A, CountDownLatch B) {
        this.name = name;
        this.A = A;
        this.B = B;
    }

    cdl() {
    }

    @Override
    public void run() {
        if ("A".equals(name)) {
            try {
                A.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(name + " ");
        }
        if ("B".equals(name)) {
            try {
                B.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(name + " ");
            A.countDown();
        }
        if ("C".equals(name)) {
            System.out.print(name + " ");
            B.countDown();
        }
    }

}