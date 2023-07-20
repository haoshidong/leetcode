package test.demo1.单例;

public class shuangjiansuo {
    private volatile static shuangjiansuo instance;
    shuangjiansuo(){}

    public static shuangjiansuo getInstance(){
        if (instance == null){
            synchronized (shuangjiansuo.class){
                if (instance == null){
                    instance = new shuangjiansuo();
                }
            }
        }
        return instance;
    }

}
