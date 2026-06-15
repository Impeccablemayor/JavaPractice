package fileoperations;

import java.io.*;
import java.sql.SQLOutput;

public class inputstream {
    public static void main(String[] args) throws IOException {
        //FileInputStream to read a text file, one byte at a time, and print the result as characters:
        /*File file = new  File("testFile.text");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Let's make it work out");
        fileWriter.close();
        try(FileInputStream fileInputStream = new FileInputStream(file);){
            int i;
            while((i = fileInputStream.read()) != -1){
                System.out.println( (char) i );
            }
        }
        catch (IOException e){
            System.out.println("Error reading file");
            e.printStackTrace();
        }*/

        //The real strength of FileInputStream is that it can handle any file type, not just text. Here is an example that copies an image file

//        FileWriter Infile = new FileWriter("input.txt");
//
//        Infile.write("The text to be copied =====");

        try (FileInputStream Input = new FileInputStream("input.txt");
             FileOutputStream Output = new FileOutputStream("output.txt")) {
            
            int i;
            while ((i = Input.read()) != -1) {
                Output.write(i);
            }

            System.out.println("File copied successfully");

        } catch (IOException e) {
            System.out.println("Error handling file");
            e.printStackTrace();
        }
    }
}
