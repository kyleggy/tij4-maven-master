package concurrency.exercise.execrise03;

public class NewTaskForExecutor implements Runnable {
    int count = 0;
    private static int threadCount = 0;
    private int id = threadCount ++;

    public NewTaskForExecutor() {
        System.out.println("Thread ID " + id + " Started");
    }

    public void run() {
        while (count < 3) {
            System.out.println("The current ID:" + id + " and  count is: " + count);
            count ++;
            Thread.yield();
        }
        System.out.println("Thread ID " + id + " Ended");

    }
}
