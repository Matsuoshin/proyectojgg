/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Configuracion;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Joaquín
 */
public class Configuracion {
    private String sFichero;
    private List<String> microsoft = Arrays.asList("Windows 98" , "Windows XP", "Windows Vista", "Windows 7");

    public String dBiblioteca(){

        if (microsoft.contains(System.getProperty("os.name"))) {
            sFichero = "Config\\biblioteca.txt";
            System.out.println("Estas en windows: " + System.getProperty("os.name"));
        } else if (System.getProperty("os.name").equalsIgnoreCase("linux")) {
            sFichero = "Config//biblioteca.txt";
            System.out.println("Estas en linux: " + System.getProperty("os.name"));
        } else if (System.getProperty("os.name").equalsIgnoreCase("mac")) {
            sFichero = "Config//biblioteca.txt";
            System.out.println("Estas en mac: " + System.getProperty("os.name"));
        }

        return sFichero;
    }

}
