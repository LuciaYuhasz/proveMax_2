/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax_2.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import provemax_2.entidades.Compra;
import provemax_2.entidades.DetalleCompra;
import provemax_2.entidades.Producto;

/**
 *
 * @author Usuario
 */
public class DetalleCompraData {
     private Connection con = null;
    ProductoData prodData = new ProductoData();
    public DetalleCompraData() {
        con = Conexion.getConexion();
              
    }
//   public ArrayList<DetalleCompra> buscarDetallePorCompra(Compra compra){
//        String sql= " SELECT idDetalle, cantidad, precioCosto , idProducto FROM detalleCompra WHERE idCompra=? ";
//        ArrayList<DetalleCompra> detalles= new ArrayList<>();
//       try{
//          PreparedStatement ps= con.prepareStatement(sql);
//          ps.setInt(1,compra.getIdCompra());
//          
//          ResultSet rs=ps.executeQuery();
//          DetalleCompra detaCompra;
//          Producto produc;
//         while(rs.next()){
//           produc = prodData.buscarProductoPorId(rs.getInt("idProducto")); 
//           detaCompra = new DetalleCompra(rs.getInt("idDetalleCompra"),
//                                         rs.getInt("cantidad"),
//                                         rs.getDouble("precioCosto"),
//                                        compra,produc);
//           detalles.add(detaCompra);
//           }
//           ps.close();
//         
//       }  catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null,"error al acceder a la tabla" + ex.getMessage());
//    }
//   
//    return detalles;
//}
    
       public ArrayList<DetalleCompra> buscarDetallePorCompra(Compra compra) {
        String sql = "SELECT idDetalle, cantidad, precioCosto, idProducto FROM detalleCompra WHERE idCompra=?";
        ArrayList<DetalleCompra> detalles = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, compra.getIdCompra());

            ResultSet rs = ps.executeQuery();
            DetalleCompra detaCompra;
            Producto produc;

            while (rs.next()) {
                int idDetalle = rs.getInt("idDetalle");
                int cantidad = rs.getInt("cantidad");
                int precioCosto = rs.getInt("precioCosto");
                int idProducto = rs.getInt("idProducto");

                produc = prodData.buscarProductoPorId(idProducto);

                detaCompra = new DetalleCompra(idDetalle, cantidad, precioCosto, compra, produc);
                detalles.add(detaCompra);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: " + ex.getMessage());
        }

        return detalles;
    }
 
       
       
    public void guardarDetalleCompra(DetalleCompra detCom) {
        String sql = " INSERT INTO detalleCompra (cantidad,precioCosto, idCompra,idProducto)"
                + " VALUES (?,?,?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detCom.getIdDetalle());
            ps.setInt(2, detCom.getCantidad());
            ps.setDouble(3, detCom.getPrecioCosto());
            ps.setInt(4, detCom.getCompra().getIdCompra());
            ps.setInt(5, detCom.getProducto().getIdProducto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                detCom.setIdDetalle(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle de compra Guardado CORRECTAMENTE");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con tabla de detalleCompra" + ex.getMessage());
           
        }
    }
    
      public void modificarPrecioCosto(int idCompra, int idProducto, double precioCosto){ // funciona
        String sql= " UPDATE detalleCompra  SET precioCosto =? "
               + " WHERE idCompra=? AND idProducto=? ";
         try {
             PreparedStatement ps= con.prepareStatement(sql);
             ps.setDouble(1,precioCosto);
             ps.setInt(2, idCompra);
             ps.setInt(3, idProducto);
              int modificado=ps.executeUpdate();
            if (modificado>0) {
                JOptionPane.showMessageDialog(null,"Precio Costo modificado");
            }
            ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla detalleCompra " + ex.getMessage());
         }
      }
    
   
   }
//
//      public List<DetalleCompra> obtenerCompraRealizadas(int idCompra){ 
//       
//            List<DetalleCompra> listaComRealizada = new ArrayList<>();
//            String sql=" SELECT detallecompra.idProveedor, cuit, razonSocial, domicilio, telefono FROM detallecompra, proveedor, materia  "
//                    +" WHERE detallecompra.idProveedor= proveedor.idProveedor AND detallecompra.idCompra =? ";
//          
//             try {
//            
//            PreparedStatement ps= con.prepareStatement(sql);
//            
//            ps.setInt(1, idCompra);
//            ResultSet rs= ps.executeQuery();
//            while(rs.next()){
//                Proveedor prove=new Proveedor();
//                prove.setIdProveedor(rs.getInt("idProveedor"));
//                prove.setCuit(rs.getFloat("cuit"));
//                prove.setRazonSocial(rs.getString("razonSocial"));
//                prove.setDomicilio(rs.getString("domicilio"));
//                prove.setTelefono(rs.getString("telefono"));
//             //   listaComRealizada.add(prove);
//                
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"error al aceeder a la tabla");
//        }
//       return listaComRealizada;
//       }



 

