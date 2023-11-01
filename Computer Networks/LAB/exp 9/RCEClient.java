import java.io.*;
import java.net.*;

public class RCEClient {
    public static void main(String[] args) {
        try {
            String serverIP = "127.0.0.1";
            int serverPort = 9876;
            
            DatagramSocket clientSocket = new DatagramSocket();
            
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            
            while (true) {
                System.out.print("Enter a command to execute on the server (or 'exit' to quit): ");
                String command = inputReader.readLine();
                
                if (command.equalsIgnoreCase("exit")) {
                    break;
                }
                
                byte[] sendData = command.getBytes();
                InetAddress serverAddress = InetAddress.getByName(serverIP);
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                clientSocket.send(sendPacket);
                
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                
                String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
                
                System.out.println("Server Response:\n" + result);
            }
            
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
