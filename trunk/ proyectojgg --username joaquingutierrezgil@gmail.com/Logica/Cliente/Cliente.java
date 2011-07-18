/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Ficheros.ficheros;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.Proxy;
import java.net.UnknownHostException;

/**
 *
 * @author Joaquín
 */
public class Cliente implements ICliente {

    /*
     * Con esta clase conseguimos realizar una conexion como cliente
     * a un servidor conocido.
     *
     * Existen dos métodos, uno para conexiones directas a la red "conexion()", y otro
     * para conexiones a través de un proxy "conexionProxy()".
     */
    private String texto;
    private IEscribir escribir = new Escribir();
    private Socket s;
    private PrintStream p;
    private BufferedReader b;
    //private String host = "localhost";
    private String LoL = "192.168.1.35";
    private int port = 9999;
    private String respuesta;
    //Referencia a la entrada por consola (System.in)
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private ficheros f = new ficheros();

    public Cliente() {
        //No hago nada :)
    }

    @Override
    public void conexion(String texto, String host) {
        /*
         * A la hora de escribir este código no cuento con un servidor
         * público, por lo que estoy usando la IP local de uno de mis ordenadores
         * definida previamente en este mismo código.
         */
        String destino = f.leeFichero("config");
        boolean conexion = true;
        try {

            //Creo una conexion al socket servidor
            s = new Socket(host, port);

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader(new InputStreamReader(s.getInputStream()));

            /*
             * Mientras no se de la orden de parar el cliente, comando "fin",
             * sigue ejecutando el cliente.
             */
            while (true) {

                //Envio un comando por consola al servidor
                //System.out.print("Enviar comando: ");
                //texto = in.readLine();


                //Escribo en el canal de escritura del socket
                p.println(texto);

                //Espero la respuesta por el canal de lectura
                respuesta = b.readLine();
                System.out.println(respuesta);

                if (texto.equals("fin")) {//&& respuesta==null) {
                    //Detengo la ejecucion del cliente
                    System.out.println("Parando el cliente...");
                    break;
                } else if (texto.equals("dameIP")) {
                    //Pido al Servidor su IP pública
                    //escribir.escribirIP(respuesta);
                    escribir.escribir(respuesta);
                    break;
                } else {
                    System.out.println("Comando desconocido.");
                    break;
                }

            }

            /*
             * Cierro el socket del cliente y los canales de escritura
             * y lectura de la comunicacion
             */
            p.close();
            b.close();
            s.close();

        } catch (UnknownHostException e) {
            System.out.println("No puedo conectarme a " + destino + ":" + port);
        } catch (IOException e) {
            System.out.println("Error de E/S en " + destino + ":" + port + "\n");
            System.out.println("Error localizado: " + e.getMessage());
        }
    }
}
