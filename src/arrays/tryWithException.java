package arrays;


import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class tryWithException {
    public static void main(String[] args) throws FileNotFoundException {
        /*try {
            FileOutputStream output = new FileOutputStream("filename.txt");
            output.write("Hello, This is the first time i am writing to this file.".getBytes());
            output.close();  // I must close it manually
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
        finally {
            System.out.println("Closing program.");
        }*/

/*        try(FileWriter fileWriter = new FileWriter("filename.txt")) {
            fileWriter.write("This is a file i am writing to!!!");
            fileWriter.close();
            System.out.println("Successfully wrote to the file");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/

        //Now let's append to the file
//        try(FileWriter fileWriter = new FileWriter("filename.txt", true)) {
//
//                fileWriter.write("\nThis is a file i am appending to!!!");
//                System.out.println("Successfully wrote to the file");
//        }
//        catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }

        //let's read from the file we created using scanner.
        /*File file = new File("filename.txt");
        Scanner scanner = new Scanner(file);
        String filename = scanner.nextLine();
        System.out.println(filename);*/

        // i noticed that it was just reading one line of the text i have in "Filename.txt", i will use wile loop
        /*while(scanner.hasNextLine()){
            String ile = scanner.nextLine();
            System.out.println(ile);
        }*/

        // A more standard and profound version of it
        File file = new File("filename.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        file.deleteOnExit();


    }
}
