/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Streaming;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Joaquín
 */
public class ServidorStreaming implements Runnable {

    //Variables del servidor
    private ServerSocket server;
    private Socket connection;
    private DataOutputStream output;
    private BufferedInputStream bis;
    private BufferedOutputStream bos;
    private byte[] receivedData;
    private int in;
    private String file;

    @Override
    public void run() {
        try {
            server = new ServerSocket(1234);
            while (true) {
                connection = server.accept();

                receivedData = new byte[1024];
                bis = new BufferedInputStream(connection.getInputStream());
                DataInputStream dis = new DataInputStream(connection.getInputStream());

                //recibimos el nombre del fichero
                file = dis.readUTF();
                file = file.substring(file.indexOf('/') + 1, file.length());

                //Modifico el nombre para que no coincida con el mio
                file = file.concat("_host");

                bos = new BufferedOutputStream(new FileOutputStream(file));
                while ((in = bis.read(receivedData)) != -1) {
                    bos.write(receivedData, 0, in);
                }
                
                bos.close();
                dis.close();

                break;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }


}
