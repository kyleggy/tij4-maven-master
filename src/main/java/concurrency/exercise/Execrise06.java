package concurrency.exercise;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lizhaok on 2017/1/26.
 */
public class Execrise06 implements Runnable{

    public void run() {
        //Random rn = new Random();
        //int range = maximum - minimum + 1;
        //int randomNum =  rn.nextInt(range) + minimum;
        Random random = new Random();
        int range = 10 - 1 + 1;
        int randomInt = random.nextInt(range) + 1;
        try {

            TimeUnit.MILLISECONDS.sleep(randomInt * 1000);
            System.out.println(Thread.currentThread().getId() + " sleep " + randomInt + " seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i ++) {
            executorService.execute(new Execrise06());
        }
        executorService.shutdown();
    }
}
