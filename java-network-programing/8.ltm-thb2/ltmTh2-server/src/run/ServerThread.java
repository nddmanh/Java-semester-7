/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import model.Congnhan;
import controller.CongNhanController;
import controller.QueQuanController;
import java.util.ArrayList;
import model.Quequan;

/**
 *
 * @author admin
 */
public class ServerThread extends Thread {
    private Socket socket;
        private List<Congnhan> listCongNhan;
        
	public ServerThread(Socket socket) {
            this.socket = socket;
        }
        
	public void run() {
            
            // Receive
            ObjectInputStream ois;
            try {
                ois = new ObjectInputStream(socket.getInputStream());
                Object data = ois.readObject();
                
                if (data != null) {
                    if(data instanceof Congnhan){
                        Congnhan congnhan = (Congnhan)data;
                        String status = congnhan.getStatus();
                        
                        if(status.equals("ADD")) {
                            String message = new CongNhanController().insert(congnhan);

                            // Send to client
                            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                            oos.writeObject(message);
                        }
                        if(status.equals("SEARCH")) {
                            String name = congnhan.getHoten();
                            ArrayList<Congnhan> congnhans = (ArrayList<Congnhan>) new CongNhanController().searchCongnhans(name);

                            // Send to client
                            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                            oos.writeObject(congnhans);
                        }
                        if(status.equals("SEARCHQQ")) {
                            int qqId = congnhan.getQuequanId();
                            ArrayList<Congnhan> congnhans = (ArrayList<Congnhan>) new CongNhanController().searchCongnhanQQs(qqId);

                            // Send to client
                            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                            oos.writeObject(congnhans);
                        }
                        
                    }
                    if(data instanceof Quequan){
                        Quequan quequan = (Quequan)data;
                        String status = quequan.getStatus();
                        
                        if(status.equals("GET")) {
                            ArrayList<Quequan> quequans = (ArrayList<Quequan>) new QueQuanController().selectAllQuequans();

                            // Send to client
                            System.out.println("da send data");
                            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                            oos.writeObject(quequans);
                        }

                        
                    }
                    
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
	}
}
