package dao;

import Modelo.TipoDeuda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase TipoDeudaDAO que gestiona las operaciones CRUD sobre los tipos de deuda
 * en la base de datos.
 * 
 * 1-06-2025 Clase TipoDeudaDAO.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoDeudaDAO {

    private Connection conexion;

    /**
     * Constructor que recibe una conexión a la base de datos.
     *
     * @param conexion Objeto Connection utilizado para conectarse a la base de
     *                 datos.
     */
    public TipoDeudaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta un nuevo tipo de deuda utilizando un procedimiento almacenado.
     *
     * @param tipo Objeto TipoDeuda que contiene la descripción del tipo de deuda a
     *             insertar.
     * @throws SQLException Si ocurre un error durante la ejecución del
     *                      procedimiento almacenado.
     */
    public void insertarTipoDeuda(TipoDeuda tipo) throws SQLException {
        String sql = "{call InsertarTipoDeuda(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, tipo.getdTipoDeuda());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza un tipo de deuda existente utilizando un procedimiento almacenado.
     *
     * @param tipo Objeto TipoDeuda con el código y la nueva descripción del tipo de
     *             deuda.
     * @throws SQLException Si ocurre un error durante la ejecución del
     *                      procedimiento almacenado.
     */
    public void actualizarTipoDeuda(TipoDeuda tipo) throws SQLException {
        String sql = "{call ActualizarTipoDeuda(?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, tipo.getcTipoDeuda());
            stmt.setString(2, tipo.getdTipoDeuda());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un tipo de deuda de la base de datos utilizando un procedimiento
     * almacenado.
     *
     * @param cTipoDeuda Código del tipo de deuda a eliminar.
     * @throws SQLException Si ocurre un error durante la ejecución del
     *                      procedimiento almacenado.
     */
    public void eliminarTipoDeuda(int cTipoDeuda) throws SQLException {
        String sql = "{call EliminarTipoDeuda(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, cTipoDeuda);
            stmt.executeUpdate();
        }
    }

    /**
     * Obtiene una lista con todos los tipos de deuda desde la vista correspondiente
     * en la base de datos.
     *
     * @return Lista de objetos TipoDeuda con los datos obtenidos.
     * @throws SQLException Si ocurre un error durante la ejecución de la consulta.
     */
    public List<TipoDeuda> listarTipoDeudas() throws SQLException {
        List<TipoDeuda> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Tipos_Deudas";
        try (Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TipoDeuda tipo = new TipoDeuda();
                tipo.setcTipoDeuda(rs.getInt("C_Tipo_Deuda"));
                tipo.setdTipoDeuda(rs.getString("D_Tipo_Deuda"));
                lista.add(tipo);
            }
        }
        return lista;
    }
}
