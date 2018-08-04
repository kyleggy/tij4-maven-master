package concurrency.exercise;

import concurrency.exercise.execrise01.ExecuteTask;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lizhaok on 2017/1/26.
 */
public class Execrise03 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new ExecuteTask("message1"));
        executorService.execute(new ExecuteTask("message2"));
        executorService.execute(new ExecuteTask("message3"));
        executorService.shutdown();

        executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExecuteTask("message4"));
        executorService.execute(new ExecuteTask("message5"));
        executorService.execute(new ExecuteTask("message6"));
        executorService.shutdown();

        executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new ExecuteTask("message7"));
        executorService.execute(new ExecuteTask("message8"));
        executorService.execute(new ExecuteTask("message9"));
        executorService.shutdown();


    }


}
