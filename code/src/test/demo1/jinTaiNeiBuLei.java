package test.demo1;

public class jinTaiNeiBuLei {

    static class t1{
        int a;
        t1(int v){
            a = v;
        }
    }

    public static void main(String[] args) {
        t1 t1 = new t1(1);
        t1 t2 = new t1(2);
        System.out.println(t1.a);
        System.out.println(t2.a);
        jinTaiNeiBuLei.t1 t11 = new t1(1);

    }

}
