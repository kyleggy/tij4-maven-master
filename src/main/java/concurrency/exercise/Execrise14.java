package concurrency.exercise;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lizhaok on 2017/2/2.
 */
public class Execrise14 {

    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i ++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Hello, timer");
                    System.exit(0);
                }
            }, 2000);
        }
    }
}
