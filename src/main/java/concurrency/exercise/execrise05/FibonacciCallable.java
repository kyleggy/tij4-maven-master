package concurrency.exercise.execrise05;

import generics.Fibonacci;

import java.util.concurrent.Callable;

/**
 * Created by lizhaok on 2017/1/26.
 */
public class FibonacciCallable implements Callable<Integer> {
    private Fibonacci fibonacci;
    private int n;

    public FibonacciCallable(int n) {
        this.n = n;
    }

    public Integer call() throws Exception {
        int sum = 0;
        fibonacci = new Fibonacci();
        for(int i = 0; i < n; i++) {
            sum += fibonacci.next();
        }
        return sum;
    }
}
