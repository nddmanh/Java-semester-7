package socket.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import socket.model.Message;

public class ServerThread extends Thread {
	private Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		// Receive
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		
			Message m1 = (Message)ois.readObject();
			if (m1 != null) {
				System.out.println("Receive a message from client: "+ m1.getTitle() + " " + m1.getBody());
					
				// Do something
				Message m2 = new Message("Ebooks", "Java network programming");
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(m2);
				System.out.println("Send a message to client: "+ m2.getTitle() + " " + m2.getBody());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
