/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kota_server;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kota_server.Socket_Data;

public class Socket_Server {
    public Socket_Server() throws IOException, SQLException{
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("server up and ready for connections");
        while(true) {
            Socket socket = ss.accept();
            new Server_Thread(socket).start();
        }
    }
    
}
