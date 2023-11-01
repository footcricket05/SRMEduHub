import java.io.*;
import java.net.*;

public class DaytimeClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (
            Socket socket = new Socket(serverAddress, serverPort);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // Read and print the date and time sent by the server
            String dateTime = in.readLine();
            System.out.println("Server date and time: " + dateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
