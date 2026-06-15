package arrays;

import java.util.Scanner;

public class ExEnum {
    enum Level {
        // Enum constants (each has its own description)
        LOW("Low level"),
        MEDIUM("Medium level"),
        HIGH("High level");

        // Field (variable) to store the description text
        private final String description;

        // Constructor (runs once for each constant above)
        Level(String description) {
            this.description = description;
        }

        // Getter method to read the description
        public String getDescription() {
            return description;
        }
    }

        public static void main(String[] args) {
//            Level myVar = Level.MEDIUM; // Pick one enum constant
//            System.out.println(myVar.getDescription()); // Prints "Medium level"
//
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your username:");

            String username = scanner.nextLine();
            System.out.println("The username is: " + username);
        }
}
