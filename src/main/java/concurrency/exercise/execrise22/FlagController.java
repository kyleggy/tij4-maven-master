package concurrency.exercise.execrise22;

/**
 * Created by lizhaok on 2017/2/12.
 */
public class FlagController {
    private volatile boolean flag = false;

    public  void setFlagToTrue() {
        flag = true;
    }

    public  void setFlagToFalse() {
        flag = false;
    }

    public  boolean getFlagValue() {
        return flag;
    }
}
