package Pause;

import java.util.concurrent.TimeUnit;

public class ThreadsInProgram {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 10; i > 0 ; i--) {
            System.out.println(i);
            Thread.sleep(1000); // milliseconds
            //TimeUnit.MILLISECONDS.sleep(1000);
        }
    }
}
