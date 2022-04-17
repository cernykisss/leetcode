import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class oddEven {
    public static void main(String[] args) {
        test();
    }
    private static volatile int i = 1;
    public static Lock lock = new ReentrantLock();
    public static void test() {
        new Thread(() -> {
            while (i < 20) {
                lock.lock();
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "  " + i);
                    i++;
                }
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            while (i < 20) {
                lock.lock();
                if (i % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + "  " + i);
                    i++;
                }
                lock.unlock();
            }
        }).start();
    }
}
