package concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * Created by lizhaok on 2017/2/8.
 */

class NonTask {

    public void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            print("Sleep Interrupted from " + this);
        }

    }
}

class RunTaskThread implements Runnable{
    private NonTask nonTask;

    public RunTaskThread(NonTask nonTask) {
        this.nonTask = nonTask;
    }

    public void run() {
        nonTask.sleep();
        //Thread.currentThread().interrupt();
        //Thread.interrupted();
    }
}
public class Execrise18 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        NonTask nonTask = new NonTask();
        executorService.execute(new RunTaskThread(nonTask));

        executorService.shutdownNow();

    }

}
