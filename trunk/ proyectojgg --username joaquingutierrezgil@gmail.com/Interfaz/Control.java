/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;

import Reproductor.CentroMultimedia;
import java.io.File;
import org.gstreamer.Bus;
import org.gstreamer.GstObject;
import org.gstreamer.elements.PlayBin;

/**
 *
 * @author Joaquín
 */
public class Control extends CentroMultimedia implements Runnable {

    private PlayBin playbin = null;

    public Control(){
        super();
        playbin = super.getPlaybin();
    }

    @Override
    public void run(){
        playbin.getBus().connect(new Bus.EOS() {

            @Override
            public void endOfStream(GstObject source) {
                System.out.println("Fin de la reproduccion del archivo.");
                System.out.println("EL HILO HA DETECTADO EL FIN.");
            }
        });
    }

    @Override
    public void runEngine(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void runURL(String file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void destroyPipeline() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
