package multithreading;

public class Example3 {
//public class Example3 implements Runnable{
//    public void run() {
//        for (int i = 1; i <= 1000; i++) {
//            System.out.println(i);
//        }
//    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread3());
        Thread thread2 = new Thread(new MyThread4());
        //Thread thread3 = new Thread(new Example3());

        thread1.start();
        thread2.start();
        //thread3.start();

    }
}


class MyThread3 implements Runnable{
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThread4 implements Runnable{
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}