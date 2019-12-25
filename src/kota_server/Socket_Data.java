/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kota_server;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Socket_Data implements Serializable{
    private String[] data;
    private String action;

    public Socket_Data(String[] data) {
        this.data = data;
    }

    public Socket_Data(String action) {
        this.action = action;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    public Socket_Data(){
        super();
    }
}
