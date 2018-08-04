package concurrency.exercise.execrise22;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * Created by lizhaok on 2017/2/12.
 */
public class TaskAV2 implements Runnable {
    private FlagControllerV2 flagControllerV2;

    public TaskAV2(FlagControllerV2 flagControllerV2) {
        this.flagControllerV2 = flagControllerV2;
    }

    public void run() {
        try {
            print("Task AV2 sleep begins");
            TimeUnit.SECONDS.sleep(3);
            print("Task AV2 sleep finish");
            flagControllerV2.setFlagToTrue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
