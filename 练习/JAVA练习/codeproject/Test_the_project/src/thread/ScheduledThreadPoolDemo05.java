package thread;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class ScheduledThreadPoolDemo05 {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);
        System.out.println(LocalTime.now());
        for (int i = 0;i < 3;i++){
            int number = i;
//            pool.schedule(new Runnable() {
            pool.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前时间" + LocalTime.now() + "，线程" + Thread.currentThread().getName() + "，序号" + number);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            },2,5,TimeUnit.SECONDS);
        }
    }
}
