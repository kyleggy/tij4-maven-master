package concurrency.exercise.execrise04;

import generics.Fibonacci;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FibonacciExecutor implements Runnable {
    private Fibonacci fibonacci;
    private static int count = 0;
    private final int currentCount = count ++;
    private int n;

    public FibonacciExecutor(int n) {
        this.n = n;
    }

    public void run() {
        fibonacci = new Fibonacci();
        System.out.println(currentCount + " running...");
        for(int i = 0; i < n; i++)
            System.out.println("Thread " + currentCount + " " + fibonacci.next() + " ");
    }

    public static void main(String[] args) {
        ExecutorService cachedExecutors = Executors.newCachedThreadPool();
        for (int i = 10; i > 6; i --) {
            cachedExecutors.execute(new FibonacciExecutor(i));
        }
        cachedExecutors.shutdown();

        ExecutorService fixExecutors = Executors.newFixedThreadPool(3);
        for ( int i = 0; i < 7; i ++) {
            fixExecutors.execute(new FibonacciExecutor(i));
        }
        fixExecutors.shutdown();

        ExecutorService singleExecutors = Executors.newSingleThreadExecutor();
        for (int i = 20; i > 17; i--) {
            singleExecutors.execute(new FibonacciExecutor(i));
        }
        singleExecutors.shutdown();
    }

}
