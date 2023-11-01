import java.io.*;
import java.net.*;

public class Clienthalfduplex {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 12345); // Server's IP and port
            
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // Client sends messages to the server
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            System.out.print("Enter the message to send to server:");
            while ((userInput = userInputReader.readLine()) != null) {
                clientWriter.println(userInput);
            }
            

            
            // Clean up
            clientWriter.close();
            serverReader.close();
            userInputReader.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
