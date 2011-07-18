/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Reproductor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gstreamer.Gst;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.gstreamer.Element;
import org.gstreamer.Pipeline;
import org.gstreamer.State;
import org.gstreamer.StreamInfo;

/**
 *
 * @author joaquin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ElegirTipo et = new ElegirTipo();
        List<StreamInfo> ll = new ArrayList();

        try {
            URI u = new URI("http://dl.dropbox.com/u/7459782/03-billy_talent-this_suffering.mp3");
            args = Gst.init("AudioPlayer", args);
            /*
            PlayBin playbin = new PlayBin("AudioPlayer");
            playbin.setURI(u);            
            playbin.setVideoSink(ElementFactory.make("fakesink", "videosink"));
            playbin.setState(State.PLAYING);
            Gst.main();
            playbin.setState(State.NULL);
             *
             */
            String def = "rtspsrc location=rtsp://192.168.1.132:6969 name=src ! fakesink";
            String loc = "C:\\Users\\Public\\Music\\raunchy.mp3";
            Pipeline pipe = Pipeline.launch(def);
            Element rtsp = pipe.getElementByName("src");
            rtsp.set("latency", 6000);
            rtsp.set("location", "/home/joaquin/papercut.mp3");
            pipe.play();
            pipe.setState(State.PLAYING);
            Gst.main();
            //pipe.play();
            //pipe.stop();

            args = Gst.init("client", args);
            //Element src = pipe.addMany("filesrc", "source");

        } catch (URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
