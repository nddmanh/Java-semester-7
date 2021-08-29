package socket.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import socket.model.Message;

public class ClientSerialization {
	public void connect() {
		try {
			System.out.println("Client is ready...");
			Socket socket = new Socket("localhost", 2000);
			
			// Sending to server
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			Message m1 = new Message("Study", "Give me some ebooks");
			oos.writeObject(m1);
			System.out.println("Send to the server: " + m1.getTitle() + " " + m1.getBody());
			
			// Receive
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Message m2 = (Message)ois.readObject();
			if (m2 != null) {
				System.out.println("Received from the server: " + m2.getTitle() + " " + m2.getBody());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ClientSerialization c = new ClientSerialization();
		c.connect();
	}
}
