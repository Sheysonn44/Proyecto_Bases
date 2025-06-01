package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import db.Conexion;
import Modelo.*;

/**
 * Clase para manejar las operaciones CRUD de la tabla Inversiones.
 * Proporciona métodos para insertar, actualizar, eliminar y listar inversiones
 * hipotecarias,
 * así como para ejecutar procedimientos almacenados relacionados.
 */
public class InversionDAO {
    /**
     * Inserta una nueva inversión en la base de datos y retorna el ID generado.
     * La fecha final se calcula automáticamente sumando 1 año a la fecha de inicio.
     *
     * @param inv Objeto Inversion con los datos a insertar.
     * @return ID generado para la nueva inversión.
     * 
     * 
     * @throws Exception si ocurre un error en la base de datos o no se genera el
     *                   ID.
     */
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

    /**
     * Actualiza una inversión existente en la base de datos usando un procedimiento
     * almacenado.
     *
     * @param inv Objeto Inversion con los datos actualizados.
     * @throws Exception si ocurre un error en la base de datos.
     */
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

    /**
     * Elimina una inversión de la base de datos dado su ID.
     *
     * @param id ID de la inversión a eliminar.
     * @throws Exception si ocurre un error en la base de datos.
     */
    public void eliminar(int id) throws Exception {
        Connection conn = Conexion.getConexion();
        String sql = "{CALL SP_EliminarInversion(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    /**
     * Lista todas las inversiones registradas en la base de datos.
     *
     * @return Lista de objetos Inversion con los datos recuperados.
     * @throws Exception si ocurre un error en la base de datos.
     */
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
    public void registrarInversionHipotecaria(Inversion inversion) throws Exception {
        Connection conn = Conexion.getConexion();
        try {
            CallableStatement cs = conn
                    .prepareCall("{call sp_RegistrarInversionHipotecaria(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            // 🔽 Parámetros de entrada (ajustalos con los datos deseados)
            cs.setString(1, inversion.getNombre()); // @D_Nombre
            cs.setString(2, inversion.getTipoInversion()); // @T_Inversion
            cs.setBigDecimal(3, inversion.getMonto()); // @M_Inversion
            cs.setBigDecimal(4, inversion.getRentabilidad()); // @M_Rentabilidad
            cs.setDate(5, inversion.getFechaInicio()); // @F_Inicio
            cs.setString(6, inversion.getDescripcion()); // @D_Descripcion
            cs.setInt(7, inversion.getCuentaBancaria()); // @C_Cuenta_Bancaria
            cs.setInt(8, inversion.getEstado()); // @C_Estado
            cs.setInt(9, inversion.getTipoInversionId()); // @C_TipoInversion
            cs.setInt(10, inversion.getCategoriaSalida()); // @C_Categoria_Salida
            cs.setInt(11, inversion.getCategoriaIngreso()); // @C_Categoria_Ingreso
            cs.setInt(12, inversion.getTipoMoneda()); // @C_TipoMoneda
            cs.setInt(13, inversion.getTipoTransaccion()); // @C_Tipo_Transaccion (Egreso)

            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("Mensaje"));
            }
            cs.close();
        } catch (Exception e) {
            System.out.println("❌ Error al registrar la inversión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
