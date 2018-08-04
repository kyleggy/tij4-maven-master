package concurrency.exercise.Execrise17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * Created by lizhaok on 2017/2/7.
 */
public class RadiationSensor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 20; i ++) {
            executorService.execute(new RemoteSensor(i));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Sum: " + RemoteSensor.getSumRemoteSensors());
        print("Total: " + RemoteSensor.getTotalCounter());
    }
}
