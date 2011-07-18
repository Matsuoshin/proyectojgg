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
import java.net.Socket;

/**
 *
 * @author Joaquín
 */
public class clienteStreaming {

    //Variables del cliente
    private DataInputStream input;
    private BufferedInputStream bisC;
    private BufferedOutputStream bosC;
    private int inC;
    private byte[] byteArray;
    private String fileC = "C:\\ConfigStreaming\\listaStreamingLOCAL.txt";

        public void arrancaCliente(String host) {
        try {
            Socket client = new Socket(host, 1234);
            bisC = new BufferedInputStream(new FileInputStream(fileC));
            bosC = new BufferedOutputStream(client.getOutputStream());

            //enviamos el nombre del archivo
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF(fileC);

            byteArray = new byte[8192];
            while ((inC = bisC.read(byteArray)) != -1) {
                bosC.write(byteArray, 0, inC);
            }

            bisC.close();
            bosC.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
