package test;

public class a2 implements a1 {
    @Override
    public void f() {
        System.out.println("123");
    }

    public static void main(String[] args) {
        a2 a2 = new a2();
        a2.f();
    }
}
