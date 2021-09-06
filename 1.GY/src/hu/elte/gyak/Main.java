package hu.elte.gyak;

public class Main {
    public static void main(String[] args) throws Exception {
        printName("from main: ");
        new MyThread().start();
        Thread t = new Thread(new MyRunnable());
        t.start();
        Thread t2 = new Thread(new MyRunnable());
        t2.run();
        Thread t3 = new Thread(()->printName("lamda"));
        t3.start();
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                printName("anonymous inner class");
            }
        });
        t4.start();
        Thread t5 = new Thread(Main::printNameWithDefault);
        t5.start();
        t5.join();
        System.out.println("A main végzett");
    }

    private static void printName(String s) {
        System.out.println(s+"\tThis is: "+Thread.currentThread().getName());
    }

    private static void printNameWithDefault() {
        System.out.println("default:\tThis is: "+Thread.currentThread().getName());
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            printName("from runnable");
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello: "+getName());
        }
    }
}
