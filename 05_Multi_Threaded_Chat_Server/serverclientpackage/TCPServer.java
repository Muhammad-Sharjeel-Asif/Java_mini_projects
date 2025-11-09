package serverclientpackage;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {

    private ServerSocket serverSocket;
    private int portNumber;
    private ExecutorService pool; // Thread pool

    public TCPServer(int port_number) throws IOException {
        this.portNumber = port_number;
        serverSocket = new ServerSocket(this.portNumber);
        pool = Executors.newCachedThreadPool(); // dynamic pool
        System.out.println("Server started on port " + portNumber);
    }

    // Start accepting multiple clients
    public void start() {
        System.out.println("Waiting for clients...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                pool.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                System.out.println("Error accepting client: " + e.getMessage());
                break;
            }
        }
    }

    public void close() throws IOException {
        serverSocket.close();
        pool.shutdown();
    }

    // Inner class to handle each client
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                out.println("Welcome! Type 'quit' to disconnect.");

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client " + clientSocket.getInetAddress() + ": " + message);
                    if (message.equalsIgnoreCase("quit")) {
                        out.println("Goodbye!");
                        break;
                    }

                    // Echo back message
                    out.println("Server received: " + message);
                }

                clientSocket.close();
                System.out.println("Client disconnected: " + clientSocket.getInetAddress());

            } catch (IOException e) {
                System.out.println("Client error: " + e.getMessage());
            }
        }
    }
}
