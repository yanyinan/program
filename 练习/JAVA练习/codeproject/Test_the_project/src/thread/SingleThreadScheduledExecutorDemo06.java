package thread;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.lang.Thread.sleep;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SingleThreadScheduledExecutorDemo06 {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0;i <10;i++){
            int number = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前时间" + LocalTime.now() + "，线程" + Thread.currentThread().getName() + "，序号" + number);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
}
