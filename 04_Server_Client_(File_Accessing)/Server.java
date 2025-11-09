import java.io.*;
import java.nio.file.*;
import java.util.*;
import serverclientpackage.TCPServer;

public class Server {
    public static void main(String[] args) throws IOException {
        TCPServer server = new TCPServer(9999);
        
        try {
            while (true) {
                Process process = Runtime.getRuntime().exec("cmd /c dir /b");
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
                );
            
                
                String line;
                while ((line = reader.readLine()) != null) {
                    server.send(line);
                }
                server.send("END_OF_LIST");
                

                String fileName = server.receive();
                System.out.println("Client requested: " + fileName);
                
                if (fileName.equalsIgnoreCase("quit")) {
                    break;
                }
                

                List<String> lines = Files.readAllLines(Paths.get(fileName));
                for (String fileLine : lines) {
                    server.send(fileLine);
                }
                server.send("END_OF_FILE");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            server.close();
        }
    }
}