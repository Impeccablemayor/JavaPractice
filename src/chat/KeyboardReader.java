package chat;

import java.util.Scanner;

public class KeyboardReader {
    public static void main(String[] args) {
        System.out.println("Welcome, please input your name!");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Your name is: " + name);
    }
}

