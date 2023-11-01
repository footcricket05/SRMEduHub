import java.io.*;
import java.net.*;

public class AlexServer {
    public static void main(String[] args) {
        int serverPort = 12345; // Choose a port number for the server to listen on

        try {
            // Create a server socket that listens on the specified port
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server is running. Waiting for connections...");

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Set up input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Start the chat loop
            while (true) {
                // Wait for Sarah's message
                String message = in.readLine();

                // Check if Sarah wants to end the chat
                if ("bye".equalsIgnoreCase(message)) {
                    System.out.println("Client requested to close the connection. Closing...");
                    break;
                }

                // Display the received message from Sarah
                System.out.println("Sarah: " + message);

                // Send a response to Sarah's message
                String response = "Received your message: " + message;
                out.println(response);
            }

            // Close the streams and sockets
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
