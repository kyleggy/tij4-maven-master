package concurrency.exercise.execrise02;

import generics.Fibonacci;
import net.mindview.util.Generator;

/**
 * Created by lizhaok on 2017/1/26.
 */
public class FibonacciThread implements Runnable {
    private Fibonacci fibonacci;
    private int n;

    public FibonacciThread(int n) {
        this.n = n;
    }

    public void run() {
        fibonacci = new Fibonacci();
        System.out.println(Thread.currentThread().getId() + " running...");
        for(int i = 0; i < n; i++)
            System.out.println("Thread " + Thread.currentThread().getId() + " " + fibonacci.next() + " ");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new FibonacciThread(20));
        thread.start();
        Thread thread1 = new Thread(new FibonacciThread(10));
        thread1.start();
    }

}


