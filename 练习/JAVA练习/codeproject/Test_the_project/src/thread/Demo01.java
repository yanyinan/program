package thread;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Demo01 {
    public static void main(String[] args) {
        TicketSell test = new TicketSell();
        Thread t1 = new Thread(test, "线程1");
        Thread t2 = new Thread(test, "线程2");
        Thread t3 = new Thread(test, "线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketSell implements Runnable {

    //电影票总数
    private int ticket = 100;

    @Override
    public void run() {
        takeTicket(ticket);
    }

    private  void takeTicket(int ticket) {
        while (true) {
            //同步代码块锁
            synchronized (this) {
                try {
                    //模拟出票
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //获取线程名
                String name = Thread.currentThread().getName();
                System.out.println(name + " " + ticket--);
            }
        }
    }
}
