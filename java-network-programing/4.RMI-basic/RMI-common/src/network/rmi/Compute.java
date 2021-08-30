package network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
	public int add(int a, int b) throws RemoteException;
	
	public String deploy(Strategy strategy) throws RemoteException;
}
