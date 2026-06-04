package Multithreading;

public class test {

    public static class extendClass extends Thread {
        @Override
        public void run() {
            System.out.println("I am using the extend method of using threads");
        }
    }

    public static class implementClass implements Runnable {
        @Override
        public void run() {
            System.out.println("I am using the implementation method of using threads");
        }
    }
    public static void main(String[] args) {
        // I am using the extend class method here.....
        extendClass Eclass = new extendClass();
        Eclass.start();

        implementClass Iclass = new implementClass();
        Thread thread = new Thread(Eclass);
        thread.start();
    }
}