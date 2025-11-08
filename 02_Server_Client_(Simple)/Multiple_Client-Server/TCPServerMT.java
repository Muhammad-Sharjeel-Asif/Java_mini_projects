import java.io.*;
import java.net.*;

class TCPServerMT extends Thread {
    ServerSocket serverSocket;
    Socket clientSocket;
    int portNum;

    public TCPServerMT(ServerSocket serverSocket, int portNum) {
        this.serverSocket = serverSocket;
        this.portNum = portNum;
    }

    @Override
    public void run(){
        try {
            int client = 0;
            while(true){
                clientSocket = serverSocket.accept();
                client++;
                System.out.println("Client "+ client+ " connected!");
                if(clientSocket.isClosed() == true){
                    System.out.println("Client disconnected!");
                }
                
                
                BufferedReader bf = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

                System.out.println(bf.readLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}