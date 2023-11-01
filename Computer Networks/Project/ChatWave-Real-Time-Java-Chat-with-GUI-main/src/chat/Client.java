package chat;

import GUI.CaptureView;
import GUI.ChatView;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dvcarrillo
 */

public class Client {
    // Properties
    private String clientName;
    // Socket
    private Socket clientSocket ;
    // Streams
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream inData;
    private DataOutputStream outData;
    
    private boolean option = true;
    private ChatView chatView;

    public Client(ChatView chatView) {
        this.chatView = chatView;
    }
    
    public String getUsername() {
        return clientName;
    }
    
    public void SetConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            Thread th1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (option) {
                        ListenData(chatView);
                    }
                }
            });
            th1.start();
            System.out.println("Successfully connected to " + ip + ":" + port);
        } catch (IOException ex) {
           System.err.println("ERROR: connection error");
           System.exit(0);
        }
    }
    
    public void SendMessage(String msg) {
        try {
            outputStream = clientSocket.getOutputStream();
            outData = new DataOutputStream(outputStream);
            outData.writeUTF(msg);
            outData.flush();
        } catch (IOException ex) {
            System.err.println("ERROR: error sending data");
        }
    }
    
    public void ListenData(ChatView chatView) {
        try {
            inputStream = clientSocket.getInputStream();
            inData = new DataInputStream(inputStream);
            chatView.AddRemoteMessage(inData.readUTF());
        } catch (IOException ex) {
            System.err.println("ERROR: error listening data");
        }
    }
    
    public void CloseConnection() {
        try {
            outData.close();
            inData.close();
            clientSocket.close();
        } catch (IOException ex) {
            System.err.println("ERROR: error closing connection");
        }
    }
    
    public void SetClientProperties(String name) {
        clientName = name;
    }
    
    public static void main(String [] args) {
        ChatView chatView = new ChatView();
        Client cli = new Client(chatView);
        
        CaptureView captureView = new CaptureView(chatView, true);
        captureView.SetTitleText("Client login");
        captureView.SetIpEnable(true);
        captureView.setVisible(true);
        
        String cliName = captureView.GetUsername();
        cli.SetClientProperties(cliName);
        
        String ipMachine = captureView.GetIP();
        int portMachine = captureView.GetPort();
        cli.SetConnection(ipMachine, portMachine);
        
        chatView.SetClient(cli);
        chatView.SetUsername(cliName);
        
        chatView.setVisible(true);
    }
}
