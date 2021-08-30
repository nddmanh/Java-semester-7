package udp.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter a line: ");
			String st = s.nextLine();
			
			DatagramSocket datagramSocket = new DatagramSocket();
			byte[] readBuffer = new byte[1024];
			byte[] writeBuffer = null;
			
			InetAddress host = InetAddress.getByName("localhost");
			int port = 8079;
			
			writeBuffer = st.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(writeBuffer, writeBuffer.length, host, port);
			System.out.println("Sent: " + st);
			datagramSocket.send(sendPacket);
			
			DatagramPacket receivePacket = new DatagramPacket(readBuffer, readBuffer.length);
			datagramSocket.receive(receivePacket);
			
			String line = new String(receivePacket.getData());
			System.out.println("Received: " + line);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
