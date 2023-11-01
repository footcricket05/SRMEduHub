import java.io.*;
import java.net.*;

class ARPClient {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter IP address: ");
        String ip = br.readLine();
        Socket s = new Socket("localhost", 8888);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        dout.writeUTF(ip);
        dout.flush();
        dout.close();
        s.close();
    }
}