import java.io.*;
import java.net.*;

public class FullDuplexServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server listening on port 12345...");
            System.out.println("Enter the message to send to client:");
            
            Socket clientSocket = serverSocket.accept();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            Thread inputThread = new Thread(() -> {
                try {
                    
                    while (true) {
                        String clientMessage = in.readLine();
                        if (clientMessage == null) {
                            break;
                        }
                        System.out.println("\nClient's message: " + clientMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            inputThread.start();
            
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String message = consoleReader.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println(message);
            }
            
            inputThread.join();
            serverSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
