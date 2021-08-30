package network.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import network.rmi.Compute;
import network.rmi.Strategy;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Start client...");
		String host = "localhost";
		int port = 1099;
		try {
			Registry registry = LocateRegistry.getRegistry(host, port);
			Compute math = (Compute) registry.lookup("math");
			System.out.println(math.add(3, 10));
			System.out.println(math.add(31, 12));
			
			System.out.println("Strategy: " + math.deploy(new Strategy("Manh")));
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Client is closed.");
	}
}
