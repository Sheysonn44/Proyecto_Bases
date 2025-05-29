package dao;
import java.sql.*;
import java.util.List;

import Modelo.Pago;

import java.math.BigDecimal;

/**
 * Clase para manejar operaciones relacionadas con pagos en la base de datos.
 * Proporciona métodos para insertar pagos individuales y registrar múltiples pagos asociados a una deuda.
 */
public class PagoDAO{ 

/**
     * Inserta un pago en la base de datos usando un procedimiento almacenado.
     *
     * @param conn          Conexión activa a la base de datos.
     * @param montoPago     Monto del pago.
     * @param fechaPago     Fecha en que se realizó el pago.
     * @param descripcion   Descripción del pago.
     * @param cuentaId      ID de la cuenta asociada al pago.
     * @param deudaId       ID de la deuda a la que se asocia el pago.
     * @param metodoPago    ID del método de pago.
     * @param destinatario  Nombre del destinatario del pago.
     * @param categoriaPago ID de la categoría del pago.
     * @param tipoTransaccion ID del tipo de transacción.
     * @param tipoMoneda    ID del tipo de moneda.
     * @throws SQLException Si ocurre un error durante la ejecución del procedimiento almacenado.
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
     * Registra una lista de pagos asociados a una deuda específica, ejecutando el procedimiento almacenado para cada pago.
     *
     * @param pagos    Lista de objetos Pago que se desean registrar.
     * @param idDeuda  ID de la deuda a la que se asocian los pagos.
     * @param conn     Conexión activa a la base de datos.
     * @throws SQLException Si ocurre un error durante la inserción de alguno de los pagos.
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
}
