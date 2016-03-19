/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuchat.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasminechan
 */
public class MessageTransmitter extends Thread{
    String message;
    String hostname;
    int port;
    String from;
    
    public MessageTransmitter() {
    }
    
    public MessageTransmitter(String message, String hostname, int port, String from) {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
        this.from = from;
    }
    
    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname, port);
            s.getOutputStream().write(from.getBytes());
            s.getOutputStream().write(": ".getBytes());
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
