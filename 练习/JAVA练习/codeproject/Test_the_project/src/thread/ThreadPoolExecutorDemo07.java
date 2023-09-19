package thread;

import java.util.concurrent.*;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class ThreadPoolExecutorDemo07 {
    public static void main(String[] args) {
        // 只写前五个参数也可以
        ExecutorService threadPool = new ThreadPoolExecutor(
                // 常驻核心线程数
                2,
                // 最大线程数
                10,
                // 空闲线程活跃时间
                2L,
                // 空闲线程活跃时间单位
                TimeUnit.SECONDS,
                // 阻塞队列
                new LinkedBlockingQueue<Runnable>(5),
                // 默认线程工厂
                Executors.defaultThreadFactory(),
                // 阻塞队列的拒绝策略,添加抛出异常
                new ThreadPoolExecutor.AbortPolicy()
        );
        // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求 线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 来办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭线程池，不关闭的话，程序不会停止，一直处于Waiting状态
            threadPool.shutdown();
        }
    }
}

