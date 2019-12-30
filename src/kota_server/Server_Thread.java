package kota_server;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Server_Thread  extends Thread{
    Socket socket = null;
    ObjectOutputStream oos;
    Boolean is_running = true;
    Statement stm ;
    ResultSet rss;
    database db;
    ObjectInputStream reader;
    InputStream i ;
    OutputStream o;
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

    public Runnable ClientHandler(Socket socket) throws IOException, ClassNotFoundException, SQLException {
        Socket sk = socket;
        o = sk.getOutputStream();
        i = sk.getInputStream();
        reader = new ObjectInputStream(i);
        
        //String[] a = (String[]) reader.readObject();
        String[] data =  (String[]) reader.readObject();
        String action = data[0];
        System.out.println("alo "+o);
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
        String query = "INSERT INTO info_user(Username,Yob, Address, Account, Password) VALUES('"+data[1]+"','"+data[3]+"','"+data[2]+"','"+data[4]+"','"+data[5]+"')";
        stm = db.cnn.createStatement();
        int i = stm.executeUpdate(query);
        if(i>0){
            System.out.println("hihi");
            oos = new ObjectOutputStream(o);
            System.out.println("huhu");
            String[] senddata = new String[2];
            senddata[0] = "reg";
            senddata[1] = "true";
            
            oos.writeObject(senddata);
            System.out.println("success");
        }
        else System.out.println("fail");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
