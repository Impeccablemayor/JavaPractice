package fileoperations;

import java.io.*;

public class BufferedReaderl {
    //Use BufferedReader with FileReader to read each line of a file:
    public static void main(String[] args) throws IOException {

//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Input.txt"));) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//        catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Input.txt"));) {
            bufferedWriter.write("Hello World");
            bufferedWriter.newLine();
            bufferedWriter.write("Hello World");

            System.out.println("that's it");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
