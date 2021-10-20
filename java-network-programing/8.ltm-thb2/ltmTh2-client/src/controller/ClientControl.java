package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import model.Congnhan;
import model.Quequan;
import view.ClientView;
import view.ThemCongNhamFrm;
import run.ClientRun;

public class ClientControl {

    private ClientView viewMain;

    
    public Object connect(Object data) {
        try {

            System.out.println("Client is ready...");
            Socket mySocket = new Socket("localhost", 2000);

            //Sending to server            
            if (data instanceof Congnhan) {
                Congnhan congnhan = (Congnhan) data;
                ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
                oos.writeObject(congnhan);
            }
            if (data instanceof String) {
                String str = (String) data;
                ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
                oos.writeObject(str);
            }
            if (data instanceof Quequan) {
                Quequan quequan = (Quequan) data;
                ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
                oos.writeObject(quequan);
            }

            // Receive
            Object result = null;
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            Object o = ois.readObject();

            if(o instanceof String){
                result = (String)o;
            }
            if(o instanceof ArrayList){
                System.out.println(((ArrayList)o).size());
                if(((ArrayList)o).size()>0 && (((ArrayList)o).get(0) instanceof Congnhan)){
                    result = (ArrayList<Congnhan>) o;
                }
                if(((ArrayList)o).size()>0 && (((ArrayList)o).get(0) instanceof Quequan)){
                    result = (ArrayList<Quequan>) o;
                }
            }
            return result;

        } catch (UnknownHostException e) {
                e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public void addCongNhan(Congnhan congnhan) {
        String result = (String) connect(congnhan);
        if (result.equals("OK")) {
            ClientRun.addCnView.resetInput();
            ClientRun.addCnView.showMessage("them cong nhan thanh cong");
        }
    }
    
    public void searchCongNhan(Congnhan congnhan) {
        ArrayList<Congnhan> congnhans = (ArrayList<Congnhan>) connect(congnhan);
        if (congnhans != null)  {
            if (congnhans.get(0).getStatus().equals("OK")) {
                ClientRun.timCongNhanView.setTableData(congnhans);
            }
        } else {
            System.out.println("khong co");
        }
    }
    
    public void searchQQ(Congnhan congnhan) {
        ArrayList<Congnhan> congnhans = (ArrayList<Congnhan>) connect(congnhan);
        if (congnhans != null)  {
            if (congnhans.get(0).getStatus().equals("OKQQ")) {
                System.out.println("oke luon");
                ClientRun.lietKeCongNhanView.setTableData(congnhans);
            }
        } else {
            System.out.println("khong co");
        }
    }
    
    public void getQueQuan(Quequan quequan) {
        ArrayList<Quequan> quequans = (ArrayList<Quequan>) connect(quequan);
        if (quequans != null) {
            if (quequans.get(0).getStatus().equals("OK")) {
                for(int i = 0 ; i < quequans.size() ; i++) {
                    ClientRun.addCnView.setListQueQuan(quequans.get(i).getId(), quequans.get(i).getTinh());
                    ClientRun.lietKeCongNhanView.setListQueQuan(quequans.get(i).getId(), quequans.get(i).getTinh());
                }
            }
        } else {
            System.err.println("hic chua nhan dc");
        }
        
    }
}
