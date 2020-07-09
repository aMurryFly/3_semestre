/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.io.File;
import javax.swing.*;
/**
 *
 * @author pon_c
 */
public class ventana extends javax.swing.JFrame {
    
    JFileChooser seleccion = new JFileChooser();
    File archivo;
    metodos_archivos case1 = new metodos_archivos();
    public ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_editar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_datos = new javax.swing.JTextArea();
        btn_guardararchivo = new javax.swing.JButton();
        btn_createFile = new javax.swing.JButton();
        btn_deleteFile = new javax.swing.JButton();
        btn_overwrite = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Murrieta_Valdespino");

        btn_editar.setText("EDITAR");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        txt_datos.setColumns(20);
        txt_datos.setRows(5);
        jScrollPane1.setViewportView(txt_datos);

        btn_guardararchivo.setText("GUARDAR ARCHIVO");
        btn_guardararchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardararchivoActionPerformed(evt);
            }
        });

        btn_createFile.setText("CREAR ARCHIVO");
        btn_createFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createFileActionPerformed(evt);
            }
        });

        btn_deleteFile.setText("BORRAR ARCHIVO");
        btn_deleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteFileActionPerformed(evt);
            }
        });

        btn_overwrite.setText("SOBRE-ESCRIBIR");
        btn_overwrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_overwriteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_guardararchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_createFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_deleteFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_overwrite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_createFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_deleteFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_overwrite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardararchivo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        if(seleccion.showDialog(null, "Editar")==JFileChooser.APPROVE_OPTION){
            archivo = seleccion.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt") ){
                    String contenido = case1.openFile(archivo);
                    //System.out.println("si lo haces");
                    txt_datos.setText(contenido);
                }else{
                    JOptionPane.showMessageDialog(null, "Selecciona un archivo txt");
                }
            }
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_guardararchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardararchivoActionPerformed
        if(seleccion.showDialog(null, "Guardar Archivo")==JFileChooser.APPROVE_OPTION){
            archivo = seleccion.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String cont = txt_datos.getText();
                String ans = case1.saveFile(archivo, cont);
                if(ans!=null){
                    JOptionPane.showMessageDialog(null, ans); 
                }
                else{    
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }   
            }
            else{
                JOptionPane.showMessageDialog(null, "El contenido debe guardarse en un txt");
            }
        }    
    }//GEN-LAST:event_btn_guardararchivoActionPerformed

    private void btn_deleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteFileActionPerformed
        if(seleccion.showDialog(null, "Borrar archivo")==JFileChooser.APPROVE_OPTION){
            archivo = seleccion.getSelectedFile();
            archivo.delete();
            JOptionPane.showMessageDialog(rootPane, "El archivo ha sido eliminado con éxito!");
            
        }    
    }//GEN-LAST:event_btn_deleteFileActionPerformed

    private void btn_createFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createFileActionPerformed
        if(seleccion.showDialog(null, "Crear Archivo")==JFileChooser.APPROVE_OPTION){
            archivo = seleccion.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String ans = case1.createFile(archivo);
                if(ans!=null){
                    JOptionPane.showMessageDialog(null, ans); 
                }
                else{    
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }   
            }
            else{
                JOptionPane.showMessageDialog(null, "El contenido debe guardarse en un txt");
            }
        } 
    }//GEN-LAST:event_btn_createFileActionPerformed

    private void btn_overwriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_overwriteActionPerformed
        if(seleccion.showDialog(null, "Sobre escribir")== JFileChooser.APPROVE_OPTION){
            archivo = seleccion.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt") ){
                    
                    String clear = "";
                    String contenido = case1.saveFile(archivo, clear);
                    contenido = case1.openFile(archivo);
                    txt_datos.setText(contenido);
                }else{
                    JOptionPane.showMessageDialog(null, "Selecciona un archivo txt");
                }
            }
        }
    }//GEN-LAST:event_btn_overwriteActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_createFile;
    private javax.swing.JButton btn_deleteFile;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardararchivo;
    private javax.swing.JButton btn_overwrite;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_datos;
    // End of variables declaration//GEN-END:variables
}
