package concurrency.exercise.execrise06;

import java.sql.Timestamp;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RandomSleep implements Runnable {
    private static int Count = 0;
    private int threadNumber = Count ++;
    private static final int max = 10;
    private static final int min = 1;

    public void run() {
        long beginTimeMillis = System.currentTimeMillis();
        Timestamp beginTimestamp = new Timestamp(beginTimeMillis);
        System.out.println("Thread: " + threadNumber + " begins to run at: " + beginTimestamp);
        Random random = new Random();

        //this method call returns "a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value (exclusive)".
        // This means that you will get numbers from 0 to 9 in your case. So you've done everything correctly by adding one to that number.
        try {
            TimeUnit.SECONDS.sleep((random.nextInt(max - min + 1) + min) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finishTimeMillis = System.currentTimeMillis();
        Timestamp finishTimeStamp = new Timestamp(finishTimeMillis);
        long costTimeMillis = finishTimeMillis - beginTimeMillis;
        double seconds = costTimeMillis / 1000.0;
        System.out.println("Thread: " + threadNumber + " finishes to run at: " + finishTimeStamp);
        System.out.println("Thread: " + threadNumber + " cost: " + seconds +  " seconds to run.");

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i ++) {
            executorService.execute(new RandomSleep());
        }
        executorService.shutdown();
    }
}
