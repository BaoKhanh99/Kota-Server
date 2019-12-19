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
public class database {
    Connection cnn;
    Statement stm ;
    ResultSet rss;

    public database() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.cnn = (Connection) DriverManager.getConnection("jdbc:mysql//localhost:8080/kota_chat","root","");
            stm = cnn.createStatement();
            rss = stm.executeQuery("select * from info_user");
            while(rss.next()){
                System.out.println(rss.getString("Full_Name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
