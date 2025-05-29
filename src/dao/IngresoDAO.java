
package dao;

import Modelo.Ingreso;
import db.Conexion;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase IngresoDAO es para gestionar las operaciones relacionadas con los ingresos.
 * Incluye métodos para insertar, eliminar, editar y listar ingresos desde la base de datos.
 */
public class IngresoDAO {


/**
     * Inserta un nuevo ingreso en la base de datos utilizando el procedimiento almacenado  InsertarIngreso}.
     *
     * @param ingreso con los datos del ingreso a registrar.
     * @throws Exception si ocurre un error durante la operación de base de datos.
     */
    public void insertarIngreso(Ingreso ingreso) throws Exception {
        Connection conn = Conexion.getConexion();
        String sql = "{call InsertarIngreso(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)}";
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
        cstmt.setInt(11,ingreso.getCtipotran());

        cstmt.execute();

    }

 /**
     * Elimina un ingreso de la base de datos utilizando el procedimiento almacenado EliminarIngreso}.
     *
     * @param cIngreso Código del ingreso a eliminar.
     * @throws Exception si ocurre un error al eliminar el ingreso.
     */
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

  /**
     * Edita los datos de un ingreso existente mediante el procedimiento almacenado.
     *
     * @param ingreso     los nuevos datos del ingreso.
     * @param cIngreso    Código del ingreso que se va a editar.
     * @throws Exception si ocurre un error durante la actualización.
     */
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

     /**
     * Muestra una lista de ingresos utilizando la vista VistaIngresos.
     *
     * @throws Exception si ocurre un error al obtener los datos.
     */

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
 /**
     * Inserta un ingreso mensual de forma directa en la tabla Ingresos. (sin procedimiento almacenado).
     *
     * @param monto             Monto del ingreso.
     * @param fecha             Fecha del ingreso.
     * @param detalle           Descripción o detalle del ingreso.
     * @param categoriaIngreso  ID de la categoría.
     * @param cuentaBancaria    ID de la cuenta bancaria.
     * @param idInversion       ID de inversión asociada (si aplica).
     * @param tipoMoneda        ID del tipo de moneda.
     * @param tipoMovimiento    Tipo de movimiento financiero.
     * @param tipoTransaccion   Tipo de transacción.
     * @throws Exception si ocurre un error al insertar.
     */
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
