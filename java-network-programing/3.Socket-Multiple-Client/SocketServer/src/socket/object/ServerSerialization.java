package socket.object;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSerialization {
	public void serve() {
		try {
			ServerSocket server = new ServerSocket(2000);
			System.out.println("Server is ready....");
			int count = 0;

			while (true) {
				System.out.println("Client: " + ++count);
				Socket socket = server.accept();
				new ServerThread(socket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		ServerSerialization server = new ServerSerialization();
		server.serve();
	}
}
