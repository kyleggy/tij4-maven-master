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
        for (int i = 10; i < 15; i ++) {
            Thread thread2 = new Thread(new FibonacciThread(i));
            thread2.start();
        }
    }

}


