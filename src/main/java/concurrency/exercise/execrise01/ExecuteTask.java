package concurrency.exercise.execrise01;

/**
 * Created by lizhaok on 2017/1/26.
 */
public class ExecuteTask implements Runnable {
    private String message;
    public ExecuteTask(String message) {
        this.message = message;
    }
    public void run() {
        System.out.println(message);
        System.out.println("Hello, thread from " + message);
        System.out.println("Execute Task " + message + " Finished");
        Thread.yield();
    }
}
