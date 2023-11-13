/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax_2.vistas;

import provemax_2.accesoDatos.ProductoData;
import provemax_2.entidades.Producto;

/**
 *
 * @author Usuario
 */
public class Productos extends javax.swing.JInternalFrame {


    private ProductoData producData= new ProductoData();
    private Producto productoActual= null; 
    
    
    
    
    public Productos() {
        initComponents();
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
        jbSalir = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jlRegistroProductos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtCodigoProducto = new javax.swing.JTextField();
        jtNombreProducto = new javax.swing.JTextField();
        jtDescripcionProducto = new javax.swing.JTextField();
        jtPrecioProducto = new javax.swing.JTextField();
        jbEliminar = new javax.swing.JButton();
        jcEstado = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jtStock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtStockMinimo = new javax.swing.JTextField();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbSalir.setText("Salir");
        jPanel1.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        jbModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        jbModificar.setText("Modificar");
        jPanel1.add(jbModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        jbNuevo.setText("Nuevo");
        jPanel1.add(jbNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        jbAgregar.setText("Agregar");
        jPanel1.add(jbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lupa-30.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        jlRegistroProductos.setText("REGISTRO DE PRODUCTOS");
        jPanel1.add(jlRegistroProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel1.setText("Codigo Producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel2.setText("Nombre Producto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setText("Descripcion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel4.setText("Precio Actual ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jtCodigoProducto.setText("jTextField1");
        jPanel1.add(jtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 240, -1));

        jtNombreProducto.setText("jTextField1");
        jPanel1.add(jtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 80, 250, -1));

        jtDescripcionProducto.setText("jTextField1");
        jPanel1.add(jtDescripcionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 120, 250, -1));

        jtPrecioProducto.setText("jTextField1");
        jPanel1.add(jtPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 160, 270, -1));

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eliminar-50.png"))); // NOI18N
        jbEliminar.setText("Elimininar");
        jPanel1.add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 130, 40));

        jcEstado.setText("Estado");
        jPanel1.add(jcEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel7.setText("Stock");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jtStock.setText("jTextField1");
        jPanel1.add(jtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 170, -1));

        jLabel6.setText("Stock Minimo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jtStockMinimo.setText("jTextField1");
        jPanel1.add(jtStockMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
      
        
        String nombreProducto=jtNombreProducto.getText();
        productoActual=producData.buscarProductosPorNombre(nombreProducto);
        if(productoActual!=null){
            
            int Codigo =Integer.parseInt(jtCodigoProducto.getText());
             jtNombreProducto.setText(productoActual.getDescripcion());
            jtDescripcionProducto.setText(productoActual.getDescripcion());
            
            int Precio=Integer.parseInt(jtPrecioProducto.getText());
            int Stock= Integer.parseInt(jtStock.getText());
            jcEstado.setSelected(productoActual.isEstado());
            
          
         
        }
      
    }//GEN-LAST:event_jbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcEstado;
    private javax.swing.JLabel jlRegistroProductos;
    private javax.swing.JTextField jtCodigoProducto;
    private javax.swing.JTextField jtDescripcionProducto;
    private javax.swing.JTextField jtNombreProducto;
    private javax.swing.JTextField jtPrecioProducto;
    private javax.swing.JTextField jtStock;
    private javax.swing.JTextField jtStockMinimo;
    // End of variables declaration//GEN-END:variables
}
