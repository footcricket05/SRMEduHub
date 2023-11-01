import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FTPServer {
    public static void main(String[] args) {
        int port = 12345; // Change this to your desired port number

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Create a new thread to handle each client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams for file transfer
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                // Read the requested file name from the client
                String fileName = dis.readUTF();
                System.out.println("Client requested file: " + fileName);

                // Open and send the file content to the client
                File file = new File(fileName);
                if (file.exists()) {
                    dos.writeBoolean(true); // Indicate that the file exists
                    
                    System.out.println("File sent successfully");
                } else {
                    dos.writeBoolean(false); // Indicate that the file does not exist
                    System.out.println("File not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
