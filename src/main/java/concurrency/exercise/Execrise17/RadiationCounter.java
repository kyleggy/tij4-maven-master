package concurrency.exercise.Execrise17;

import java.util.Random;

/**
 * Created by lizhaok on 2017/2/7.
 */
public class RadiationCounter {
    private int counter = 0;

    private Random rand = new Random(47);

    public synchronized int increment() {
        int temp = counter;
        if(rand.nextBoolean()) // Yield half the time
            Thread.yield();
        return (counter = ++temp);
    }

    public synchronized int getTotal() {
        return counter;
    }



}
