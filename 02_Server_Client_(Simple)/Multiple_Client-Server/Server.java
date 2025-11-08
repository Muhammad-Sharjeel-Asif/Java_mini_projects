import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serversSocket = new ServerSocket(9999);
        Thread th = new TCPServerMT(serversSocket, 9999);
        System.out.println("Waiting for the client");
        th.start();
        
    }
}
