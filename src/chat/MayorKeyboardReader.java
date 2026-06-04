package chat;

import java.util.Scanner;

public class MayorKeyboardReader {
    public static void main(String[] args) {
        System.out.println("Welcome to the Mayor Keyboard Reader");
        System.out.println("Please enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("It is nice having your here," + " " + name);
        scanner.close();
    }
}
