package kota_server;

import java.io.ObjectInputStream;
import java.net.Socket;
import Kota_client.Socket_Receive;
public class Server_Thread extends Thread {
    Socket socket = null;
    public Server_Thread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Socket_Receive infor_User = (Socket_Receive) ois.readObject();
            String[] infor =  infor_User.getData();
            System.out.println("say something di: "+infor[0]+infor[1]);
            socket.close();
        } 
        catch (Exception e) {
			// TODO: handle exception
	}
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
