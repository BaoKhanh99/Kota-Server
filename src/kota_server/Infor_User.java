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
public class Infor_User implements Serializable{
    private String UserName;
    private String Address;
    private int YoB;
    private String Account;
    private String Password;
    
    

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getYoB() {
        return YoB;
    }

    public void setYoB(int YoB) {
        this.YoB = YoB;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String Account) {
        this.Account = Account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public Infor_User(String UserName, String Address, int YoB, String Account, String Password){
        super();
        this.UserName = UserName;
        this.Address = Account;
        this.YoB = YoB;
        this.Account = Account;
        this.Password = Password;
    }
    public Infor_User(){
        super();
    }
}
