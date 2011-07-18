/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Reproductor.MedioStrategy;
import java.util.List;
import javax.swing.JSlider;
import javax.swing.SwingWorker;
import org.gstreamer.State;

/**
 *
 * @author Joaquín
 */
public class MiWorker extends SwingWorker<Double, Integer> {

    private xPrincipal ventana;
    private Double valor;
    private Double total;
    private JSlider slider;
    private MedioStrategy medio;
    private State ready = org.gstreamer.State.READY;
    private State pausa = org.gstreamer.State.PAUSED;
    private State vacio = org.gstreamer.State.NULL;

    public MiWorker(MedioStrategy medio, JSlider slider) {
        this.slider = slider;
        this.medio = medio;
    }

    @Override
    protected Double doInBackground() throws Exception {
        System.out.println("doInBackground() esta en el hilo "
                + Thread.currentThread().getName());

        slider.setMaximum(medio.segundosTotales());
        slider.setMinimum(0);

        // Se pasa valor para la barra de progreso. ESto llamara al metodo
        // process() en el hilo de despacho de eventos.

        while (medio.isPlaying() || medio.obtenerEstado()!=ready) {

            if (medio.isPlaying()) {
                int d = (int) medio.posicionActual();
                slider.setValue(d);
                publish(d);
            } else if (medio.obtenerEstado() == pausa) {
                //El reproductor está en pausa.
            } else if (medio.obtenerEstado() == vacio){
                break;
            }
        }

        this.done();

        // Supuesto resultado de la tarea que tarda mucho.
        return 100.0;
    }

    @Override
    protected void process(List<Integer> chunks) {
        //System.out.println("process() esta en el hilo "
        //        + Thread.currentThread().getName());
        slider.setValue(chunks.get(0));
    }

    /**
     * Tarea terminada, SwingWorker llama a este metodo en el hilo de despacho
     * de eventos. Aqui actualizamos la etiqueta para que ponga "Hecho".
     */
    @Override
    protected void done() {
        System.out.println("done() esta en el hilo "
                + Thread.currentThread().getName());
        //this.slider.setValue(valor);
        medio.stop();
        slider.setValue(0);
    }
}
