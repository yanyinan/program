package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class ThreadTest {
    static int i = 1;
    public static void main(String[] args) {
        Object jude = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
               while (i<11){
                    if (i % 2 == 0) {
                        try {
                            t1.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    t2.notify();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (i<11){
                    if (i % 2 != 0) {
                        try {
                            t2.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    t1.notify();
                }
            }
        };
        new Thread(t1,"奇数").start();
        new Thread(t2,"偶数").start();
    }
}


