/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax_2.vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import provemax_2.accesoDatos.ProductoData;
import provemax_2.entidades.Producto;

/**
 *
 * @author Usuario
 */
public class ListadoProductos extends javax.swing.JInternalFrame {
    private ProductoData proData;
    private DefaultTableModel modelo;
    
    
    public ListadoProductos() {
        initComponents();
        this.setTitle("Listado de Productos ");
        proData = new ProductoData();
        modelo = new DefaultTableModel();
        
        armarCabecera();
    }
    
    private void armarCabecera() { // armo la cabecera de mi tabla
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("id");
        filaCabecera.add("nombreProducto");
        filaCabecera.add("descripcion");
        filaCabecera.add("PrecioActual");
        filaCabecera.add("stock");
        filaCabecera.add("stockMinimo");
        
        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jtLista.setModel(modelo);
    }
    
     private void limpiarTabla() {
        // Limpiar todas las filas de la tabla
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
        
      private void actualizarTabla(boolean esActivo) {
        // Limpiar la tabla antes de actualizarla
        limpiarTabla();

        // Obtener la lista de proveedores según el estado seleccionado
        ArrayList<Producto> listaProductos = esActivo ? proData.listarProductos() : proData.listarProductosDeBaja();

        // Agregar filas a la tabla
        for (Producto producto : listaProductos) {
            modelo.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombreProducto(),
                producto.getDescripcion(),
                producto.getPrecioActual(),
                producto.getStock(),
                producto.getStockMinimo(),
                
                
            });
        }
    } 

    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jrProductosNoActivos = new javax.swing.JRadioButton();
        jrProductosActivos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLista = new javax.swing.JTable();
        jbActualizar = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(219, 247, 194));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 24)); // NOI18N
        jLabel1.setText("LISTADO DE PRODUCTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jrProductosNoActivos.setText("PRODUCTOS NO ACTIVOS");
        jrProductosNoActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrProductosNoActivosActionPerformed(evt);
            }
        });
        jPanel1.add(jrProductosNoActivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jrProductosActivos.setText("PRODUCTOS ACTIVOS");
        jrProductosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrProductosActivosActionPerformed(evt);
            }
        });
        jPanel1.add(jrProductosActivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jtLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtLista);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, 170));

        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jbActualizar.setText("ACTUALIZAR");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jbActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        jbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cerrar-ventana-20.png"))); // NOI18N
        jbExit.setText("EXIT");
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });
        jPanel1.add(jbExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrProductosActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrProductosActivosActionPerformed
         actualizarTabla(true);
    }//GEN-LAST:event_jrProductosActivosActionPerformed

    private void jrProductosNoActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrProductosNoActivosActionPerformed
         actualizarTabla(false);
    }//GEN-LAST:event_jrProductosNoActivosActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
         if (jrProductosActivos.isSelected()) {
            // Actualizar tabla con proveedores activos
            actualizarTabla(true);
        } else if (jrProductosNoActivos.isSelected()) {
            // Actualizar tabla con proveedores inactivos
            actualizarTabla(false);
        }
        
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
         dispose();
    }//GEN-LAST:event_jbExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbExit;
    private javax.swing.JRadioButton jrProductosActivos;
    private javax.swing.JRadioButton jrProductosNoActivos;
    private javax.swing.JTable jtLista;
    // End of variables declaration//GEN-END:variables
}
