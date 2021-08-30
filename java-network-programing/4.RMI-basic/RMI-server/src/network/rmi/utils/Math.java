package network.rmi.utils;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import network.rmi.Compute;
import network.rmi.Strategy;

public class Math extends UnicastRemoteObject implements Compute {

	private static final long serialVersionUID = 1L;

	public Math() throws RemoteException {
		
	}
	
	@Override
	public int add(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a + b;
	}
	
	public static void main(String[] args) {
		try {
			Math math = new Math();
			System.out.println("Server is ready...");
			LocateRegistry.createRegistry(1099);
			Registry registry = LocateRegistry.getRegistry(1099);
			registry.bind("math", math);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server is closed.");
		
	}
	@Override
	public String deploy(Strategy strategy) throws RemoteException {
		// TODO Auto-generated method stub
		return strategy.getName();
	}
}
