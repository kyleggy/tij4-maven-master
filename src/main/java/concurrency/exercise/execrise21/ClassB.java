package concurrency.exercise.execrise21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * Created by lizhaok on 2017/2/12.
 */
public class ClassB implements Runnable {
    private ClassA classA;

    public ClassB(ClassA classA) {
        this.classA = classA;
        new Thread(classA).start();
    }

    public void run() {
        try {
            NotifyClassA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void NotifyClassA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        print("ClassB Notify ClassA");
        classA.notifyFromClassA();
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new ClassB(new ClassA()));
        es.shutdown();
    }
}
