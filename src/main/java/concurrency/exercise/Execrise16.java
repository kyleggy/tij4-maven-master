package concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lizhaok on 2017/2/3.
 */
public class Execrise16 {

    public static void main(String[] args) {
        final MultipleLock multipleLock = new MultipleLock();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            public void run() {
                multipleLock.method01();
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                multipleLock.method02();
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                multipleLock.method03();
            }
        });

        executorService.shutdown();
    }
}

class MultipleLock {
    private Lock lock01 = new ReentrantLock();
    private Lock lock02 = new ReentrantLock();
    private Lock lock03 = new ReentrantLock();

    public void method01() {
        lock01.lock();
        try {
            System.out.println("Method01 running");
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock01.unlock();
        }
        System.out.println("Method01 finished");

    }

    public void method02() {
        lock02.lock();
        try {
            System.out.println("Method02 running");
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock02.unlock();
        }
        System.out.println("Method02 finished");
    }

    public void method03() {
        lock03.lock();
        try {
            System.out.println("Method03 running");
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock03.unlock();
        }
        System.out.println("Method03 finished");
    }
}
