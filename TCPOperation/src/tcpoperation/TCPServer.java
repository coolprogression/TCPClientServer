/*
Project A1: TCP
Filename : TCPServer.java
Authors: Toni Oluyide, Matt Simon
Language: Java
Instructions: Run this File and then TCPClient to
start the program
 */
package tcpoperation;
import java.net.*; 
import java.io.*;

public class TCPServer {


   public static void main(String argv[]) throws Exception {
   String modstring,recievedstring;
   ///creates our server socket
   ServerSocket servsock = new ServerSocket(5052);
   //initializing a waiting session for a client
   while(true){
   Socket connectsock = servsock.accept();
   //creates that buffer for our incoming/outbound info, 
   BufferedReader inbound= new BufferedReader(new InputStreamReader(connectsock.getInputStream()));
   DataOutputStream outbound = new DataOutputStream(connectsock.getOutputStream());
   //reads incoming string, confirms that it has been recieved (reads and stores our data)
   recievedstring = inbound.readLine();
   System.out.println("Recieved :"+recievedstring);
   
   //modifing the recieved data from the client 
    recievedstring=recievedstring.trim();
    modstring = recievedstring.replaceAll("\\s","");
   
    //sends our "moddded" information back to the client
    outbound.writeBytes(modstring+ '\n');
  
    
   
   
 //closes connection sock
    connectsock.close();
   }
   
}
}