package concurrency.exercise.execrise01;

/**
 * Created by lizhaok on 2017/1/26.
 */
public class Exercise01 {

    public static void main(String args[]) {
        for(int i = 0; i < 3; i ++) {
            Thread a = new Thread(new ExecuteTask("Execute Task " + i));
            a.start();

        }


    }

}
