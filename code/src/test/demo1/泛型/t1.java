package test.demo1.泛型;

public class t1 {
    class GeneratorImpl<T> implements Generator<String>{
        @Override
        public String method() {
            return "hello";
        }
    }

    public static void main(String[] args) {
        t1 t1 = new t1();
        GeneratorImpl<Object> objectGenerator = t1.new GeneratorImpl<>();
        System.out.println(objectGenerator.method());
    }
}
