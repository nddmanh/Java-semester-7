package model;

import java.io.Serializable;

/**
 *
 * @author nddmanh
 */
public class Quequan implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String tinh;
    private String status;

    public Quequan() {
    }

    public Quequan(int id, String tinh) {
        this.id = id;
        this.tinh = tinh;
    }
    
    public Quequan(int id, String tinh, String status) {
        this.id = id;
        this.tinh = tinh;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return tinh;
    }
    
    
}
