/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Opciones.java
 *
 * Created on 28-jun-2010, 18:22:14
 */
package Interfaz;

import Cliente.Cliente;
import Servidor.Servidor;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import Ficheros.ficheros;
import Servidor.IServidor;
import Streaming.CreaListaStreaming;
import javax.swing.ButtonGroup;

/**
 *
 * @author Joaquín
 */
public class Opciones extends javax.swing.JFrame {

    //Variable para editar fichero
    ficheros f = new ficheros();
    //Variable para crear la lista de streaming
    CreaListaStreaming cs = null;
    //Variables para pedir la IP
    Cliente cCliente = null;
    //Variable del servidor general
    Servidor server = null;
    //Variable para solicitar archivo de streaming
    solicitaStreaming solicita = null;

    /** Creates new form Opciones */
    public Opciones() {
        cs = new CreaListaStreaming();
        cCliente = new Cliente();
        server = new Servidor();
        solicita = new solicitaStreaming();

        initComponents();
        ButtonGroup grupoBoton = new ButtonGroup();
        grupoBoton.add(this.noBoton);
        grupoBoton.add(this.botonConfigurar);
        grupoBoton.add(this.siConfigurado);

        ButtonGroup grupoIP = new ButtonGroup();
        grupoIP.add(this.radioManual);
        grupoIP.add(this.radioAuto);

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Opciones de configuracion");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        noBoton = new javax.swing.JRadioButton();
        siConfigurado = new javax.swing.JRadioButton();
        botonConfigurar = new javax.swing.JRadioButton();
        directorioStreaming = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        elegirDirectorio = new javax.swing.JButton();
        aceptarDirectorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        obtenerIPRemota = new javax.swing.JButton();
        ipRemota = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        solicitarArchivo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        radioManual = new javax.swing.JRadioButton();
        radioAuto = new javax.swing.JRadioButton();
        arrancarServer = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("¿Tienes el servidor de Apache instalado?");

        noBoton.setText("No, no voy a hacer Streaming");

        siConfigurado.setText("Sí, y ya lo tengo configurado");

        botonConfigurar.setText("Sí, y deseo configurarlo ahora");

        directorioStreaming.setEditable(false);

        jLabel2.setText("Elija el directorio a compartir");

        elegirDirectorio.setText("Elegir directorio");
        elegirDirectorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elegirDirectorioMouseClicked(evt);
            }
        });

        aceptarDirectorio.setText("Aceptar directorio");
        aceptarDirectorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarDirectorioMouseClicked(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jTextArea1.setText("* Al aceptar un directorio deberás \nbuscar el archivo de configuración\nde Apache y aceptarlo.");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("Otras opciones de configuracion");

        obtenerIPRemota.setText("Obtener IP");
        obtenerIPRemota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                obtenerIPRemotaMouseClicked(evt);
            }
        });

        ipRemota.setEditable(false);

        jLabel4.setText("Obtener IP del servidor");

        jLabel5.setText("Solicitar archivo streaming");

        solicitarArchivo.setText("Solicitar archivo");
        solicitarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarArchivoActionPerformed(evt);
            }
        });

        jButton1.setText("Continuar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        radioManual.setText("IP Manual");
        radioManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioManualActionPerformed(evt);
            }
        });

        radioAuto.setText("IP Automatica");
        radioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAutoActionPerformed(evt);
            }
        });

        arrancarServer.setText("Arrancar SERVIDOR");
        arrancarServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrancarServerActionPerformed(evt);
            }
        });

        jLabel6.setText("Arranca el servidor general");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jButton1)
                .addContainerGap(377, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(directorioStreaming, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(elegirDirectorio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aceptarDirectorio))
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(siConfigurado)
                            .addComponent(noBoton)
                            .addComponent(botonConfigurar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(obtenerIPRemota)
                    .addComponent(ipRemota, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioManual)
                    .addComponent(radioAuto)
                    .addComponent(jLabel5)
                    .addComponent(solicitarArchivo)
                    .addComponent(arrancarServer)
                    .addComponent(jLabel6))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(noBoton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioManual)
                    .addComponent(siConfigurado))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioAuto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ipRemota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(botonConfigurar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(obtenerIPRemota))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(directorioStreaming, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elegirDirectorio)
                    .addComponent(aceptarDirectorio)
                    .addComponent(solicitarArchivo))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arrancarServer)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void elegirDirectorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elegirDirectorioMouseClicked

        if (this.botonConfigurar.isSelected()) {
            //Creamos el JFileChooser, la ventana de elección de archivos.
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int seleccion = fileChooser.showOpenDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {

                this.directorioStreaming.setText(fileChooser.getSelectedFile().toString());

            }
        } else {
            System.out.println("Debe seleccionar la opcion antes.");
        }
    }//GEN-LAST:event_elegirDirectorioMouseClicked

    private void aceptarDirectorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarDirectorioMouseClicked

        String archivo;
        String directorio;

        if (this.directorioStreaming.getText().equals("")) {
            System.out.println("Debe elegir un directorio para continuar.");
        } else if (!this.botonConfigurar.isSelected()) {
            System.out.println("Debe seleccionar la opcion.");
        } else {
            //Creamos el JFileChooser, la ventana de elección de archivos.
            JFileChooser fileChooser = new JFileChooser();

            //Filtro de los archivos a abrir.
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("CONF", "conf");
            fileChooser.setFileFilter(filtro);

            int seleccion = fileChooser.showOpenDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {

                archivo = fileChooser.getSelectedFile().getAbsolutePath();

                directorio = "<Directory " + this.directorioStreaming.getText() + ">\n"
                        + "Options Indexes FollowSymLinks"
                        + "AllowOverride None"
                        + "Order allow,deny"
                        + "Allow from all"
                        + "</Directory>";

                f.editarFichero(directorio, archivo);
                f.crearFichero(this.directorioStreaming.getText(), "carpetaPublica");
            }

            cs.creaFichero(this.directorioStreaming.getText());

        }
    }//GEN-LAST:event_aceptarDirectorioMouseClicked

    private void obtenerIPRemotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_obtenerIPRemotaMouseClicked
        String aux;

        /*
        cCliente.conexion("dameIP", "192.168.1.36");
        aux = f.leeFichero("config");
        this.ipRemota.setText(aux);
         *
         */


        if (this.radioManual.isSelected()) {
            if (this.ipRemota.getText().equals("")) {
                System.out.println("Debe escribir la IP del servidor");
            } else {
                cCliente.conexion("dameIP", this.ipRemota.getText());
                aux = f.leeFichero("config");
                this.ipRemota.setEditable(false);
                this.ipRemota.setText("");
                this.ipRemota.setText(aux);
            }
        } else if (this.radioAuto.isSelected()) {
            /*
             * En esta funcion, el programa llamaría al servidor intermedio, el cual
             * llamaría a su vez al servidor para que le proporcionase su IP y que
             * este cliente la pueda almacenar.
             */
            this.ipRemota.setText("Aun no implementado");
        } else {
            System.out.println("Debe elegir alguna opcion");
        }

    }//GEN-LAST:event_obtenerIPRemotaMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void radioManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioManualActionPerformed
        if (this.radioManual.isSelected()) {
            this.ipRemota.setText("");
            this.ipRemota.setEditable(true);
        }
    }//GEN-LAST:event_radioManualActionPerformed

    private void radioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAutoActionPerformed
        if (this.radioAuto.isSelected()) {
            this.ipRemota.setEditable(false);
        }
    }//GEN-LAST:event_radioAutoActionPerformed

    private void arrancarServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrancarServerActionPerformed
        this.server.start();
    }//GEN-LAST:event_arrancarServerActionPerformed

    private void solicitarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarArchivoActionPerformed
        this.solicita.setVisible(true);
    }//GEN-LAST:event_solicitarArchivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Opciones().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarDirectorio;
    private javax.swing.JButton arrancarServer;
    private javax.swing.JRadioButton botonConfigurar;
    private javax.swing.JTextField directorioStreaming;
    private javax.swing.JButton elegirDirectorio;
    private javax.swing.JTextField ipRemota;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton noBoton;
    private javax.swing.JButton obtenerIPRemota;
    private javax.swing.JRadioButton radioAuto;
    private javax.swing.JRadioButton radioManual;
    private javax.swing.JRadioButton siConfigurado;
    private javax.swing.JButton solicitarArchivo;
    // End of variables declaration//GEN-END:variables
}
