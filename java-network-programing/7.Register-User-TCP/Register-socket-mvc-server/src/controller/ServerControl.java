package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.User;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class ServerControl {
    private Connection con;
    private ServerSocket myServer;
    private int serverPort = 8888;
    public ServerControl(){
        getDBConnection("banhang", "root", "systemadmin");
        openServer(serverPort);
        
        while(true){
            listenning();
        }
    }
    
    private void getDBConnection(String dbName, String username, String password){

        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
        String dbClass = "com.mysql.cj.jdbc.Driver";
        
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection (dbUrl, username, password);
            System.out.println("Connected to database!");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
        
    private void openServer(int portNumber){
        try {
            myServer = new ServerSocket(portNumber);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    private void listenning(){
        try {
            Socket clientSocket = myServer.accept();
            ObjectInputStream ois = new
            ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new
            ObjectOutputStream(clientSocket.getOutputStream());
            Object o = ois.readObject();
            
            if(o instanceof User){
                User user = (User)o;
                
                if(addUser(user)){
                    oos.writeObject("ok");
                }
                else
                    oos.writeObject("false");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }      
    
    private boolean addUser(User user) throws Exception {
        String CHECK_USER = "select id from users where username = ? limit 1";
        String INSERT_USER = "insert into users (username, password, dob, address, gender, des) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p = con.prepareStatement(CHECK_USER);
            p.setString(1, user.getUserName());
            ResultSet r = p.executeQuery();
            if (r.first()) {
                return false;
            } else {
                r.close();
                p.close();
                p = con.prepareStatement(INSERT_USER);
                p.setString(1, user.getUserName());
                p.setString(2, user.getPassword());
                p.setString(3, user.getDob());
                p.setString(4, user.getAddress());
                p.setString(5, user.getGender());
                p.setString(6, user.getDes());
                p.executeUpdate();
                p.close();
                return true;
            }
        }catch(Exception e) {
            throw e;
        }
    }
}
