package concurrency;
// Understanding join().
import static net.mindview.util.Print.*;

class Sleeper extends Thread {
  private int duration;
  public Sleeper(String name, int sleepTime) {
    super(name);
    duration = sleepTime;
    start();
  }
  public void run() {
    try {
      sleep(duration);
    } catch(InterruptedException e) {
      print(getName() + " was interrupted. " +
        "isInterrupted(): " + isInterrupted());
      return;
    }
    print(getName() + " has awakened");
  }
}

class Joiner extends Thread {
  private Sleeper sleeper;
  public Joiner(String name, Sleeper sleeper) {
    super(name);
    this.sleeper = sleeper;
    start();
  }
  public void run() {
   try {
     System.out.println(getName() + " waited another thread " + sleeper.getName() + " finished");
      sleeper.join();
      System.out.println(getName() + " continued since another thread " + sleeper.getName() + " has finished");
    } catch(InterruptedException e) {
      print("Interrupted");
    }
    print(getName() + " join completed");
  }
}

public class Joining {
  public static void main(String[] args) {
    Sleeper
      sleepy = new Sleeper("Sleepy", 1500),
      grumpy = new Sleeper("Grumpy", 1500);
    Joiner
      dopey = new Joiner("Dopey", sleepy),
      doc = new Joiner("Doc", grumpy);
    grumpy.interrupt();
  }
} /* Output:
Dopey waited another thread Sleepy finished
Doc waited another thread Grumpy finished
Grumpy was interrupted. isInterrupted(): false
Doc continued since another thread Grumpy has finished
Doc join completed
Sleepy has awakened
Dopey continued since another thread Sleepy has finished
Dopey join completed
*///:~
