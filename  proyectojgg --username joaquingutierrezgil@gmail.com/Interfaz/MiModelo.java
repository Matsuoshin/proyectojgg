/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joaquín
 */
public class MiModelo extends DefaultTableModel {

    /*
     * Con esta clase hemos creado un modelo propio para el JTable, ya que por defcto,
     * JTable no tiene un método para evitar que las celdas del mismo no se
     * puedan editar, por lo que redefiniendo el siguiente método, conseguimos
     * que en nuestro JTable no se puedan editar las celdas.
     */

    @Override
    public boolean isCellEditable(int row, int column) {
        // Aquí devolvemos true o false según queramos que una celda
        // identificada por fila,columna (row,column), sea o no editable
        return false;
    }
}
