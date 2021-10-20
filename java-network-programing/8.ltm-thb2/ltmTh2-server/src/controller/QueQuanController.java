package controller;

import connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Congnhan;
import model.Quequan;

/**
 *
 * @author nddmanh
 */
public class QueQuanController {
    //  SQL
    private  final String SELECT_ALL_QUEQUAN = "select * from quequan";
    
    //  Instance
    private final Connection con;
    
    public QueQuanController() {
        this.con = DatabaseConnection.getInstance().getConnection();
    }
    
    public List<Quequan> selectAllQuequans() {
        List<Quequan> quequans = new ArrayList<>();
        try {
            PreparedStatement p = con.prepareStatement(SELECT_ALL_QUEQUAN);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tinh = rs.getString("tinh");
                String status = "OK";
                quequans.add(new Quequan(id, tinh, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quequans;
    }
}
