package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.Date;
import db.Conexion;


/**
 * Clase para manejar operaciones relacionadas con la entidad Transacciones en la base de datos.
 * Proporciona métodos para insertar transacciones y otros métodos CRUD que se pueden implementar.
 */
public class TransaccionDAO {
    /**
     * Inserta una nueva transacción en la base de datos.
     *
     * @param monto           Monto de la transacción.
     * @param fecha           Fecha en que se realizó la transacción.
     * @param descripcion     Descripción breve de la transacción.
     * @param detalle         Detalle o información adicional de la transacción.
     * @param categoria       ID de la categoría de la transacción.
     * @param cuentaBancaria  ID de la cuenta bancaria relacionada con la transacción.
     * @param tipoMoneda      ID del tipo de moneda de la transacción.
     * @param tipoMovimiento  ID del tipo de movimiento (ejemplo: débito, crédito).
     * @param tipoTransaccion ID del tipo de transacción.
     * @throws Exception Si ocurre algún error al ejecutar la inserción en la base de datos.
     */

    public void insertar(BigDecimal monto, Date fecha, String descripcion, String detalle,
                     int categoria, int cuentaBancaria, int tipoMoneda,
                     int tipoMovimiento, int tipoTransaccion) throws Exception {
    String sql = "INSERT INTO Transacciones (monto, fecha, descripcion, detalle, categoria, cuentaBancaria, tipoMoneda, tipoMovimiento, tipoTransaccion) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConexion();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setBigDecimal(1, monto);
        stmt.setDate(2, new java.sql.Date(fecha.getTime()));
        stmt.setString(3, descripcion);
        stmt.setString(4, detalle);
        stmt.setInt(5, categoria);
        stmt.setInt(6, cuentaBancaria);
        stmt.setInt(7, tipoMoneda);
        stmt.setInt(8, tipoMovimiento);
        stmt.setInt(9, tipoTransaccion);
        stmt.executeUpdate();
    }
}


}
