/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;

import Reproductor.MedioStrategy;
import java.io.File;

/**
 *
 * @author Joaquín
 */
public interface IPrincipal {

    /**
     * @return the ultimaCancion
     */
    File getUltimaCancion();

    /**
     * @return the repiteLista
     */
    boolean isRepiteLista();

    /**
     * @return the repiteUna
     */
    boolean isRepiteUna();

    void reproducirMedio(File archivo);
    public void streaming(String url);

    public MedioStrategy getMedio();
    public void setMedio(MedioStrategy medio);

}
