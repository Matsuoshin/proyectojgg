/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

/**
 *
 * @author Joaquín
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        ICliente c = new Cliente();
        cProxy p = new cProxy();

        if (p.detect("www.google.es") == true) {
            System.out.println("Estas conectado a traves de un proxy a internet.");
            c.conexionProxy();
        } else if (p.detect("www.google.es") == false) {
            System.out.println("Estas conectado directamente a internet.");
            c.conexion("dameIP");
        } else {
            System.out.println("Se ha producido un error al detectar la red.");
        }
         *
         */

        Cliente cf = new Cliente();
        //cf.pide("C:/ConfigStreaming/hola.txt", "192.168.1.35", 35557);
    }
}
