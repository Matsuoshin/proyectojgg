/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reproductor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.gstreamer.Gst;
import org.gstreamer.elements.PlayBin;
import org.gstreamer.swing.VideoComponent;

/**
 *
 * @author Joaquín
 */
public class Video extends CentroMultimedia {

    //Variables para reproducir el archivo.
    private String path;
    private PlayBin playbin;

    //Variable que controla que la ventana pantalla se pueda cerrar.
    private boolean cerrar = false;
    
    //Listener que vigila el estado de la ventana.
    private escuchaVentana listen;


    public Video() {
        listen = new escuchaVentana(this);
    }

    @Override
    public void runEngine(File file) {
        try {
            //Obtengo la ruta absoluta del archivo a reproducir
            path = file.getAbsolutePath();

            Gst.init();
            playbin = new PlayBin("VideoPlayer");
            //super.setPlaybin(playbin);
            playbin.setInputFile(new File(path));

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    VideoComponent videoComponent = new VideoComponent();
                    playbin.setVideoSink(videoComponent.getElement());

                    JFrame frame = new JFrame("VideoPlayer");


                    frame.addWindowListener(listen);

                    frame.getContentPane().add(videoComponent, BorderLayout.CENTER);
                    frame.setPreferredSize(new Dimension(640, 480));
                    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                    playbin.play();

                    //Esta ventana se puede cerrar
                    cerrar = true;
                }
            });

        } catch (Exception e) {
            System.out.println("Error al reproducir el video: "
                    + e.getMessage());
        }
    }

    @Override
    public void runURL(String file) {
        try {
            //Obtengo la ruta absoluta del archivo a reproducir
            //path = file.getAbsolutePath();

            URI u = new URI(file);

            Gst.init();
            playbin = new PlayBin("VideoPlayer");
            //super.setPlaybin(playbin);
            //playbin.setInputFile(new File(path));
            playbin.setURI(u);
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    VideoComponent videoComponent = new VideoComponent();
                    playbin.setVideoSink(videoComponent.getElement());

                    JFrame frame = new JFrame("VideoPlayer");


                    frame.addWindowListener(listen);

                    frame.getContentPane().add(videoComponent, BorderLayout.CENTER);
                    frame.setPreferredSize(new Dimension(640, 480));
                    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                    playbin.play();

                    //Esta ventana se puede cerrar
                    cerrar = true;
                }
            });

        } catch (Exception e) {
            System.out.println("Error al reproducir el video: "
                    + e.getMessage());
        }
    }

    @Override
    public void stop(){
        playbin.stop();
    }

    /**
     * @return the cerrar
     */
    public boolean isCerrar() {
        return cerrar;
    }

    @Override
    public void destroyPipeline() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

class escuchaVentana implements WindowListener {

    private Video video;

    public escuchaVentana(Video video){
        this.video = video;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //Nada
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(video.isCerrar()){
            video.stop();
            Gst.quit();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //Nada
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //Nada
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //Nada
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //Nada
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //Nada
    }
    
}