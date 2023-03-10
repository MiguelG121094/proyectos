/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import conexion.conexion;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class articulo extends javax.swing.JFrame {
    
    conexion con = new conexion();
    
    public Statement statement;
    public ResultSet resulSet;
    
    int ban = 0;
    
    public void limpiar(){
        codigo.setText("");
        descri.setText("");
        precio.setText("");
        jTable1.clearSelection();
    }

    public void deshabilitar(){
        codigo.setEnabled(false);
        descri.setEnabled(false);
        precio.setEnabled(false);
        cancelar.setEnabled(false);
        guardar.setEnabled(false);
        modificar.setEnabled(true);
        borrar.setEnabled(true);
    }
    
    public void habilitar(){        
        codigo.setEnabled(true);
        descri.setEnabled(true);
        precio.setEnabled(true);
        cancelar.setEnabled(true);
        borrar.setEnabled(false);
        guardar.setEnabled(true);

    }
    
    private void cargarGrilla(){
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            String vecContenido[] = new String[3];
        try {
            statement = con.conexion.createStatement();
            resulSet = statement.executeQuery("select * from articulo order by codigo");
            while(resulSet.next()){
                vecContenido[0] = resulSet.getString("codigo");
                vecContenido[1] = resulSet.getString("descripcion");
                vecContenido[2] = resulSet.getString("precio");
                modelo.addRow(vecContenido);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(articulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public articulo() {
        initComponents();
        con.conectar();
        cargarGrilla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descri = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        agregar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Art??culos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel2.setText("C??digo:");

        codigo.setEnabled(false);
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoKeyPressed(evt);
            }
        });

        jLabel3.setText("Descripci??n:");

        descri.setEnabled(false);
        descri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriActionPerformed(evt);
            }
        });

        jLabel4.setText("Precio:");

        precio.setEnabled(false);
        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "C??digo", "Descripci??n", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.setEnabled(false);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(modificar)
                        .addGap(37, 37, 37)
                        .addComponent(cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(descri))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(guardar)
                        .addGap(40, 40, 40)
                        .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(descri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(modificar)
                    .addComponent(cancelar)
                    .addComponent(guardar)
                    .addComponent(borrar)
                    .addComponent(salir))
                .addGap(58, 58, 58))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
           
    }//GEN-LAST:event_codigoActionPerformed

    private void descriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        codigo.setEnabled(true);
        codigo.requestFocus();
        jTable1.setEnabled(false);
        modificar.setEnabled(false);
        borrar.setEnabled(false);
        agregar.setEnabled(false);
        habilitar();
        limpiar();
        ban =1;
    }//GEN-LAST:event_agregarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar();
        deshabilitar();
        jTable1.setEnabled(true);
        agregar.setEnabled(true);
    }//GEN-LAST:event_cancelarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = this.jTable1.getSelectedRow(); 
        codigo.setText(String.valueOf(jTable1.getValueAt(fila,0)));
        descri.setText(String.valueOf(jTable1.getValueAt(fila,1)));
        precio.setText(String.valueOf(jTable1.getValueAt(fila,2)));
    }//GEN-LAST:event_jTable1MouseClicked

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if(codigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un item de la grilla");
        }else{
            codigo.requestFocus();
            agregar.setEnabled(false);
            habilitar();
            borrar.setEnabled(false);
            ban = 2;
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyPressed
        
    }//GEN-LAST:event_codigoKeyPressed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        if(codigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un item de la grilla");
        }else{
            int resp = JOptionPane.showConfirmDialog(null, "Borrar registro",
            "Mantenimiento de Articulo", JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE, null);
            if (resp == 0) {
                ban = 3;
                guardar.setEnabled(true);
                guardar.doClick();
            }else{
                limpiar();
                jTable1.setEnabled(true);
            }
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        try {
             String comandosql;
             comandosql="";
             if (codigo.getText().isEmpty()) {
                          JOptionPane.showMessageDialog(this, "El campo C??digo no puede estar vac??o");
            }else{
              if (ban == 1) { 
                 comandosql = " insert into articulo(codigo, descripcion, precio) values('"+codigo.getText()+
                        "','"+descri.getText()+"',"+precio.getText()+")";
                      JOptionPane.showMessageDialog(null, "Art??culo Insertado Exitosamente ");
             }
             //}
              if (ban == 2) { 
                 comandosql = " update articulo set descripcion = '"+descri.getText()+"',"
                     + "precio = "+precio.getText()+" where codigo = '"+codigo.getText()+"'";
                         JOptionPane.showMessageDialog(null, "Art??culo Modificado Exitosamente ");
             }
              if (ban == 3) { 
                 comandosql = " delete from articulo where codigo = '"+codigo.getText()+"'";
                  JOptionPane.showMessageDialog(null, "Art??culo Eliminado Exitosamente ");
             }
        }
             statement = con.conexion.createStatement();
             statement.executeUpdate(comandosql);
             
                 cargarGrilla();
                 deshabilitar();
                 limpiar();
                 jTable1.setEnabled(true);
                 agregar.setEnabled(true);
             
         } catch (SQLException ex) {
             Logger.getLogger(articulo.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_guardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(articulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(articulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(articulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(articulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new articulo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton borrar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField descri;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField precio;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
