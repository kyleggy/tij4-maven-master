package concurrency.exercise.execrise09;

import java.util.concurrent.ThreadFactory;

/**
 * Created by lizhaok on 2017/1/28.
 */
public class PriorityThreadFactory implements ThreadFactory {
    private int priority;

    public PriorityThreadFactory(int priority) {
        this.priority = priority;
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(priority);
        return t;
    }
}
