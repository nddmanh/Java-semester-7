package model;

public class Register {
	private String name, username, password, city;
	
	public Register() {
		super();
	}

	public Register(String name, String username, String password, String city) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
