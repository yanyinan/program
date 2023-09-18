/**
 * @author 26481
 */
public class Main {
    private static final Object lock = new Object();
    private static int number = 1;
    private static int maxNumber = 10;

    public static void main(String[] args) {
        Thread evenThread = new Thread(new EvenRunnable());
        Thread oddThread = new Thread(new OddRunnable());

        evenThread.start();
        oddThread.start();
    }

    static class EvenRunnable implements Runnable {
        @Override
        public void run() {
            while (number <= maxNumber) {
                synchronized (lock) {
                    if (number % 2 == 0) {
                        System.out.println("Even: " + number);
                        number++;
                    }
                }
            }
        }
    }

    static class OddRunnable implements Runnable {
        @Override
        public void run() {
            while (number <= maxNumber) {
                synchronized (lock) {
                    if (number % 2 != 0) {
                        System.out.println("Odd: " + number);
                        number++;
                    }
                }
            }
        }
    }
}
