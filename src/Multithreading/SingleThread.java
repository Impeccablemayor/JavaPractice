package Multithreading;

public class SingleThread {
    // Thread A:
    //Print numbers 1-10
    static class NumberThread extends Thread{

        @Override
        public void run() {

            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
        }
    }

    static class LetterThread extends Thread{
        @Override
        public void run() {
            for (char i = 'A'; i <= 'J'; i++) {
                System.out.println(i);
            }
        }

    }

    static class SymbolThread extends Thread{
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("*");
            }
        }
    }

    public static void main(String[] args) {
        NumberThread run = new NumberThread();
        LetterThread run1 = new LetterThread();
        SymbolThread run2 = new SymbolThread();

        run.start();
        run1.start();
        run2.start();
    }
}
