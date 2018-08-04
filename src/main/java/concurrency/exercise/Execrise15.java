package concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lizhaok on 2017/2/3.
 */
public class Execrise15 {
   private MultipleTask multipleTask;

    public Execrise15(MultipleTask multipleTask) {
        this.multipleTask = multipleTask;
    }

    public static void main(String[] args) {
        final MultipleTask multipleTask = new MultipleTask();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            public void run() {
                multipleTask.method01();
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                multipleTask.method02();
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                multipleTask.method03();
            }
        });

        executorService.shutdown();

    }
}

class MultipleTask {
    private Object syncObject01 = new Object();
    private Object syncObject02 = new Object();
    private Object syncObject03 = new Object();
    public void method01() {
        synchronized (syncObject01) {
            System.out.println("Method01 running");
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Method01 finished");
        }
    }

    public void method02() {
        synchronized (syncObject02) {
            System.out.println("Method02 running");
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Method02 finished");
        }
    }

    public void method03() {
        synchronized (syncObject03) {
            System.out.println("Method03 running");
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Method03 finished");
        }
    }
}
