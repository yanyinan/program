package SingletonMode;

/**
 * @title: 饿汉单例
 * @author:nanzhou
 * @date:
 */
public class SingletonMode1 {
    private static final  SingletonMode1 test = new SingletonMode1();
    private SingletonMode1(){}
    public static SingletonMode1 getInstance(){
        return test;
    }
}
class test{
    public static void main(String[] args) {
        SingletonMode1 Mode = SingletonMode1.getInstance();
        System.out.println(Mode);
    }
}