import java.io.*;
import java.net.*;

public class SarahClient {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // Replace this with Alex's server IP address on the LAN
        int serverPort = 12345; // Replace this with the server's port number

        try {
            // Connect to Alex's server
            Socket socket = new Socket(serverIP, serverPort);
            System.out.println("Connected to Alex's server.");

            
            // Set up input and output streams for communication
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Start the chat loop
            while (true) {
                System.out.print("You: ");
                String message = userInput.readLine();

                // Send the message to Alex's server
                out.println(message);

                // Check if Sarah wants to end the chat
                if ("bye".equalsIgnoreCase(message)) {
                    System.out.println("Closing connection. Goodbye!");
                    break;
                }

                // Wait for the response from Alex's server
                String serverResponse = in.readLine();
                System.out.println("Alex's Server: " + serverResponse);
            }

            // Close the streams and socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
