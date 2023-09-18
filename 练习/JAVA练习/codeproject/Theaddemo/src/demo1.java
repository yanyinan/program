/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class demo1 {

    public static void main(String[] args) {
        IncrementThread incrementThread = new IncrementThread();
        incrementThread.start();
        try {
            // 主线程等待5秒
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        incrementThread.interrupt(); // 中断线程

        // 输出结果
        System.out.println("Final Result: " + incrementThread.getResult());
    }

    static class IncrementThread extends Thread {
        private int result = 0;

        @Override
        public void run() {
            while (!isInterrupted()) {
                result++;
                try {
                    Thread.sleep(1000); // 线程每秒加一
                } catch (InterruptedException e) {
                    // 线程被中断时退出循环
                    break;
                }
            }
        }

        public int getResult() {
            return result;
        }
    }
}
