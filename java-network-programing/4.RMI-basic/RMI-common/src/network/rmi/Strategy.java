package network.rmi;

import java.io.Serializable;

public class Strategy implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;

	public Strategy(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
