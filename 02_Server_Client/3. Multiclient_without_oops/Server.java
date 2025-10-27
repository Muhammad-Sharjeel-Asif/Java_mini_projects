import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Server is running... Waiting for clients");

        // int client = 0;
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");
            new ClientHandler(clientSocket).start();
            // client++;
        }
    }
}
