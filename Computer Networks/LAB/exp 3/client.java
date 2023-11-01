import java.io.*;
import java.net.*;
class client
{
public static void main(String args[])
{
String buff;
Socket s;
try
{
s=new Socket("127.0.0.1",4550);
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
BufferedReader b1=new BufferedReader(new InputStreamReader(s.getInputStream()));
PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
System.out.println("Connection Established");
System.out.println("Enter the data............");
buff=b.readLine();
pw.println(buff);
buff=b1.readLine();
System.out.println(buff);
System.out.println("Echo Received");
}
catch (IOException e) {}
}
}