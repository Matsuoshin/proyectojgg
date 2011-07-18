/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica.Reproductor;

import Interfaz.IPrincipal;
import Interfaz.xPrincipal;
import Reproductor.CentroMultimedia;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URI;
import org.gstreamer.Bus;
import org.gstreamer.ElementFactory;
import org.gstreamer.Gst;
import org.gstreamer.GstObject;
import org.gstreamer.State;
import org.gstreamer.elements.PlayBin;

/**
 *
 * @author joaquin
 */
public class Audio extends CentroMultimedia {

    //Referencia a la entrada por consola (System.in)
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PlayBin playbin = null;
    private String path;
    private boolean finCancion = true;
    private Interfaz.Principal tiempo;
    private IPrincipal var;


    public Audio(){
        //No hago nada
    }

    //Reproduce audio de forma local
    @Override
    public void runEngine(File file) {
        try {
            //Obtengo la ruta absoluta del archivo a reproducir
            path = file.getAbsolutePath();
            
            //Arrancamos la librería GSTREAMER para rpeorducir el medio.
            Gst.init();
            playbin = new PlayBin("AudioPlayer");
            super.setPlaybin(playbin);
            playbin.setInputFile(new File(path));
            playbin.setState(State.PAUSED);
            while(playbin.getState()!=State.PAUSED){
                System.out.println("El medio aun no está listo.");
            }
            playbin.setVideoSink(ElementFactory.make("fakesink", "videosink"));
            //playbin.setState(State.PLAYING);
        } catch (Throwable e) {
            System.out.println("GStreamer no soportado: " + e.getLocalizedMessage());
        }

        playbin.getBus().connect(new Bus.EOS() {

            @Override
            public void endOfStream(GstObject source) {
                System.out.println("Fin de la reproduccion del archivo.");
                /*
                 * Cuando capturamos el evento de final de reproducción,
                 * cerramos gstreamer.
                 * 
                 */
                playbin.setState(State.NULL);
                Gst.quit();
                if ( var.isRepiteUna() == true) {
                    var.reproducirMedio(var.getUltimaCancion());
                } else if (var.isRepiteUna() == false) {
                    System.out.println("Ha fallado.");
                }
            }
        });

        playbin.getBus().connect(new Bus.ERROR() {

            @Override
            public void errorMessage(GstObject source, int code, String message) {
                System.out.println("Error occurred: " + message);
                Gst.quit();
            }
        });

        playbin.getBus().connect(new Bus.STATE_CHANGED() {

            @Override
            public void stateChanged(GstObject source, State old, State current, State pending) {
                if (source == playbin) {
                    System.out.println("Pipeline state changed from " + old + " to " + current);
                }
            }
        });

    }

    //Reproduce audio de forma remota.
    @Override
    public void runURL(String file) {
        try {
            //Obtengo la ruta absoluta del archivo a reproducir

            URI u = new URI(file);

            //Arrancamos la librería GSTREAMER para rpeorducir el medio.
            Gst.init();
            playbin = new PlayBin("AudioPlayer");
            playbin.setURI(u);
            playbin.setVideoSink(ElementFactory.make("fakesink", "videosink"));
            playbin.setState(State.PLAYING);
        } catch (Throwable e) {
            System.out.println("GStreamer no soportado: " + e.getLocalizedMessage());
        }

        playbin.getBus().connect(new Bus.EOS() {

            @Override
            public void endOfStream(GstObject source) {
                System.out.println("Fin de la reproduccion del archivo.");
                /*
                 * Cuando capturamos el evento de final de reproducción,
                 * cerramos gstreamer.
                 *
                 */
                Gst.quit();
            }
        });

        playbin.getBus().connect(new Bus.ERROR() {

            @Override
            public void errorMessage(GstObject source, int code, String message) {
                System.out.println("Error occurred: " + message);
                Gst.quit();
            }
        });

        playbin.getBus().connect(new Bus.STATE_CHANGED() {

            @Override
            public void stateChanged(GstObject source, State old, State current, State pending) {
                if (source == playbin) {
                    System.out.println("Pipeline state changed from " + old + " to " + current);
                }
            }
        });

    }

    @Override
    public void destroyPipeline(){
        playbin.stop();
        Gst.quit();
    }

}
