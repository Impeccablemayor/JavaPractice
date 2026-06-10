package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class mayorClient {
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

    public static class SenderThread extends Thread{
        @Override
        public void run(){
            while (true) {
                System.out.println("Enter a message to send to the server.");
                String message = keyboard.nextLine();

                if(Objects.equals(message, "End")) {
                    try {
                        closeConnection();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
                if (message != null) {
                    out.println(message);
                }

        }
    }

    public static class ReceiverThread extends Thread{
            @Override
            public void run(){
                while (true) {
                    String message;
                    try {
                        message = in.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Message from the server>>>>" + message);
                }
            }
    }

    public static void main(String[] args) throws IOException {
        mayorClient mayorClient = new mayorClient();
        SenderThread senderThread = new SenderThread();
        ReceiverThread receiverThread = new ReceiverThread();

        receiverThread.start();
        senderThread.start();
        }

    }



    public static void closeConnection() throws IOException {
        out.close();
        in.close();
        keyboard.close();
        socket.close();
    }
}
