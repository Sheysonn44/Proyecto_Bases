package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.Pago;

import java.math.BigDecimal;

/**
 * Clase para manejar operaciones relacionadas con pagos en la base de datos.
 * Proporciona métodos para insertar pagos individuales y registrar múltiples
 * pagos asociados a una deuda.
 */
public class PagoDAO {

    /**
     * Inserta un pago en la base de datos usando un procedimiento almacenado.
     *
     * @param conn            Conexión activa a la base de datos.
     * @param montoPago       Monto del pago.
     * @param fechaPago       Fecha en que se realizó el pago.
     * @param descripcion     Descripción del pago.
     * @param cuentaId        ID de la cuenta asociada al pago.
     * @param deudaId         ID de la deuda a la que se asocia el pago.
     * @param metodoPago      ID del método de pago.
     * @param destinatario    Nombre del destinatario del pago.
     * @param categoriaPago   ID de la categoría del pago.
     * @param tipoTransaccion ID del tipo de transacción.
     * @param tipoMoneda      ID del tipo de moneda.
     * @throws SQLException Si ocurre un error durante la ejecución del
     *                      procedimiento almacenado.
     */

    public void insertarPago(Connection conn, BigDecimal montoPago, Date fechaPago, String descripcion,
            int cuentaId, int deudaId, int metodoPago, String destinatario,
            int categoriaPago, int tipoTransaccion, int tipoMoneda) throws SQLException {
        String sql = "{call InsertarPagoDeuda(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setBigDecimal(1, montoPago);
            stmt.setDate(2, new java.sql.Date(fechaPago.getTime()));
            stmt.setString(3, descripcion);
            stmt.setInt(4, cuentaId);
            stmt.setInt(5, deudaId);
            stmt.setInt(6, metodoPago);
            stmt.setString(7, destinatario);
            stmt.setInt(8, categoriaPago);
            stmt.setInt(8, tipoTransaccion);
            stmt.setInt(10, tipoMoneda);
            stmt.executeUpdate();
        }
    }

    /**
     * Registra una lista de pagos asociados a una deuda específica, ejecutando el
     * procedimiento almacenado para cada pago.
     *
     * @param pagos   Lista de objetos Pago que se desean registrar.
     * @param idDeuda ID de la deuda a la que se asocian los pagos.
     * @param conn    Conexión activa a la base de datos.
     * @throws SQLException Si ocurre un error durante la inserción de alguno de los
     *                      pagos.
     */
    public void registrarPagos(List<Pago> pagos, int idDeuda, Connection conn) throws SQLException {
        for (Pago pago : pagos) {
            try (CallableStatement stmt = conn.prepareCall("{call InsertarPagoDeuda(?, ?, ?, ?, ?, ?, ?, ?, ?,?)}")) {
                stmt.setBigDecimal(1, pago.getMonto());
                stmt.setDate(2, pago.getFechaPago());
                stmt.setString(3, pago.getDescripcion());
                stmt.setInt(4, pago.getCuentaId());
                stmt.setInt(5, idDeuda);
                stmt.setInt(6, pago.getMetodoPagoId());
                stmt.setString(7, pago.getDestinatario());
                stmt.setInt(8, pago.getCategoriaPagoId());
                stmt.setInt(9, pago.getTipoTransaccionId());
                stmt.setInt(10, pago.getTipoMonedaId());
                stmt.execute();
            }
        }

    }

    /**
     * Obtiene una lista de todos los pagos registrados en la base de datos.
     *
     * @param conn Conexión activa a la base de datos.
     * @return Lista de objetos Pago con los detalles de cada pago.
     * @throws SQLException Si ocurre un error al ejecutar el procedimiento
     *                      almacenado.
     */

    public List<Pago> obtenerPagos(Connection conn) throws SQLException {
        List<Pago> lista = new ArrayList<>();
        String sql = "{call sp_Mostrar_Pagos()}"; 
        try (CallableStatement stmt = conn.prepareCall(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pago pago = new Pago(
                        rs.getBigDecimal("M_Pago"),
                        rs.getDate("F_Pago"),
                        rs.getString("D_Descripcion"),
                        rs.getInt("C_Cuenta_Bancaria"),
                        rs.getInt("C_Metodo_Pago"),
                        rs.getString("D_Destinatario"),
                        rs.getInt("C_Categoria"),
                        rs.getInt("C_TipoTransaccion"),
                        rs.getInt("C_TipoMoneda"));
                lista.add(pago);
            }
        }

        return lista;
    }

    /**
     * Elimina un pago específico de la base de datos.
     *
     * @param idPago ID del pago que se desea eliminar.
     * @param conn   Conexión activa a la base de datos.
     * @throws SQLException Si ocurre un error al ejecutar el procedimiento
     *                      almacenado.
     */
    public void eliminarPago(int idPago, Connection conn) throws SQLException {
        String sql = "{call sp_Eliminar_Pago(?)}";

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, idPago);
            stmt.executeUpdate();
            System.out.println("Pago eliminado correctamente.");
        }
    }

    /**
     * Actualiza un pago existente en la base de datos.
     *
     * @param pago   Objeto Pago con los nuevos datos.
     * @param idPago ID del pago que se desea actualizar.
     * @param conn   Conexión activa a la base de datos.
     * @throws SQLException Si ocurre un error al ejecutar el procedimiento
     *                      almacenado.
     */
    public void actualizarPago(Pago pago, int idPago, Connection conn) throws SQLException {
        String sql = "{call sp_Actualizar_Pago(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, idPago);
            stmt.setBigDecimal(2, pago.getMonto());
            stmt.setDate(3, pago.getFechaPago());
            stmt.setBigDecimal(4, BigDecimal.ZERO); 
            stmt.setString(5, pago.getDescripcion());
            stmt.setInt(6, pago.getCuentaId());
            stmt.setInt(7, pago.getMetodoPagoId());
            stmt.setInt(8, pago.getTipoMonedaId());
            stmt.setString(9, pago.getDestinatario());
            stmt.setInt(10, pago.getCategoriaPagoId());
            stmt.setInt(11, 0); 
            stmt.setInt(12, pago.getTipoTransaccionId());

            stmt.executeUpdate();
            System.out.println("Pago actualizado correctamente.");
        }
    }

}
