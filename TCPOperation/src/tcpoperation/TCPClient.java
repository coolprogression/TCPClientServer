/*
Project A1: TCP
Filename : TCPClient.java
Authors: Toni Oluyide, Matt Simon
Language; Java
Instructions: Run This File after TCPServer.java

 */
package tcpoperation;
import java.net.*;
import java.io.*;

public class TCPClient {

    ///socket handling
    public static void main(String[] args) throws Exception {
    
    //Keeping things simple dealing with string manipulation,taking white spaces
    //out of sentence and returning that after we type
    String modphrase;
    String phrase;
    //creates a socket for our client with our specific port (505?), address local host
  Socket clientsock = new Socket("localhost",5052);
  
  //this buffer is charge of handling our first input,thru the console itself
  BufferedReader initial = new BufferedReader(new InputStreamReader(System.in));
  
  
   //same method as the server, creates a buffer for incoming data,allows for data to be send
   //System.in since I plan to take user input directly and modifing it
  BufferedReader inbound= new BufferedReader(new InputStreamReader(clientsock.getInputStream()));
  DataOutputStream outbound = new DataOutputStream(clientsock.getOutputStream());
 
  //reads input  //sends info over to server
  phrase = initial.readLine();
  outbound.writeBytes(phrase + '\n');
  
 ///allows for the recieving of data from server and presents the mod word to the user
  modphrase = inbound.readLine(); 
  System.out.println("Here's the Modified Word: " + modphrase);
 
  //closing client socket
  clientsock.close();
  
    }
    
}
