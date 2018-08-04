package concurrency;
// When threads collide.

public class EvenGenerator extends IntGenerator {
  private volatile int currentEvenValue = 0;
  public  int next() {
    ++currentEvenValue; // Danger point here!
    //Thread.yield();
    ++currentEvenValue;
    return currentEvenValue;
  }
  public static void main(String[] args) {
    EvenChecker.test(new EvenGenerator());
  }
} /* Output: (Sample)
Press Control-C to exit
89476993 not even!
89476993 not even!
*///:~
