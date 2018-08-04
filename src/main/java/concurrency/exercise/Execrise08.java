package concurrency.exercise;

import concurrency.LiftOff;

import java.util.concurrent.TimeUnit;

/**
 * Created by lizhaok on 2017/1/28.
 */
public class Execrise08 {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for(int i = 0; i < 5; i++) {
            threads[i] = new Thread(new LiftOff(5));
            threads[i].setDaemon(true);
            threads[i].start();
        }
        System.out.println("Waiting for LiftOff");
        TimeUnit.MILLISECONDS.sleep(100);

    }


}
