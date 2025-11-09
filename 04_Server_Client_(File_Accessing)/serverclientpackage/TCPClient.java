package serverclientpackage;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    Socket clientSocket;
    String ipAddress;
    int portNumber;
    PrintWriter out;
    BufferedReader in;

    public TCPClient(String ip_address, int port_number) throws IOException {
        this.ipAddress = ip_address;
        this.portNumber = port_number;
        clientSocket = new Socket(this.ipAddress, this.portNumber);
        System.out.println("Connected with Server!");
        
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
    }
}