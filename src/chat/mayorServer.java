package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class mayorServer {

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;
    private static Scanner keyboard;

    public mayorServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
//        socket = new Socket("localhost", port);

        keyboard = new Scanner(System.in);

        System.out.println("Server started... waiting for client");
        socket = serverSocket.accept();
        System.out.println("Connected to " + socket.getInetAddress().getHostName());
        out = new PrintWriter(socket.getOutputStream(), true);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public static class ReceiverThread extends Thread {

        @Override
        public void run(){
            while (true) {
                try {
                    receiveMessage();
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                    break;
                }
            }

        }
    }

    public static class SenderThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Enter a message to send to the client.");
                String message = keyboard.nextLine();

                if (Objects.equals(message, "End")) {
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
    }
    public static void main(String[] args) throws IOException {

        mayorServer server = new mayorServer(2021);
        ReceiverThread receiverThread = new ReceiverThread();
        SenderThread senderThread = new SenderThread();

        senderThread.start();
        receiverThread.start();

    }

    public static void receiveMessage() throws IOException {

        String message = in.readLine();

        if (message == null || message.equalsIgnoreCase("End")) {
            System.out.println("Client disconnected");
            closeConnection();
            System.exit(0);
        }

        System.out.println("Client>>>> " + message);
    }

    public static void closeConnection() throws IOException {
        in.close();
        socket.close();
        serverSocket.close();
        out.close();
    }
}