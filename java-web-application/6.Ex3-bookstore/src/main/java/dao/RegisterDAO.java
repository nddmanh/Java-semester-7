package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Register;

public class RegisterDAO {
	private String dbUrl = "jdbc:mysql://localhost:3306/bookstore1";
	private String dbUname = "root";
	private String dbPassword = "systemadmin";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
			System.out.println("Connected DB.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	public String insert(Register account)
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data entered successfully";
		String sql = "INSERT INTO users (name, username, password, city) VALUES (?, ?, ?, ?);";
				
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, account.getName());
			ps.setString(2, account.getUsername());
			ps.setString(3, account.getPassword());
			ps.setString(4, account.getCity());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}

}
