package serverclientpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient{
    Socket clientSocket;
    String ipAddress = "127.0.0.1";
    int portNumber = 9090;
    String message = "Hi! from Client";

    public TCPClient(String ip_address, int port_number) throws IOException{
        this.ipAddress = ip_address;
        this.portNumber = port_number;
        clientSocket = new Socket(this.ipAddress, this.portNumber);
        System.out.println("Connected with Server!");
    }

    public void send(String client_message) throws IOException{
        this.message = client_message;
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(this.message);
    }

    public String receive() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        return in.readLine();
    }

    public void close() throws IOException {
        clientSocket.close();
    }
}