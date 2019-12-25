/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kota_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class database{
    Connection cnn;
    Statement stm ;
    ResultSet rss;

    public database() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.cnn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kota_chat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            System.out.println("aaa");
            stm = cnn.createStatement();
            rss = stm.executeQuery("select * from info_user");
            while(rss.next()){
						
                String username=rss.getString("Username");
                String yob =rss.getString("Yob");						
                String add= rss.getString("Address");
                String acc= rss.getString("Account");
                String pass= rss.getString("Password");
                System.out.println(username+" "+yob+" "+add+" "+acc+" "+pass);
            }
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }   
}
