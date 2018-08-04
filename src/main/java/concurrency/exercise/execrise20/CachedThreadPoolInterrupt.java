package concurrency.exercise.execrise20;

import concurrency.LiftOff;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lizhaok on 2017/2/11.
 */
public class CachedThreadPoolInterrupt {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<?>> futureList = new ArrayList<Future<?>>();
        for(int i = 0; i < 5; i ++) {
            futureList.add(executorService.submit(new LiftOff()));
        }
        for(Future<?> future : futureList) {
            future.cancel(true);
        }
        executorService.shutdown();
    }
}
