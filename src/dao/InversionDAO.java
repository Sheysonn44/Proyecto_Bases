package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import db.Conexion;
import Modelo.*;

/*
 * * Clase para manejar las inversiones hipotecarias.
 * * Contiene metodos crud para la tabla inversiones.
 * * Esta clase contiene un método para ejecutar un procedimiento almacenado
 * * que registra una inversión hipotecaria en la base de datos.
 * * El procedimiento almacenado se llama sp_RegistrarInversionHipotecaria
 * * y recibe varios parámetros relacionados con la inversión.
 */
public class InversionDAO {
    // public void registrarInversion(Inversion i) throws Exception {
    // Connection conn = Conexion.getConexion();

    // CallableStatement cs = conn
    // .prepareCall("{call sp_registrarInversionHipotecaria(?, ?, ?, ?, ?, ?, ?, ?,
    // ?, ?, ?, ?, ?, ?)}");

    // cs.setString(1, i.getNombre());
    // cs.setString(2, i.getTipoInversion());
    // cs.setBigDecimal(3, i.getMonto());
    // cs.setBigDecimal(4, i.getRentabilidad());
    // cs.setDate(5, i.getFechaInicio());
    // cs.setString(6, i.getDescripcion());
    // cs.setInt(7, i.getCuentaBancaria());
    // cs.setInt(8, i.getEstado());
    // cs.setInt(9, i.getTipoInversionId());
    // cs.setInt(10, i.getCategoriaSalida());
    // cs.setInt(11, i.getCategoriaIngreso());
    // cs.setInt(12, i.getTipoMoneda());
    // cs.setInt(13, i.getTipoMovimiento());
    // cs.setInt(14, i.getTipoTransaccion());
    // cs.execute();

    // ResultSet rs = cs.getResultSet();
    // if (rs != null && rs.next()) {
    // System.out.println("📢 " + rs.getString("Mensaje"));
    // rs.close();
    // }

    // cs.close();
    // conn.close();
    // }
    public int insertarYObtenerID(Inversion inv) throws Exception {
        Connection conn = Conexion.getConexion();
        String sql = "INSERT INTO Inversiones (nombre, tipoInversion, monto, rentabilidad, fechaInicio, fechaFinal, descripcion, cuentaBancaria, estado, tipoInversionId, tipoMoneda) "
                +
                "OUTPUT INSERTED.id " +
                "VALUES (?, ?, ?, ?, ?, DATEADD(YEAR, 1, ?), ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, inv.getNombre());
            stmt.setString(2, inv.getTipoInversion());
            stmt.setBigDecimal(3, inv.getMonto());
            stmt.setBigDecimal(4, inv.getRentabilidad());
            stmt.setDate(5, new java.sql.Date(inv.getFechaInicio().getTime()));
            stmt.setDate(6, new java.sql.Date(inv.getFechaInicio().getTime())); // Para fechaFinal
            stmt.setString(7, inv.getDescripcion());
            stmt.setInt(8, inv.getCuentaBancaria());
            stmt.setInt(9, inv.getEstado());
            stmt.setInt(10, inv.getTipoInversionId());
            stmt.setInt(11, inv.getTipoMoneda());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // ID generado
            } else {
                throw new Exception("No se generó ID de inversión.");
            }
        }
    }

    public void actualizar(Inversion inv) throws Exception {
        Connection conn = Conexion.getConexion();

        String sql = "{CALL SP_ActualizarInversion(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(2, inv.getNombre());
            stmt.setString(3, inv.getTipoInversion());
            stmt.setBigDecimal(4, inv.getMonto());
            stmt.setBigDecimal(5, inv.getRentabilidad());
            stmt.setDate(6, new java.sql.Date(inv.getFechaInicio().getTime()));
            stmt.setString(7, inv.getDescripcion());
            stmt.setInt(8, inv.getCuentaBancaria());
            stmt.setInt(9, inv.getEstado());
            stmt.setInt(10, inv.getTipoInversionId());
            stmt.setInt(11, inv.getCategoriaSalida());
            stmt.setInt(12, inv.getCategoriaIngreso());
            stmt.setInt(13, inv.getTipoMoneda());
            stmt.setInt(14, inv.getTipoMovimiento());
            stmt.setInt(15, inv.getTipoTransaccion());

            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws Exception {
        Connection conn = Conexion.getConexion();
        String sql = "{CALL SP_EliminarInversion(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Inversion> listar() throws Exception {
        Connection conn = Conexion.getConexion();
        List<Inversion> lista = new ArrayList<>();
        String sql = "SELECT * FROM FN_ListarInversiones()";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Inversion inv = new Inversion();
                inv.setNombre(rs.getString("nombre"));
                inv.setTipoInversion(rs.getString("tipoInversion"));
                inv.setMonto(rs.getBigDecimal("monto"));
                inv.setRentabilidad(rs.getBigDecimal("rentabilidad"));
                inv.setFechaInicio(rs.getDate("fechaInicio"));
                inv.setDescripcion(rs.getString("descripcion"));
                inv.setCuentaBancaria(rs.getInt("cuentaBancaria"));
                inv.setEstado(rs.getInt("estado"));
                inv.setTipoInversionId(rs.getInt("tipoInversionId"));
                inv.setCategoriaSalida(rs.getInt("categoriaSalida"));
                inv.setCategoriaIngreso(rs.getInt("categoriaIngreso"));
                inv.setTipoMoneda(rs.getInt("tipoMoneda"));
                inv.setTipoMovimiento(rs.getInt("tipoMovimiento"));
                inv.setTipoTransaccion(rs.getInt("tipoTransaccion"));
                lista.add(inv);
            }
        }
        return lista;
    }

}
