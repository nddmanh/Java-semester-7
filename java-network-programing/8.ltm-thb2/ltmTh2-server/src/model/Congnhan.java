package model;

import java.io.Serializable;

/**
 *
 * @author nddmanh
 */
public class Congnhan implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String hoten;
    private String namsinh;
    private int quequanId;
    private String tinh;
    private String gioitinh;
    private String hsluong;
    private String status;

    public Congnhan() {
    }

    public Congnhan(String hoten, String namsinh, int quequanId, String gioitinh, String hsluong, String status) {
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.quequanId = quequanId;
        this.gioitinh = gioitinh;
        this.hsluong = hsluong;
        this.status = status;
    }

    public Congnhan(String hoten, String namsinh, String tinh, String gioitinh, String hsluong, String status) {
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.tinh = tinh;
        this.gioitinh = gioitinh;
        this.hsluong = hsluong;
        this.status = status;
    }

   
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public int getQuequanId() {
        return quequanId;
    }

    public void setQuequanId(int quequanId) {
        this.quequanId = quequanId;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getHsluong() {
        return hsluong;
    }

    public void setHsluong(String hsluong) {
        this.hsluong = hsluong;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }
    
    
}
