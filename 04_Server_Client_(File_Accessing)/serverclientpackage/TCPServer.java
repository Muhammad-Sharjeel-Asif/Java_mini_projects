package serverclientpackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    ServerSocket serverSocket;
    int portNumber;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public TCPServer(int port_number) throws IOException {
        this.portNumber = port_number;
        System.out.println("Waiting for connection...");
        serverSocket = new ServerSocket(this.portNumber);
        clientSocket = serverSocket.accept();
        System.out.println("Client connected!");
        
        // Initialize streams once in constructor
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void send(String message) throws IOException {
        out.println(message);
    }

    public String receive() throws IOException {
        return in.readLine();
    }

    public void close() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}