package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Demo02 {
    public static void main(String[] args) {

        Runnable a = new Runnable() {
            int num = 1;
            int i = 10;

            @Override
            public void run() {

                while (i<100) {
                    synchronized (this) {
                        num++;
                        i++;
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
                        System.out.println(Thread.currentThread().getName() + "  " + i);
                    }
                }
            }
        };
//        Runnable d = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    synchronized (this) {
//                        System.out.println(Thread.currentThread().getName() + "  " + num);
//                    }
//                }
//            }
//        };
        Thread t1 = new Thread(a,"累加1");
        Thread t2 = new Thread(a,"累加2");
        Thread t3 = new Thread(a,"累加3");
        Thread t4 = new Thread(a,"累加4");
        Thread t5 = new Thread(a,"累加5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
//        Thread d1 = new Thread(a,"累减1");
//        Thread d2 = new Thread(a,"累减2");
//        Thread d3 = new Thread(a,"累减3");
//        Thread d4 = new Thread(a,"累减4");
//        Thread d5 = new Thread(a,"累减5");
//        d1.start();
//        d2.start();
//        d3.start();
//        d4.start();
//        d5.start();
    }
}
