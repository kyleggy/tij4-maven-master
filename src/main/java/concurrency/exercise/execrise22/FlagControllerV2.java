package concurrency.exercise.execrise22;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * Created by lizhaok on 2017/2/12.
 */
public class FlagControllerV2 {
    private boolean flag = false;

    public synchronized void setFlagToTrue() {
        flag = true;
        print("FlagControllerV2 Set flag to: " + flag );
        notifyAll();
    }

//    public synchronized void setFlagToFalse() {
//        flag = false;
//    }

    public synchronized void setFlagToFalse() {
        try {
                wait();
                flag = false;
                print("FlagControllerV2 Set flag to: " + flag);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
