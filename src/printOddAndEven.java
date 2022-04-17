public class printOddAndEven {
    private int num = 0;
    public synchronized void printOdd() {
        while (num % 2 != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + num);
        num++;
        this.notify();
    }
    public synchronized void printEven() {
        while (num % 2 == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + num);
        num++;
        this.notify();
    }
}
