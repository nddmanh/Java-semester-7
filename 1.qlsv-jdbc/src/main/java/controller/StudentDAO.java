package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public class StudentDAO {
	
	public Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/demo?" + "autoReconnect=true&useSSL=false";
		final String user = "root";
		final String password = "systemadmin";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connected to Database.");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	Connection conn = getJDBCConnection();
	
	public boolean add(Student s) {
		String sql = "INSERT INTO tblStudent(id, name, address, email, phone, avg) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getAddress());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getPhone());
			ps.setFloat(6, s.getAvg());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(Student s) {
		String sql = "UPDATE tblStudent SET name = ?, address = ?, email = ?, phone = ?, avg = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1, s.getName());
			ps.setString(2, s.getAddress());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPhone());
			ps.setFloat(5, s.getAvg());
			ps.setString(6, s.getId());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean remove(String id) {
		String sql = "DELETE FROM tblStudent WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Student> getList() {
		ArrayList<Student> list = new ArrayList<>();
		
		String sql = "SELECT * FROM tblStudent";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student e = new Student();
				
				e.setId(rs.getString("id"));
				e.setName(rs.getString("name"));
				e.setAddress(rs.getString("address"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setAvg(rs.getFloat("avg"));
				
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Student getStudentById(String id) {
		String sql = "SELECT * FROM tblStudent WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student e = new Student();
				
				e.setId(rs.getString("id"));
				e.setName(rs.getString("name"));
				e.setAddress(rs.getString("address"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setAvg(rs.getFloat("avg"));
				
				return e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
