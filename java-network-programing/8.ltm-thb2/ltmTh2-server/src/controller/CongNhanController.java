package controller;

import connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author nddmanh
 */
public class CongNhanController {
    //  SQL
    private final String INSERT_USER = "INSERT INTO congnhan (hoten, namsinh, gioitinh, quequanid, hs) VALUES (?, ?, ?, ?, ?)";
    
    private final String CHECK_USER = "SELECT id FROM congnhan WHERE id = ? limit 1";
    
    private final String SEARCH_USER = "SELECT * FROM congnhan, quequan WHERE congnhan.quequanid = quequan.id AND hoten LIKE ?";
    
    private final String SEARCHQQ_USER = "SELECT * FROM congnhan, quequan WHERE congnhan.quequanid = quequan.id AND congnhan.quequanid = ?";
    
    //  Instance
    private final Connection con;
    
    public CongNhanController() {
        this.con = DatabaseConnection.getInstance().getConnection();
    }
    
    public String insert(Congnhan congnhan) {
    	//  Check user exit
        try {
            PreparedStatement p = con.prepareStatement(INSERT_USER);
            p.setString(1, congnhan.getHoten());
            p.setString(2, congnhan.getNamsinh());
            p.setString(3, congnhan.getGioitinh());
            p.setInt(4, congnhan.getQuequanId());
            p.setString(5, congnhan.getHsluong());
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "OK";
    }
    
    public List<Congnhan> searchCongnhans(String name) {
        List<Congnhan> congnhans = new ArrayList<>();
        try {
            PreparedStatement p = con.prepareStatement(SEARCH_USER);
            p.setString(1, "%" + name + "%");
            
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                String hoten = rs.getString("hoten");
                String namsinh = rs.getString("namsinh");
                String gioitinh = rs.getString("gioitinh");
                String tinh = rs.getString("tinh");
                String heso = rs.getString("hs");
                String status = "OK";
                congnhans.add(new Congnhan(hoten, namsinh, tinh, gioitinh, heso, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return congnhans;
    }
    
    public List<Congnhan> searchCongnhanQQs(int qqId) {
        List<Congnhan> congnhans = new ArrayList<>();
        try {
            PreparedStatement p = con.prepareStatement(SEARCHQQ_USER);
            p.setInt(1, qqId);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                String hoten = rs.getString("hoten");
                String namsinh = rs.getString("namsinh");
                String gioitinh = rs.getString("gioitinh");
                String tinh = rs.getString("tinh");
                String heso = rs.getString("hs");
                String status = "OKQQ";
                congnhans.add(new Congnhan(hoten, namsinh, tinh, gioitinh, heso, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return congnhans;
    }
    
    
}
