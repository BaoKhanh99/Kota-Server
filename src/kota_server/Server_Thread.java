package kota_server;

import java.io.ObjectInputStream;
import java.net.Socket;
import Kota_client.Infor_User;
public class Server_Thread extends Thread {
    Socket socket = null;
    public Server_Thread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Infor_User infor_User = (Infor_User) ois.readObject();
            System.out.println("say something di: "+infor_User.getAccount());
            socket.close();
        } 
        catch (Exception e) {
			// TODO: handle exception
	}
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
