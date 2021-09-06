package hu.elte.gyak;

public class Stop {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100 && !Thread.currentThread().isInterrupted(); ++i) {
                for (int j = 0; j < 100 && !Thread.currentThread().isInterrupted(); ++j) {
                    for (int k = 0; k < 100 && !Thread.currentThread().isInterrupted(); ++k) {
                        System.out.println(i * j * k);
                    }
                }
            }
        });
        t.start();
        Thread.sleep(500);
        System.out.println("READY TO INTERRUPT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        t.interrupt();
        System.out.println("INTERRUPT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    private static int countSteps() throws InterruptedException {
        int c = 0;
        for (int i = 0; i < 100 && !Thread.currentThread().isInterrupted(); ++i) {
            for (int j = 0; j < 100 && !Thread.currentThread().isInterrupted(); ++j) {
                for (int k = 0; k < 100 && !Thread.currentThread().isInterrupted(); ++k) {
                    System.out.println(i * j * k);
                    ++c;
                }
            }
        }
        if(Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("I was interrupted");
        }
        return c;
    }
}
