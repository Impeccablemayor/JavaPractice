package fileoperations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileHandling {
        public static void main(String[] args) {
            //creating a new file

//            try {
//                File file = new File("testFile2.txt"); //create file object
//                if(file.createNewFile()){  // try to create the file
//                    System.out.println("File created at " + file.getAbsolutePath());
//                }
//                else{
//                    System.out.println("File already exists");
//                }
//            }
//            catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
            // add true as a parameter so that filewriter will not overwrite what is written in the file b4
            try(FileWriter fileWriter = new FileWriter("testFile.text", true)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("type anything you want into the file");
                String input =  scanner.nextLine();

               fileWriter.write(input);
                scanner.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

