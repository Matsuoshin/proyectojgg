/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Reproductor;

import java.io.File;
import java.util.List;

/**
 *
 * @author joaquin
 */
public class Lista implements ILista {

    private List<File> cancion;

    public Lista (){
        //No hago nada
    }

    @Override
    public void addCancion(File song){
        cancion.add(song);
    }

    @Override
    public void removeCancion(File song){
        if(cancion.contains(song)){
            cancion.remove(song);
        }else{
            System.out.println("La cancion no está en la lista.");
        }
    }
}
