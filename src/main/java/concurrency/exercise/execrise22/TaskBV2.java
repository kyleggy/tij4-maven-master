package concurrency.exercise.execrise22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lizhaok on 2017/2/12.
 */
public class TaskBV2 implements Runnable {
    private FlagControllerV2 flagControllerV2;

    public TaskBV2(FlagControllerV2 flagControllerV2) {
        this.flagControllerV2 = flagControllerV2;
    }

    public void run() {
        flagControllerV2.setFlagToFalse();
    }

    public static void main(String[] args) {
        FlagControllerV2 flagControllerV2 = new FlagControllerV2();
        ExecutorService es = Executors.newCachedThreadPool();

        es.execute(new TaskBV2(flagControllerV2));
        es.execute(new TaskAV2(flagControllerV2));
        es.shutdown();
    }
}
