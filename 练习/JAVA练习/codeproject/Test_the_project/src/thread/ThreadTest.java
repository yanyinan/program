package thread;

import java.util.concurrent.*;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class ThreadTest {
    static int i = 1;

    public static void main(String[] args) {
        Object jude = new Object();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        try {
            poolExecutor.execute(() -> {
                while (i < 10) {
                    synchronized (jude) {
                        if (i % 2 == 0) {
                            try {
                                jude.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + " : " + i++);
                        jude.notifyAll();
                    }
                }
            });
            poolExecutor.execute(() -> {
                while (i < 11) {
                    synchronized (jude) {
                        if (i % 2 != 0) {
                            try {
                                jude.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + " : " + i++);
                        jude.notifyAll();
                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭线程池，不关闭的话，程序不会停止，一直处于Waiting状态
            poolExecutor.shutdown();
        }
//
//        Thread t1 = new Thread(() -> {
//            while (i < 10) {
//                synchronized (jude) {
//                    if (i % 2 == 0) {
//                        try {
//                            jude.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    System.out.println(Thread.currentThread().getName() + " : " + i++);
//                    jude.notifyAll();
//                }
//            }
//        });

//        Thread t2 = new Thread(() -> {
//            while (i < 11) {
//                synchronized (jude) {
//                    if (i % 2 != 0) {
//                        try {
//                            jude.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    System.out.println(Thread.currentThread().getName() + " : " + i++);
//                    jude.notifyAll();
//                }
//            }
//        });
//        new Thread(t1, "奇数").start();
//        new Thread(t2, "偶数").start();
    }
}


