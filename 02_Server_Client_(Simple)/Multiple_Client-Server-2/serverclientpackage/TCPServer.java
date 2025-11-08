package serverclientpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    ServerSocket serverSocket;
    int portNumber = 9090;
    Socket clientSocket;
    String message = "Hi! from Server";
    PrintWriter out;
    BufferedReader in;

    public TCPServer(int port_number) throws IOException {
        this.portNumber = port_number;
        System.out.println("Waiting for connection...");
        serverSocket = new ServerSocket(this.portNumber);
    }

    public void start() throws IOException {
        while (true) {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");
        }

    }

    public void handleClient(Socket client) throws IOException {
        send(message);
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println("Hi! from Server");

        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("[" + client.getRemoteSocketAddress() + "] " + msg);
            out.println("Echo: " + msg);
        }
    }

    public void send(String serverMessage) throws IOException {
        this.message = serverMessage;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(this.message);
    }

    public String receive() throws IOException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        return in.readLine();
    }

    public void close() throws IOException {
        clientSocket.close();
        serverSocket.close();
    }
}
