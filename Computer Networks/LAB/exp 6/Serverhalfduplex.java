import java.io.*;
import java.net.*;

public class Serverhalfduplex {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Choose a port
            
            System.out.println("Server waiting for connection...");
            Socket clientSocket = serverSocket.accept(); // Wait for client connection
            
            System.out.println("Client connected.");
            
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter serverWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // Server receives messages from the client
            String clientMessage;
            while ((clientMessage = clientReader.readLine()) != null) {
                System.out.println("Client's message: " + clientMessage);
            }
            
            // Clean up
            serverWriter.close();
            clientReader.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
