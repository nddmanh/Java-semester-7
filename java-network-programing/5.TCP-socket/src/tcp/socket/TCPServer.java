package tcp.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6789);
			System.out.println("Listening...");
			while(true) {
				Socket socket = serverSocket.accept();
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				
				String line = reader.readLine();
				
				System.out.println("Received: " + line);
				System.out.println("Sent: " + line.toUpperCase());
				
				out.println(line.toUpperCase());
				out.flush();
				
				reader.close();
				out.close();
				socket.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
