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

    private CompraData comData = new CompraData();
    private ProveedorData provData = new ProveedorData();
    private ProductoData prodData = new ProductoData();

    private Connection con = null;

    public DetalleCompraData() {
        con = Conexion.getConexion();

    }

    public ArrayList<DetalleCompra> buscarDetallePorCompra(Compra compra) {
        String sql = " SELECT idDetalle, cantidad, precioCosto , idProducto, idCompra * FROM detalleCompra WHERE idCompra  = 0";
        ArrayList<DetalleCompra> detalles = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, compra.getIdCompra());

            ResultSet rs = ps.executeQuery();
            DetalleCompra detaCompra;
            Producto produc;
            while (rs.next()) {
                produc = prodData.buscarProductoPorId(rs.getInt("idProducto"));
                detaCompra = new DetalleCompra(rs.getInt("idDetalleCompra"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precioCosto"),
                        compra, produc);
                detalles.add(detaCompra);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla" + ex.getMessage());
        }

        return detalles;
    }

    public void guardarDetalleCompra(DetalleCompra detCom) {
        String sql = " INSERT INTO detalleCompra (cantidad,precioCosto, idCompra,idProducto)"
                + " VALUES (?,?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detCom.getCompra().getIdCompra());
            ps.setInt(2, detCom.getProducto().getIdProducto());
            ps.setInt(3, detCom.getCantidad());
            ps.setDouble(4, detCom.getPrecioCosto());
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

    public void modificarPrecioCosto(int idCompra, int idProducto, double precioCosto) { // funciona
        String sql = " UPDATE detalleCompra  SET precioCosto =? "
                + " WHERE idCompra=? AND idProducto=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, precioCosto);
            ps.setInt(2, idCompra);
            ps.setInt(3, idProducto);
            int modificado = ps.executeUpdate();
            if (modificado > 0) {
                JOptionPane.showMessageDialog(null, "Precio Costo modificado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla detalleCompra " + ex.getMessage());
        }
    }

    public void eliminar(int idDetalle) {
        String sql = "DELETE FROM detalleCompra WHERE idDetalle = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDetalle);
            int eliminado = ps.executeUpdate();
            if (eliminado == 1) {
                JOptionPane.showMessageDialog(null, "Detalle Compra eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el detalle de compra para eliminar");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla detalle Compra" + ex.getMessage());
        }

    }
}
