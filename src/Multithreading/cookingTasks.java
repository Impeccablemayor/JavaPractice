package Multithreading;

public class cookingTasks extends Thread {
    private String task;

    public cookingTasks(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(task + " is being prepared by  " +  Thread.currentThread().getName());
    }

    public static class Restaurant {
        public static void main(String[] args) {
            Thread t1 = new Thread(new cookingTasks("Restaurant1"));
            Thread t2 = new Thread(new cookingTasks("Restaurant2"));
            Thread t3 = new Thread(new cookingTasks("Restaurant3"));
            Thread t4 = new Thread(new cookingTasks("Restaurant4"));

            t1.start();
            t2.start();
            t3.start();
            t4.start();

        }
    }
}
