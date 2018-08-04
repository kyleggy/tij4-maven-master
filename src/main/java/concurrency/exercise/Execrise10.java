package concurrency.exercise;

import concurrency.exercise.execrise05.FibonacciCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lizhaok on 2017/1/28.
 */
public class Execrise10 {
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public Future<Integer> runTask(int n) {
        return executorService.submit(new FibonacciCallable(n));
    }

    public void close() {
        executorService.shutdown();
    }

    public static void main(String[] args) {
        Execrise10 execrise10 = new Execrise10();
        Future<Integer> results = execrise10.runTask(28);
        try {
            System.out.println(results.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        execrise10.close();

    }
}
