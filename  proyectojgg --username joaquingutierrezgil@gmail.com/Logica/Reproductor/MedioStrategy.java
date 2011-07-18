/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Reproductor;

import java.io.File;
import org.gstreamer.State;

/**
 *
 * @author joaquin
 */
public interface MedioStrategy {

    public boolean isPlaying();
    public abstract void runEngine(File file);
    public void setVolume(double perCent);
    public void play();
    public void resume();
    public void pause();
    public void stop();
    public long getTime();
    public void setTime(long time);
    public long tiempoCancion();
    public int minutosTotales();
    public int segundosTotales();
    public long posicionActual();
    public void establecerPosicion(long tiempo);
    public abstract void destroyPipeline();
    public void runURL(String file);
    public void avanzaPosicion();
    public void retrocedePosicion();
    public State obtenerEstado();
    public void establecerEstado();
}
