/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kota_server;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class Kota_Server implements Serializable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        // TODO code application logic here
        new Socket_Server();
        //new database();
    }
    
}
