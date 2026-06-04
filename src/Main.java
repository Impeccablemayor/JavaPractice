//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int sum(int n){
        if (n == 1) {
            return 1;
        }

        return n + sum(n -1);
    }

    //        Print numbers from 1 to n recursively.
    public static void increaseNumber(int n){
        if (n == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(n);
        increaseNumber(n - 1);
    }
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i += 2) {
//            System.out.println("Even number " + i);
//        }

        //let's do a countdown from 5 to 1
//        for (int i = 5; i > 0; i--) {
//            System.out.println("Number " + i);
//        }

//        String[] foods = {"beans", "Yam", "Rice"};
//        for ( String food : foods) {
//            System.out.println(food);
//        }
//        for (int i = 0; i <= 10; i++) {
//            if(i == 4){
//                continue;
//            }
//            System.out.println(i);
//        }

//        int[] numbers = {1,5,23,12,10};
//        int sum = 0;
//
//        for (int i = 0; i < numbers.length; i++) {
//          sum += numbers[i];
//        }
//
//        for (int number : numbers) {
//            sum = sum + number;
//            System.out.print(sum);
//        }
        int result = sum(4);
        System.out.println(result);

        increaseNumber(5);

//        Print numbers from 1 to n recursively.
//        Calculate the sum of numbers from 1 to n.
//        Find the power of a number:

    }





}
//}