package thread;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Demo02test {
    public static void main(String[] args) throws InterruptedException {
        Num num = new Num();
        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++) {
                num.add();
//                System.out.println(Thread.currentThread().getName() + " " + num.getNum());
            }
        };
        Runnable r2 = () -> {
            for (int i = 0; i < 1000; i++) {
                num.des();
            }
        };
        for(int i= 0;i< 5;i++){
            new Thread(r1,"加"+i).start();

        }
        for(int i= 0;i< 5;i++){

            new Thread(r2,"减"+i).start();
        }
        Thread.sleep(5000);
        System.out.println(num.getNum());
    }

}
class Num {
    private int num = 0;
    public synchronized void add(){
        num++;
    }
    public synchronized void des(){
        num--;
    }

    public  int getNum() {
        return num;
    }
}
