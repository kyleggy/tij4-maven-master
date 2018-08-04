package concurrency.exercise;

/**
 * Created by lizhaok on 2017/1/30.
 */

class RunInt {
    private  int a = 0;
    private  int b = 0;

    public  void set( ) {
        ++a;
        Thread.yield();
        --a;
        ++b;
        Thread.yield();
        --b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

}

public class Execrise11 implements Runnable{
    private RunInt runInt;

    public Execrise11(RunInt runInt) {
        this.runInt = runInt;
    }

    public void run() {
        runInt.set();
    }

    public static void main(String[] args) {
        RunInt runInt = new RunInt();

        for (int i = 0; i < 12000; i ++) {
           new Thread(new Execrise11(runInt)).start();
        }
        if (runInt.getB() == 0) {
            System.out.println("B value Pass");
        } else {
            System.out.println("B value failed: Expected value is: 0, actual value is: " + runInt.getB());
        }
        if (runInt.getA() == 0) {
            System.out.println("A value Pass");
        } else {
            System.out.println("A value failed: Expected value is: 0, actual value is: " + runInt.getA());
        }



    }
}
