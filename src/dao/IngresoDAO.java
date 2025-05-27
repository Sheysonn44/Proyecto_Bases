
package dao;

import Modelo.Ingreso;
import db.Conexion;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IngresoDAO {

    public void insertarIngreso(Ingreso ingreso) throws Exception {
        Connection conn = Conexion.getConexion();
        String sql = "{call InsertarIngreso(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cstmt = conn.prepareCall(sql);

        cstmt.setInt(1, ingreso.getcUsuario());
        cstmt.setInt(2, ingreso.getcCuentaBancaria());
        cstmt.setString(3, ingreso.getNombreCompleto());
        cstmt.setDouble(4, ingreso.getMonto());
        cstmt.setDate(5, ingreso.getFecha());
        cstmt.setString(6, ingreso.getDescripcionIngreso());
        cstmt.setInt(7, ingreso.getCategoria());
        cstmt.setInt(8, ingreso.getMetodoPago());
        cstmt.setInt(9, ingreso.getCtipoMoneda());
        cstmt.setString(10, ingreso.getdDestinatario());

        cstmt.execute();

    }

    public void eliminarIngreso(int cIngreso) throws Exception {

        String sql = "{call EliminarIngreso(?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, cIngreso);
            cstmt.executeUpdate();
            System.out.println("Ingreso eliminado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar ingreso: " + e.getMessage());
            throw e;
        }
    }

    public void editarIngreso(Ingreso ingreso, int cIngreso) throws Exception {

        String sql = "{call EditarIngreso(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, cIngreso);
            cstmt.setDouble(2, ingreso.getMonto());
            cstmt.setDate(3, ingreso.getFecha());
            cstmt.setString(4, ingreso.getDescripcionIngreso());
            cstmt.setInt(5, ingreso.getCategoria());
            cstmt.setInt(6, ingreso.getcCuentaBancaria());
            cstmt.setInt(7, ingreso.getMetodoPago());
            cstmt.setInt(8, ingreso.getCtipoMoneda());

            cstmt.executeUpdate();
            System.out.println("Ingreso actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al editar ingreso: " + e.getMessage());
            throw e;
        }
    }

    public void mostrarIngresos() throws Exception {

        String sql = "SELECT C_Ingreso, M_Ingreso, F_Ingreso, D_Descripcion, D_Simbolo, MetodoPagoDescripcion FROM VistaIngresos";

        try (Connection conn = Conexion.getConexion();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int cIngreso = rs.getInt("C_Ingreso");
                double monto = rs.getDouble("M_Ingreso");
                Date fecha = rs.getDate("F_Ingreso");
                String descripcion = rs.getString("D_Descripcion");
                String metodoPago = rs.getString("MetodoPagoDescripcion");
                String simboloMoneda = rs.getString("D_Simbolo");

                System.out.printf("Ingreso ID: %d, Monto: %.2f %s, Fecha: %s, Descripción: %s, Método Pago: %s%n",
                        cIngreso, monto, simboloMoneda, fecha.toString(), descripcion, metodoPago);
            }
        }

    }

    public void insertarIngresoMensual(BigDecimal monto, Date fecha, String detalle,
            int categoriaIngreso, int cuentaBancaria, int idInversion,
            int tipoMoneda, int tipoMovimiento, int tipoTransaccion) throws Exception {
        String sql = "INSERT INTO Ingresos (monto, fecha, detalle, categoria, cuentaBancaria, idInversion, tipoMoneda, tipoMovimiento, tipoTransaccion) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBigDecimal(1, monto);
            stmt.setDate(2, new java.sql.Date(fecha.getTime()));
            stmt.setString(3, detalle);
            stmt.setInt(4, categoriaIngreso);
            stmt.setInt(5, cuentaBancaria);
            stmt.setInt(6, idInversion);
            stmt.setInt(7, tipoMoneda);
            stmt.setInt(8, tipoMovimiento);
            stmt.setInt(9, tipoTransaccion);
            stmt.executeUpdate();
        }
    }

}
