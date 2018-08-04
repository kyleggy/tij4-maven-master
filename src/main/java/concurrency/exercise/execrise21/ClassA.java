package concurrency.exercise.execrise21;

import static net.mindview.util.Print.print;

/**
 * Created by lizhaok on 2017/2/12.
 */
public class ClassA implements Runnable {
    public void run() {
        print("Class A begins to run");
        try {
            waitFromClassA();
        } catch (InterruptedException e) {
            print("ClassA interrupted");
        }
    }

    public synchronized void waitFromClassA() throws InterruptedException {
        wait();
        print("Class A wake up");
    }

    public synchronized void notifyFromClassA() {
        notifyAll();
    }
}
