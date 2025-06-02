package dao;

import Modelo.TipoMovimiento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase TipoMovimientoDAO que gestiona las operaciones CRUD para los tipos de
 * movimiento en la base de datos.
 * 
 * 1-06-2025 Clase TipoMovimientoDAO.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoMovimientoDAO {

    private Connection conexion;

    /**
     * Constructor que recibe una conexión a la base de datos.
     *
     * @param conexion Objeto Connection para ejecutar operaciones SQL.
     */
    public TipoMovimientoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta un nuevo tipo de movimiento en la base de datos usando un
     * procedimiento almacenado.
     *
     * @param tipo Objeto TipoMovimiento que contiene la descripción del tipo de
     *             movimiento.
     * @throws SQLException Si ocurre un error al ejecutar la operación.
     */
    public void insertarTipoMovimiento(TipoMovimiento tipo) throws SQLException {
        String sql = "{call InsertarTipoMovimiento(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, tipo.getdTipoMovimiento());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza un tipo de movimiento existente en la base de datos usando un
     * procedimiento almacenado.
     *
     * @param tipo Objeto TipoMovimiento con el código y la nueva descripción a
     *             actualizar.
     * @throws SQLException Si ocurre un error al ejecutar la operación.
     */
    public void actualizarTipoMovimiento(TipoMovimiento tipo) throws SQLException {
        String sql = "{call ActualizarTipoMovimiento(?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, tipo.getcTipoMovimiento());
            stmt.setString(2, tipo.getdTipoMovimiento());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un tipo de movimiento de la base de datos a partir de su código.
     *
     * @param cTipoMovimiento Código del tipo de movimiento a eliminar.
     * @throws SQLException Si ocurre un error al ejecutar la operación.
     */
    public void eliminarTipoMovimiento(int cTipoMovimiento) throws SQLException {
        String sql = "{call EliminarTipoMovimiento(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, cTipoMovimiento);
            stmt.executeUpdate();
        }
    }

    /**
     * Recupera una lista con todos los tipos de movimiento desde la vista
     * Vista_Tipo_Movimiento.
     *
     * @return Lista de objetos TipoMovimiento obtenidos de la base de datos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public List<TipoMovimiento> listarTipoMovimientos() throws SQLException {
        List<TipoMovimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Tipo_Movimiento";
        try (Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TipoMovimiento tipo = new TipoMovimiento();
                tipo.setcTipoMovimiento(rs.getInt("C_Tipo_Movimiento"));
                tipo.setdTipoMovimiento(rs.getString("D_Tipo_Movimiento"));
                lista.add(tipo);
            }
        }
        return lista;
    }
}
