package multithreading;

public class Example5 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        myThread5.setName("my Thread");
        myThread5.setPriority(9);
        myThread5.setPriority(Thread.MIN_PRIORITY); // 1
        myThread5.setPriority(Thread.NORM_PRIORITY); // 5
        myThread5.setPriority(Thread.MAX_PRIORITY); // 10

        System.out.println("Name of myThread = " + myThread5.getName());
        System.out.println("Priority of myThread = " + myThread5.getPriority());
    }
}



class MyThread5 extends Thread {
    public void run() {
        System.out.println("Hello");
    }
}