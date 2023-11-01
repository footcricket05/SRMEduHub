import java.io.*;
import java.net.*;

class ARPServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        String ip = din.readUTF();
        String mac = getMacAddress(ip);
        System.out.println("MAC address of " + ip + " is " + mac);
        ss.close();
    }

    private static String getMacAddress(String ip) throws Exception {
        // Look up ARP cache for MAC address
        return "00:11:22:33:44:55"; // Replace with actual MAC address
    }
}