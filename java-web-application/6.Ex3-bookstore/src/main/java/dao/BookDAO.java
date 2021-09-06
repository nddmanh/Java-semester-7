package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore1?" + "autoReconnect=true&useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "systemadmin";
	private Connection jdbcConnection;
	
	
	public BookDAO() {

	}
	
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
										jdbcURL, jdbcUsername, jdbcPassword);
			System.out.println("Connected to Database.");
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public List<Book> listAllBooks() throws SQLException {
		List<Book> listBook = new ArrayList<>();
		
		String sql = "SELECT * FROM bookitem";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			String name = resultSet.getString("name");
			int quantity = resultSet.getInt("quantity");
			float price = resultSet.getFloat("price");
			String publisher = resultSet.getString("publisher");
			String discount = resultSet.getString("discount");
			
			Book book = new Book(name, quantity, price, publisher, discount);
			listBook.add(book);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listBook;
	}
	
	public Book getBook(int id) throws SQLException {
		Book book = null;
		String sql = "SELECT * FROM bookitem WHERE bookitemid = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String name = resultSet.getString("name");
			int quantity = resultSet.getInt("quantity");
			float price = resultSet.getFloat("price");
			String publisher = resultSet.getString("publisher");
			String discount = resultSet.getString("discount");
			
			Book book = new Book(name, quantity, price, publisher, discount);
		}
		
		resultSet.close();
		statement.close();
		
		return book;
	}
}
