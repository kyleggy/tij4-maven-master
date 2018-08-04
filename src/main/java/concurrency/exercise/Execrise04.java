package concurrency.exercise;

import concurrency.exercise.execrise02.FibonacciThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lizhaok on 2017/1/26.
 */
public class Execrise04 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new FibonacciThread(3));
        executorService.execute(new FibonacciThread(4));
        executorService.execute(new FibonacciThread(5));
        executorService.shutdown();

        executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new FibonacciThread(6));
        executorService.execute(new FibonacciThread(7));
        executorService.execute(new FibonacciThread(8));
        executorService.shutdown();

        executorService = Executors.newCachedThreadPool();
        executorService.execute(new FibonacciThread(3));
        executorService.execute(new FibonacciThread(4));
        executorService.execute(new FibonacciThread(5));
        executorService.shutdown();
    }
}
