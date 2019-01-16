package concurrency.exercise.execrise01;

public class NewExecuteTask implements Runnable {
    int count = 0;
    private static int threadCount = 0;
    private int id = threadCount ++;

    public NewExecuteTask() {
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