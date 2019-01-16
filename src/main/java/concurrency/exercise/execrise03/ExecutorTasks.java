package concurrency.exercise.execrise03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTasks {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i ++) {
            executorService.execute(new NewTaskForExecutor());
        }
        executorService.shutdown();

        ExecutorService fixThreadService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i ++) {
            fixThreadService.execute(new NewTaskForExecutor());
        }
        fixThreadService.shutdown();

        ExecutorService singleThreadService = Executors.newSingleThreadExecutor();
        for (int i = 12 ; i < 15; i ++) {
            singleThreadService.execute(new NewTaskForExecutor());
        }
        singleThreadService.shutdown();

    }
}
