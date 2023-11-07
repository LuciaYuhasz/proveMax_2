/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax_2.accesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import provemax_2.entidades.Compra;
import provemax_2.entidades.Proveedor;

/**
 *
 * @author Usuario
 */
public class CompraData {
    
    private ProductoData prodData = new ProductoData();
    private ProveedorData provData= new ProveedorData();
    
    
     private Connection con = null;

    public CompraData() {
        con = Conexion.getConexion();
    }
    
    
    public void agregarCompra(Compra compra){ // funciona
        
         String sql= " INSERT INTO compra (idProveedor, fecha, estado) " 
               + " VALUES(?, ?, ?)";
        try {

            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,compra.getProveedor().getIdProveedor());
            ps.setDate(2, java.sql.Date.valueOf(compra.getFecha()));
            ps.setBoolean(3, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int idCompra;
            if (rs.next()) {
                idCompra= rs.getInt(1);
                compra.setIdCompra(idCompra);
                JOptionPane.showMessageDialog(null, "Compra  agregada exitosamente");
                 }
            ps.close();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Compra" + ex.getMessage());
        
        }
        
   }
       public Compra buscarCompra(int idCompra) { // funciona
        Compra compra = null;
        String sql = "SELECT * FROM compra WHERE idCompra = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                Proveedor prov = provData.buscarProveedorPorId(rs.getInt("idProveedor"));
                compra.setProveedor(prov);
                compra.setFecha(rs.getDate("fecha").toLocalDate());
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar compra: " + ex.getMessage());
        }
        return compra;
    }
    
       
       
    
      public ArrayList<Compra> listarComprasActivas(){ // funciona
         String sql = "SELECT idCompra, idProveedor,fecha, estado FROM compra WHERE estado = 1";
        ArrayList<Compra> compras = new ArrayList<>();
        Compra compra = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                 Proveedor prov= provData.buscarProveedorPorId(rs.getInt("idProveedor"));
                compra.setProveedor(prov);
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setEstado(true);
                compras.add(compra);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + ex.getMessage());
        }
        return compras;
    }
      
       public ArrayList<Compra> listarComprasInactivas(){ // funciona
         String sql = "SELECT idCompra, idProveedor,fecha, estado FROM compra WHERE estado = 0";
        ArrayList<Compra> compras = new ArrayList<>();
        Compra compra = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                 Proveedor prov= provData.buscarProveedorPorId(rs.getInt("idProveedor"));
                compra.setProveedor(prov);
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setEstado(true);
                compras.add(compra);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + ex.getMessage());
        }
        return compras;
       
    }
       
        public void borrarCompra(int idProveedor){  // funciona
        String sql = "UPDATE compra SET estado = 0  WHERE idProveedor=?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idProveedor);
             int borrado = ps.executeUpdate();
             if (borrado!=0) {
                 JOptionPane.showMessageDialog(null,"Compra borrada");
             }
             ps.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla compra " + ex.getMessage()); 
         }
    }
     
}
