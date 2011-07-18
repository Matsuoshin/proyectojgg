/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Ficheros.ficheros;
import Streaming.clienteStreaming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;

/**
 *
 * @author joaquin
 */
public class Servidor extends Thread implements IServidor {

    private ServerSocket s;  //Socket servidor
    private Socket sc;      //Socket cliente
    private PrintStream p;    //Canal de escritura
    private BufferedReader b;      //Canal de Lectura
    private String mensaje;
    private InetAddress address;
    private String sHostName;
    private String sIPAddress;
    //Inicializamos la variable.
    private IPublicIP ip = new publicIP();

    private clienteStreaming cs = new clienteStreaming();
    private ficheros f = new ficheros();

    public Servidor() {
        //No hago nada :)
    }

    //IPublicIP ip = new publicIP();
    @Override
    public void run() {

        try {
            //Creo el socket server
            s = new ServerSocket(9999);

            System.out.println("Arranco el servidor general");

            while (true) {
                /*
                 * Invoco el metodo accept del socket servidor, me devuelve una
                 * referencia al socket cliente.
                 *
                 * Con esto consigo aceptar conexiones de un cliente al servidor.
                 */
                sc = s.accept();

                //Obtengo una referencia a los canales de escritura y lectura del socket cliente
                b = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                p = new PrintStream(sc.getOutputStream());

                System.out.println("Conectado a un programa CLIENTE.");

                //Leo lo que escribio el socket cliente en el canal de lectura
                mensaje = b.readLine();
                System.out.println(mensaje);

                //Gestiono el comando enviado por el cliente

                /*
                 * Si el mensaje enviado por el cliente es "dameIP", el servidor
                 * hace uso de la clase publicIP para obtener su IP pública
                 * y enviársela al cliente.
                 */
                if (mensaje.equals("dameIP")) {
                    //Obtenemos nuestra IP pública.
                    sIPAddress = ip.getIP();
                    System.out.println(sIPAddress);

                    //Enviamos al cliente la IP pública del servidor.
                    p.println(sIPAddress);

                } else if (mensaje.equals("fin")) {
                    //System.out.println("Parando el servidor...");
                    break;
                } else if (mensaje.equals("dameLISTA")){
                    String st;
                    st = f.leeFichero("config");
                    cs.arrancaCliente(st);
                } else {
                    //Escribo en canal de escritura el mismo mensaje recibido
                    p.println("Comando desconocido por el servidor: " + mensaje);
                }

            }

            b.close();
            p.close();
            sc.close();
            s.close();

        } catch (IOException e) {
            System.out.println("No puedo crear el socket:" + e.getMessage());
        }

    }

    @Override
    public void conectar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
