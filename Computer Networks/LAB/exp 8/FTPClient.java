import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FTPClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change this to the server's IP address or hostname
        int serverPort = 12345; // Change this to the server's port number

        try {
            Socket clientSocket = new Socket(serverAddress, serverPort);
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("File name: ");
                String fileName = scanner.nextLine();

                dos.writeUTF(fileName);

                boolean fileExists = dis.readBoolean();
                if (fileExists) {

                    System.out.println("\nFile received successfully");
                } else {
                    System.out.println("File not found on the server");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
