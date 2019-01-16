package concurrency.exercise.execrise05;

import generics.Fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class FinonacciNewCallable implements Callable<String> {
    private Fibonacci fibonacci;
    private static int count = 0;
    private final int currentCount = count ++;
    private int n;

    public FinonacciNewCallable(int n) {
        this.n = n;
    }


    public String call() throws Exception {
        fibonacci = new Fibonacci();
        System.out.println(currentCount + " running...");
        for(int i = 0; i < n; i++) {
            System.out.println("Thread " + currentCount + " runs " + fibonacci.next() + " ");
        }
        return currentCount + "finished to run";
    }

}

public class FibonacciNewCallableDemo {

    public static void  main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<Future<String>>();
        for (int i = 0 ; i < 20; i ++) {
            Future<String> future = executorService.submit(new FinonacciNewCallable(i));
            list.add(future);
        }

        for (Future<String> s : list) {
            System.out.println("Printing: ");
            try {
                System.out.println(s.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


    }
}
