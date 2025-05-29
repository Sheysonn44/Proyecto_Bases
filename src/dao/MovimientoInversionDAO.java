package dao;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.MovimientoInversion;
/**
 * Clase para manejar las operaciones CRUD de MovimientoInversion en la base de datos.
 * Proporciona métodos para insertar, actualizar, eliminar y listar movimientos de inversión.
 */

public class MovimientoInversionDAO {
    private final Connection conn;
 /**
     * Constructor que recibe una conexión a la base de datos.
     * 
     * @param conn conexión activa a la base de datos.
     */
    public MovimientoInversionDAO(Connection conn) {
        this.conn = conn;
    }

     /**
     * Inserta un nuevo movimiento de inversión en la base de datos usando un procedimiento almacenado.
     * 
     * @param mov objeto MovimientoInversion con los datos a insertar.
     * @throws SQLException si ocurre un error durante la operación en la base de datos.
     */
    public void insertar(MovimientoInversion mov) throws SQLException {
        String sql = "{CALL SP_InsertarMovimientoInversion(?,?,?,?,?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setBigDecimal(1, mov.getMonto());
            stmt.setDate(2, new java.sql.Date(mov.getFecha().getTime()));
            stmt.setInt(3, mov.getInversionId());
            stmt.setInt(4, mov.getTipoMoneda());
            stmt.setInt(5, mov.getTipoMovimiento());
            stmt.executeUpdate();
        }
    }

     /**
     * Actualiza un movimiento de inversión existente en la base de datos usando un procedimiento almacenado.
     * 
     * @param mov objeto MovimientoInversion con los datos actualizados.
     * @throws SQLException si ocurre un error durante la operación en la base de datos.
     */
    public void actualizar(MovimientoInversion mov) throws SQLException {
        String sql = "{CALL SP_ActualizarMovimientoInversion(?,?,?,?,?,?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, mov.getId());
            stmt.setBigDecimal(2, mov.getMonto());
            stmt.setDate(3, new java.sql.Date(mov.getFecha().getTime()));
            stmt.setInt(4, mov.getInversionId());
            stmt.setInt(5, mov.getTipoMoneda());
            stmt.setInt(6, mov.getTipoMovimiento());
            stmt.executeUpdate();
        }
    }

     /**
     * Elimina un movimiento de inversión de la base de datos dado su ID usando un procedimiento almacenado.
     * 
     * @param id ID del movimiento de inversión a eliminar.
     * @throws SQLException si ocurre un error durante la operación en la base de datos.
     */
    public void eliminar(int id) throws SQLException {
        String sql = "{CALL SP_EliminarMovimientoInversion(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    /**
     * Recupera una lista con todos los movimientos de inversión almacenados en la base de datos.
     * 
     * @return Lista de objetos MovimientoInversion.
     * @throws SQLException si ocurre un error durante la consulta.
     */
    public List<MovimientoInversion> listar() throws SQLException {
        List<MovimientoInversion> lista = new ArrayList<>();
        String sql = "SELECT * FROM FN_ListarMovimientosInversion()";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                MovimientoInversion mov = new MovimientoInversion();
                mov.setId(rs.getInt("C_Movimiento_Inversion"));
                mov.setMonto(rs.getBigDecimal("M_Movimiento_Inversion"));
                mov.setFecha(rs.getDate("F_Movimiento_Inversion"));
                mov.setInversionId(rs.getInt("C_Inversion"));
                mov.setTipoMoneda(rs.getInt("C_TipoMoneda"));
                mov.setTipoMovimiento(rs.getInt("C_Tipo_Movimiento"));
                lista.add(mov);
            }
        }
        return lista;
    }
}
