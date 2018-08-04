package concurrency.exercise.execrise22;

import java.security.Timestamp;
import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static net.mindview.util.Print.print;

/**
 * Created by lizhaok on 2017/2/12.
 */
public class TaskB implements Runnable {
    private FlagController flagController;
    private boolean shouldWait = true;

    public TaskB(FlagController flagController) {
        this.flagController = flagController;
    }

    public void run() {
        while (shouldWait) {
            if (flagController.getFlagValue()) {
                flagController.setFlagToFalse();
                print("TaskB set flag to false");
                shouldWait = false;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        FlagController flagController = new FlagController();
        es.execute(new TaskA(flagController));
        es.execute(new TaskB(flagController));
        es.shutdown();
    }
}
