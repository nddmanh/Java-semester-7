package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nddmanh
 */
public class DatabaseConnection {
    private String jdbcURL = "jdbc:mysql://localhost:3306/th2-ltm?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "systemadmin";

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {}
    
    public Connection getConnection() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Connected to Database.");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return connection;
    }
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
