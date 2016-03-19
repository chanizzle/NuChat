/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuchat.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasminechan
 */

// Thread for listening on the receiving port

public class MessageListener extends Thread{
    ServerSocket server;
    // default the port to 8877
    int port = 8877;
    WriteableGUI gui;
    String login;
    
    public MessageListener(int port, WriteableGUI gui, String login) {
        this.port = port;
        this.gui = gui;
        this.login = login;
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MessageListener() {
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        try {
            // initialize the connetion to the port
            Socket clientSocket;
            
            // loop through the clientSocket until server is null (eg: port closed)
            while ((clientSocket = server.accept()) != null) {
                // getting string from clientSocket
                InputStream inputStream = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line = br.readLine();
                if (line != null) {
                    gui.write(line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
