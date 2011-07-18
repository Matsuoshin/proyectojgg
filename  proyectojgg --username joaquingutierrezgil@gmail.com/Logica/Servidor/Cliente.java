/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author joaquin
 */
public class Cliente {

    private Socket s;
    private PrintStream p;
    private BufferedReader b;
    private String host = "192.168.1.35";
    private int port = 9999;
    private String respuesta;

    public void conectar() {
        //Referencia a la entrada por consola (System.in)
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {

            //Creo una conexion al socket servidor
            s = new Socket(host, port);

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader(new InputStreamReader(s.getInputStream()));

            while (true) {
                //Ingreso un String por consola
                System.out.print("Mensaje a enviar: ");

                //Escribo en el canal de escritura del socket
                p.println(in.readLine());

                //Espero la respuesta por el canal de lectura
                respuesta = b.readLine();
                System.out.println(respuesta);
                if (respuesta.equals("by")) {
                    break;
                }
            }
            p.close();
            b.close();
            s.close();

        } catch (UnknownHostException e) {
            System.out.println("No puedo conectarme a " + host + ":" + port);
        } catch (IOException e) {
            System.out.println("Error de E/S en " + host + ":" + port);
        }
    }
}
