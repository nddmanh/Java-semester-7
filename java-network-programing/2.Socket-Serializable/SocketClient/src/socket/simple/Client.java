package socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public void connect() {
		try {
			Socket socket = new Socket("localhost", 2000);
			// Sending to server
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println("Hello world!");
			
			// Receiving from server
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = br.readLine();
			if (response != null) {
				System.out.println("Server answered: "+ response);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		c.connect();
	}
}
