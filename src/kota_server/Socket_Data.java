/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kota_server;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Socket_Data implements Serializable{
    public String[] data;
    public String action;

    public Socket_Data(String action,String[] data) {
        this.action = action;
        this.data = data;
    }

    public Socket_Data() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
