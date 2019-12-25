package kota_server;

import java.io.ObjectInputStream;
import java.net.Socket;
import Kota_client.Socket_Receive;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Server_Thread extends Thread {
    Socket socket = null;
    ObjectOutputStream oos;
    Boolean is_running = true;
    Statement stm ;
    ResultSet rss;
    database db;
    
    public Server_Thread(Socket socket) throws SQLException {
        this.db = new database();
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            
            Thread listener = new Thread(ClientHandler(socket));
            listener.start();
//            String[] infor =  infor_User.getData();
//            System.out.println("say something di: "+infor[0]+infor[1]);
            socket.close();
        } 
        catch (Exception e) {
			// TODO: handle exception
	}
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }

    private Runnable ClientHandler(Socket socket) throws IOException, ClassNotFoundException, SQLException {
        Socket sk = socket;
        ObjectInputStream ois = new ObjectInputStream(sk.getInputStream());
        Socket_Receive sock_data = (Socket_Receive) ois.readObject();
        String[] data =  sock_data.getData();
        String action = sock_data.getAction();
        String reg = "reg" ;
        while (is_running) {            
            switch(action){
                        case "reg":             registration(data); break;
                        
                        default: System.out.println("unknow action");
                    }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void registration(String[] data) throws SQLException, IOException {
        String query = "INSERT INTO info_user(Username,Yob, Address, Account, Password) VALUES('"+data[0]+"','"+data[2]+"','"+data[1]+"','"+data[3]+"','"+data[4]+"')";
        stm = db.cnn.createStatement();
        int i = stm.executeUpdate(query);
        if(i>0){
            String[] senddata = new String [1];
            senddata[0] = "succes";
            String action = "reg";
            Socket_Data sd = new Socket_Data();
            sd.setData(senddata);
            sd.setAction(action);
//            oos = new ObjectOutputStream(socket.getOutputStream());
//            oos.writeObject(sd);
            System.out.println("success");
        }
        else System.out.println("fail");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
