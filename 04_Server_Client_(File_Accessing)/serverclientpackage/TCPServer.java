package serverclientpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
        clientSocket = serverSocket.accept();
        System.out.println("Client connected!");
    }

    public String send() throws IOException {
        System.out.print("Enter message to send to Client: ");
        Scanner input = new Scanner(System.in);
        String sendMessage = input.next();
        this.message = sendMessage;

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(sendMessage);
        return this.message;
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
