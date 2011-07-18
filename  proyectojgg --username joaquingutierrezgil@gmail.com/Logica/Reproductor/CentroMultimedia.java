/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Reproductor;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.gstreamer.State;
import org.gstreamer.elements.PlayBin;

/**
 *
 * @author joaquin
 */
public abstract class CentroMultimedia implements MedioStrategy{

    private PlayBin playbin = null;
    private long time;
    private boolean finMedio = true;
    private long total;

    //Comprobar si se está reproduciendo algo
    /*
     * Este es uno de los métodos más importantes del reproductor. Su cometido
     * es decirnos si en el momento en que lo ejecutamos se está reproduciendo algo.
     *
     * Con esto controlamos el estado de la tubería ya que, al conocer su estado,
     * podemos detener su ejecución o destruir dicho pipeline para realizar una nueva
     * reproducción.
     *
     * El metodo isPlaying devuelve un valor de tipo boolean:
     *
     *  - valor = false -> NO se está reproduciendo nada.
     *  - valor = true -> SI es está reproduciendo un medio.
     *
     * Primero hay que comprobar si la variable playbin existe, ya que en la
     * interfaz necesitamos mirar si existe o no, por eso la inicializamos a null
     * y comprobamos si existe.
     *
     * Si realizamos la comprobación de isPlaying sin inicializar la variable, JAVA
     * devuelve un NullPointerException ya que no hemos creado ningún playbin para
     * alguna canción, por lo que no existe.
     */
    @Override
    public boolean isPlaying() {
        boolean valor;
        if (getPlaybin() == null) {
            valor = false;
        } else {
            valor = getPlaybin().isPlaying();
        }
        return valor;
    }

    @Override
    public State obtenerEstado(){
        return getPlaybin().getState();
    }

    @Override
    public void establecerEstado(){
        getPlaybin().setState(State.NULL);
    }

    @Override
    public abstract void runEngine(File file);

    @Override
    public abstract void runURL(String file);

    @Override
    public void setVolume(double perCent) {
        getPlaybin().setVolume(perCent);
    }

    //Iniciar la reproduccion
    @Override
    public void play() {
        getPlaybin().play();
    }

    //Re-iniciar la reproducción donde se había pausado.
    @Override
    public void resume() {
        getPlaybin().seek(time, TimeUnit.MILLISECONDS);
        getPlaybin().play();
    }

    //Pausar la reproduccion
    @Override
    public void pause() {
        this.setTime(getPlaybin().queryPosition().toMillis());
        getPlaybin().pause();
    }

    //Detener la reproduccion
    @Override
    public void stop() {
        getPlaybin().stop();
    }

    /**
     * @return the time
     */
    @Override
    public long getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    @Override
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * @param playbin the playbin to set
     */
    public void setPlaybin(PlayBin playbin) {
        this.playbin = playbin;
    }

    @Override
    public abstract void destroyPipeline();

    @Override
    public long tiempoCancion(){
        total = getPlaybin().getBaseTime().getMinutes();
        return total;
    }

    @Override
    public int minutosTotales(){
        long minTotales = getPlaybin().queryDuration().toSeconds()/60;
        return (int) minTotales;
    }

    @Override
    public int segundosTotales(){
        long segTotales = getPlaybin().queryDuration().toSeconds();
        return (int) segTotales;
    }

    @Override
    public long posicionActual() {
        long posicion = getPlaybin().queryPosition().toSeconds();
        return posicion;
    }

    @Override
    public void establecerPosicion(long tiempo){
        getPlaybin().seek(tiempo, TimeUnit.SECONDS);
    }

    @Override
    public void avanzaPosicion(){
        long posicion = this.getPlaybin().queryPosition().toSeconds();
        this.getPlaybin().seek(posicion+(long)1, TimeUnit.SECONDS);
    }

    @Override
    public void retrocedePosicion(){
        long posicion = this.getPlaybin().queryPosition().toSeconds();
        this.getPlaybin().seek(posicion-(long)1, TimeUnit.SECONDS);
    }

    /**
     * @return the finMedio
     */
    public boolean isFinMedio() {
        return finMedio;
    }

    /**
     * @param finMedio the finMedio to set
     */
    public void setFinMedio(boolean finMedio) {
        this.finMedio = finMedio;
    }

    /**
     * @return the playbin
     */
    public PlayBin getPlaybin() {
        return playbin;
    }
}
