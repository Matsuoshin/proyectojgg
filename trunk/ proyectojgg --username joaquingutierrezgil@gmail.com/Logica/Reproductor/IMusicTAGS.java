/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Reproductor;

import java.io.File;

/**
 *
 * @author joaquin
 */
public interface IMusicTAGS {

    /**
     * @return the Album
     */
    String getAlbum();

    /**
     * @return the Artista
     */
    String getArtista();

    /**
     * @return the Titulo
     */
    String getTitulo();

    void obtenerTAGS(File f);

    /**
     * @param Album the Album to set
     */
    void setAlbum(String Album);

    /**
     * @param Artista the Artista to set
     */
    void setArtista(String Artista);

    /**
     * @param Titulo the Titulo to set
     */
    void setTitulo(String Titulo);

}
