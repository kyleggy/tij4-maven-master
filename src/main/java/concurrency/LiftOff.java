package concurrency;
// Demonstration of the Runnable interface.

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {
  protected int countDown = 10; // Default
  private static int taskCount = 0;
  private final int id = taskCount++;
  public LiftOff() {}
  public LiftOff(int countDown) {
    this.countDown = countDown;
  }
  public String status() {
    return "#" + id + "(" +
      (countDown > 0 ? countDown : "Liftoff!") + "), ";
  }
  public void run() {
    while(countDown-- > 0) {
      System.out.print(status());
      //The below code change is for the execrise 08
//      try {
//        TimeUnit.SECONDS.sleep(1);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
      Thread.yield();

    }
  }
} ///:~
