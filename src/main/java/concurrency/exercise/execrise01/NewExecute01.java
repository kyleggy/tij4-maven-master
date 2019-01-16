package concurrency.exercise.execrise01;

public class NewExecute01 {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println("Main Thread will start " + i + " thread. ");
            new Thread(new NewExecuteTask()).start();
            //new Thread(new NewExecuteTask()).run();
            //will run in the order
            System.out.println("Main Thread ends " + i + " thread. ");
        }
    }

}
