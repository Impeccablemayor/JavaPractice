package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatClient {
    private Socket socket = null;
    private static PrintWriter out = null;
    private static BufferedReader in = null;
    private static Scanner keyboard = null;
    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public ChatClient() throws IOException {
        socket = new Socket("localhost", 2020);
        System.out.println("Connected to the server!");
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        keyboard = new Scanner(System.in);
    }

    public static void main(String[] args) throws IOException {
        ChatClient client = new ChatClient();
        System.out.println("Type a message to send to the server:");
        readMessage(client);
        writeMessage(client);

       /*while (true) {
           //When client types and sends a message to the server
           String message = keyboard.nextLine();
           out.write(message);
           out.flush();
       }*/
    }

    private static void readMessage(ChatClient chat) throws IOException {
        Thread thread = new Thread(() -> {
            new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            //When client receives message from server
                            String serverMessage = in.readLine();
                            System.out.println("SERVER>>> " + serverMessage);
                            if ("END".equals(serverMessage)) {
                                closeConnections(chat);
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
        });
        thread.start();
    }

    private static void writeMessage(ChatClient chat) throws IOException {
        Thread thread = new Thread(() -> {
            new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        //When client types and sends a message to the server
                        String message = keyboard.nextLine();
                        out.write(message);
                    }
                }
            };
        });
        thread.start();
    }

    public static void closeConnections(ChatClient client) {
        try {
            out.close();
            in.close();
            client.socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
