package 剑指offer;

public class Test {
    public static void main(String[] args) {
        String s = "images/01/01.jpg#images/01/01.obj#images/01/01.mtl";
        String s1 = "images/";
        String s2 = ".jpg#images/";
        String s3 = ".obj#images/";
        String s4 = ".mtl";
        for (int i = 10; i < 36; i++) {
            String res = s1+i+"/"+i+s2+i+"/"+i+s3+i+"/"+i+s4;
            System.out.println(res);
        }
    }

    /*public int[] sortArray(int[] nums) {
        String s = "images/01/01.jpg#images/01/01.obj#images/01/01.mtl";
        String s1 = "images/";
        String s2 = ".jpg#images/";
        String s3 = ".obj#images/";
        String s4 = ".mtl";
        for (int i = 0; i < 11; i++) {
            String res = s1+i+"/"+i+s2+i+"/"+i+s3+i+"/"+i+s4;
            System.out.println(res);
        }

    }*/

}
