/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.File;
import java.util.List;

/**
 *
 * @author Joaquín
 */
public interface IListasReproduccion {

    void addStreaming(String o);

    /**
     * @return the listaActual
     */
    List<File> getListaActual();

    /**
     * @return the listaAleatoria
     */
    List<File> getListaAleatoria();

    /**
     * @return the listaStreaming
     */
    List<String> getListaStreaming();

    void recorreLista();

    void removeStreaming(String o);

    /**
     * @param listaActual the listaActual to set
     */
    void setListaActual(List<File> listaActual);

    /**
     * @param listaAleatoria the listaAleatoria to set
     */
    void setListaAleatoria(List<File> listaAleatoria);

    /**
     * @param listaStreaming the listaStreaming to set
     */
    void setListaStreaming(List<String> listaStreaming);



}
