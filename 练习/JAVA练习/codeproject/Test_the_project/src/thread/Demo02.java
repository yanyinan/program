package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Demo02 {
    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger();
        Runnable a = new Runnable() {

            int i = 0;

            @Override
            public void run() {
                while (i< 1000) {
                    i++;
                    synchronized (this) {
                        num.getAndIncrement();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        Runnable d = new Runnable() {

            int i = 0;

            @Override
            public void run() {
                while (i< 1000) {
                    i++;
                    synchronized (this) {
                        num.getAndDecrement();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        for (int i = 0; i < 5; i++) {

            new Thread(d,"累减"+i).start();
        }
        for (int i = 0; i < 6; i++) {
        new Thread(a,"累加"+i).start();}
        System.out.println(num);
    }
}
