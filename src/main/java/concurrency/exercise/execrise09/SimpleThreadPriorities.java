package concurrency.exercise.execrise09;

import concurrency.SimplePriorities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lizhaok on 2017/1/28.
 */
public class SimpleThreadPriorities implements Runnable {
    private int countDown = 5;
    private volatile double d; // No optimization

    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    public void run() {
        while(true) {
            // An expensive, interruptable operation:
            for(int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if(i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorMinPriorityService = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MIN_PRIORITY));
        for(int i = 0; i < 5; i++)
            executorMinPriorityService.execute(
                    new SimpleThreadPriorities());
        ExecutorService executorMaxPriorityService = Executors.newSingleThreadExecutor(new PriorityThreadFactory(Thread.MAX_PRIORITY));
        executorMaxPriorityService.execute(
                new SimpleThreadPriorities());
        executorMaxPriorityService.shutdown();
        executorMinPriorityService.shutdown();
    }
}
