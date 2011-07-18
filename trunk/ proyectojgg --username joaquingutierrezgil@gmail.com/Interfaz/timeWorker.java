/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;

import Reproductor.MedioStrategy;
import javax.swing.SwingWorker;

/**
 *
 * @author Joaquín
 */
public class timeWorker extends SwingWorker<Double, Integer> {

    private MedioStrategy medio;
    private xPrincipal tiempo;

    public timeWorker(MedioStrategy medio, xPrincipal tiempo) {
        this.tiempo = tiempo;
        this.medio = medio;
    }

    @Override
    protected Double doInBackground() throws Exception {

        return 100.0;
    }

}
