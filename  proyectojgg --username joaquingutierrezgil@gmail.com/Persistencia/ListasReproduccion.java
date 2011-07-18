/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Interfaz.Principal;

/**
 *
 * @author Joaquín
 */
public class ListasReproduccion implements IListasReproduccion {

    public List<File> listaActual = null;
    public List<File> listaAleatoria = null;
    public List<String> listaStreaming = null;
    private Principal p;

    public ListasReproduccion() {
        listaActual = new ArrayList<File>();
        listaAleatoria = new ArrayList<File>();
        listaStreaming = new ArrayList<String>();
    }

    /**
     * @return the listaActual
     */
    @Override
    public List<File> getListaActual() {
        return listaActual;
    }

    /**
     * @param listaActual the listaActual to set
     */
    @Override
    public void setListaActual(List<File> listaActual) {
        this.listaActual = listaActual;
    }

    /**
     * @return the listaAleatoria
     */
    @Override
    public List<File> getListaAleatoria() {
        return listaAleatoria;
    }

    /**
     * @param listaAleatoria the listaAleatoria to set
     */
    @Override
    public void setListaAleatoria(List<File> listaAleatoria) {
        this.listaAleatoria = listaAleatoria;
    }

    /**
     * @return the listaStreaming
     */
    @Override
    public List<String> getListaStreaming() {
        return listaStreaming;
    }

    /**
     * @param listaStreaming the listaStreaming to set
     */
    @Override
    public void setListaStreaming(List<String> listaStreaming) {
        this.listaStreaming = listaStreaming;
    }

    @Override
    public void addStreaming(String o) {
        listaStreaming.add(o);      
        //p.rellenaStreaming(o);
    }

    @Override
    public void removeStreaming(String o) {
        if (listaStreaming.contains(o)) {
            listaStreaming.remove(o);
        }
    }

    @Override
    public void recorreLista() {
        for (String st : this.listaStreaming) {
            System.out.println(st);
        }
    }
}
