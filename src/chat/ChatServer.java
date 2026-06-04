package chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

    ServerSocket serverSocket;
    Socket socket;
    private static PrintWriter out;
    private static BufferedReader in;
    private static Scanner keyboard;

    public ChatServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server listening on port " + port + ". Waiting for client's connection...");
        socket = serverSocket.accept();
        //out = new PrintWriter(socket.getOutputStream(), true);
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        keyboard = new Scanner(System.in);
    }

    public static void main(String[] args) throws IOException {
        ChatServer chat = new ChatServer(2020);
        System.out.println("Hi, please type a message to send to the client:");

        while (true) {
            //When server receives message from client
            String clientMessage = in.readLine();
            System.out.println("CLIENT>>> " + clientMessage);
            if ("END".equals(clientMessage)) {
                closeConnections(chat);
            }

        }
    }

    /*private static void readMessage(ChatServer chat) throws IOException {
        Thread thread = new Thread(() -> {
            new Runnable() {
                @Override
                public void run() {

                    try {
                        while (true) {
                            //When server receives message from client
                            String clientMessage = in.readLine();
                            System.out.println("CLIENT>>> " + clientMessage);
                            if ("END".equals(clientMessage)) {
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
    }*/

    private static void writeMessage(ChatServer chat) throws IOException {
        Thread thread = new Thread(() -> {
            new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        //When server types and sends a message
                        String message = keyboard.nextLine();
                        out.write(message);
                    }
                }
            };
        });
        thread.start();
    }


    public static void closeConnections(ChatServer chatServer) {
        try {
            out.close();
            in.close();
            chatServer.socket.close();
            chatServer.serverSocket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
