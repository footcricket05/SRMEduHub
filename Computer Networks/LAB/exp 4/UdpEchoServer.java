import java.io.*;
import java.net.*;

public class UdpEchoServer {
    public static void main(String[] args) {
        try {
            int serverPort = 8888;

            DatagramSocket socket = new DatagramSocket(serverPort);

            byte[] receiveData = new byte[1024];

            System.out.println("Server is listening on port " + serverPort);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String messageReceived = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Message received from client: " + messageReceived);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                byte[] sendData = messageReceived.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}