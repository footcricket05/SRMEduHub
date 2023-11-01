import java.io.*;
import java.net.*;

public class UdpEchoClient {
    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 8888;

            DatagramSocket socket = new DatagramSocket();

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a message to send to the server: ");
            String messageToSend = userInput.readLine();

            byte[] sendData = messageToSend.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            socket.receive(receivePacket);

            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Message received from the server: " + receivedMessage);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}