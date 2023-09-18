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
        Thread t4 = new Thread(test, "线程4");
        Thread t5 = new Thread(test, "线程5");
        Thread t6 = new Thread(test, "线程6");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
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
//                if (ticket>0){
                try {
                    //模拟出票
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //获取线程名
                String name = Thread.currentThread().getName();
                System.out.println(name + " " + ticket--);
//            }
        }}
    }
}
