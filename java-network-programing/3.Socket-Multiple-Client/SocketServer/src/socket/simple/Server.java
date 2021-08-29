package socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void serve() {
		try {
			ServerSocket server = new ServerSocket(2000);
			System.out.println("Server is ready....");
			Socket socket = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String request = br.readLine();
			if (request != null) {
				System.out.println("Received from a client:" + request);
				// Process: Select database, calculate,..
				
				// Response to client
				PrintStream ps = new PrintStream(socket.getOutputStream());
				ps.println(request.toUpperCase());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.serve();
	}
}
