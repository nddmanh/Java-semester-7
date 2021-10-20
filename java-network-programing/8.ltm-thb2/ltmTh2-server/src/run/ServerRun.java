package run;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import view.ServerView;
/**
 *
 * @author nddmanh
 */
public class ServerRun {
    public void serve() {
        try {
                String content = "Server is ready....";
                ServerView serverView = new ServerView();
                serverView.setVisible(true);
                serverView.setLocationRelativeTo(null);

                ServerSocket server = new ServerSocket(2000);
                int count = 0;

                while (true) {
                        System.out.println("Client: " + ++count);
                        Socket socket = server.accept();

                        new ServerThread(socket).start();

                }

        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
            ServerRun server = new ServerRun();
            server.serve();

    }
}
