package concurrency.exercise.Execrise17;

import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * Created by lizhaok on 2017/2/7.
 */
public class RemoteSensor implements Runnable {
    private static RadiationCounter radiationCounter = new RadiationCounter();
    private static List<RemoteSensor> remoteSensors = new ArrayList<RemoteSensor>();
    private int id;

    private int number = 0;

    public RemoteSensor(int id) {
        this.id = id;
        remoteSensors.add(this);
    }

    public void run() {
        synchronized (this) {
            ++number;
        }
        print(this + " Total: " + radiationCounter.increment());

    }

    public int getValue() {
        return number;
    }

    public String toString() {
        return "Remote Sensor " + id + ": " + getValue();
    }

    public static int getTotalCounter () {
        return radiationCounter.getTotal();
    }

    public static int getSumRemoteSensors() {
        int sum = 0;
        for (RemoteSensor r: remoteSensors
             ) {
            sum += r.number;
        }
        return sum;
    }

}
