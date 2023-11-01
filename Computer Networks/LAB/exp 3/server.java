import java.io.*;
import java.net.*;
class server
{
public static void main(String args[])
{
String buff;
ServerSocket s;
Socket in;
try
{
s=new ServerSocket(4550);
in=s.accept();
BufferedReader b=new BufferedReader(new InputStreamReader(in.getInputStream()));
PrintWriter pw=new PrintWriter(in.getOutputStream(),true);
System.out.println("Connection Established");
buff=b.readLine();
System.out.println("client said "+ buff);
pw.println(buff);
}
catch (IOException e) {}
}
}