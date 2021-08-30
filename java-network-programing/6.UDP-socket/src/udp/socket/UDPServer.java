package udp.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(8079);
			byte[] readBuffer = new byte[1024];
			byte[] writeBuffer = null;
			
			System.out.println("Listening...");
			while(true) {
				DatagramPacket receivePacket = new DatagramPacket(readBuffer, readBuffer.length);
				datagramSocket.receive(receivePacket);
				
				String line = new String(receivePacket.getData());
				System.out.println("Received: " + line);
				
				writeBuffer = line.toUpperCase().getBytes();
				InetAddress host = receivePacket.getAddress();
				int port = receivePacket.getPort();
				
				DatagramPacket sendPacket = new DatagramPacket(writeBuffer, writeBuffer.length, host, port);
				System.out.println("Sent: " + line.toUpperCase());
				datagramSocket.send(sendPacket);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
