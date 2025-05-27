package dao;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.MovimientoInversion;
/**
 * Clase DAO para manejar las operaciones de MovimientoInversion en la base de datos.
 */

public class MovimientoInversionDAO {
    private final Connection conn;

    public MovimientoInversionDAO(Connection conn) {
        this.conn = conn;
    }

    // INSERTAR
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

    // ACTUALIZAR
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

    // ELIMINAR
    public void eliminar(int id) throws SQLException {
        String sql = "{CALL SP_EliminarMovimientoInversion(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // LISTAR
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
