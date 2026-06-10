package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class test {
    public static class mayorClient {
        private static Socket socket;
        private static PrintWriter out;
        private static BufferedReader in;
        private static Scanner keyboard;

        public mayorClient() throws IOException {
            socket = new Socket("localhost", 2021);
            System.out.println("Connected to the server successfully.");
            out = new PrintWriter( socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            keyboard = new Scanner(System.in);
        }

        public static void main(String[] args) throws IOException {
            chat.mayorClient client = new chat.mayorClient();

            while (true) {
                System.out.println("Enter a message to send to the server.");

                String message = keyboard.nextLine();
                if(Objects.equals(message, "End")) {
                    closeConnection();
                    break;
                }
                if (message != null) {
                    out.println(message);
                }

//            receiveMessage();
            }

        }

//    public static void receiveMessage() throws IOException {
//        System.out.println("Message received from the server: .");
//         String message = in.readLine();
//        System.out.println("Message from the server>>>>" + message);
//    }

        public static void closeConnection() throws IOException {
            out.close();
            in.close();
            keyboard.close();
            socket.close();
        }
    }

}
