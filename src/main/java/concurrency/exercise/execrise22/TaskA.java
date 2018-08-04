package concurrency.exercise.execrise22;

import java.util.concurrent.TimeUnit;

/**
 * Created by lizhaok on 2017/2/12.
 */
public class TaskA implements Runnable {
    private FlagController flagController;

    public TaskA(FlagController flagController) {
        this.flagController = flagController;
    }

    public void run() {
        try {

            TimeUnit.SECONDS.sleep(2);
            flagController.setFlagToTrue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
