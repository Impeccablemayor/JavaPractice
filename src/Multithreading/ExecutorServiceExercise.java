package Multithreading;

import java.util.concurrent.*;

public class ExecutorServiceExercise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executor =  Executors.newFixedThreadPool(3);
        /*for (int i = 1; i <= 10; i++) {
            int TaskNumber = i;
            executor.submit(() -> {
               System.out.println("Task " + TaskNumber + " from thread " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();*/

        // I used the runnable to get the square of a number.
        /*ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(()->{
            int number = 23;
            System.out.println("The square of the number is " + number * number);
        });*/

        /*Callable<Integer> callable = () -> {
            int number = 23;
            return number * number;
        };

        Future<Integer> futureTask = executor.submit(callable);
        try {
            Integer result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    executor.shutdown();*/

        /*ExecutorService executor =
                Executors.newFixedThreadPool(2);

        Future<Integer> f1 = executor.submit(() -> {
            Thread.sleep(3000);
            System.out.println( "The thread that ran this task" + Thread.currentThread().getName());
            return 10;
        });

        Future<Integer> f2 = executor.submit(() -> {
            Thread.sleep(1000);
            System.out.println( "The thread that ran this task" + Thread.currentThread().getName());
            return 20;
        });

        System.out.println("Started");

        System.out.println(f1.get());
        System.out.println(f2.get());

        executor.shutdown();*/

        ExecutorService executor =
                Executors.newFixedThreadPool(1);

        Future<Integer> f1 = executor.submit(() -> {
            Thread.sleep(3000);
            return 10;
        });

        Future<Integer> f2 = executor.submit(() -> {
            Thread.sleep(1000);
            return 20;
        });

        System.out.println(f2.get());
        System.out.println(f1.get());

        executor.shutdown();
    }
}
