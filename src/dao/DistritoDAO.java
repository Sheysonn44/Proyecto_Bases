package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Distrito;
import db.Conexion;

/**
 * Clase DistritoDAO para manejar las operaciones de acceso a datos relacionadas
 * con la entidad Distrito.
 * Permite insertar, actualizar, eliminar y listar distritos en la base de
 * datos.
 * * 1-06-2025 Clase DistritoDAO*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class DistritoDAO {
    /**
     * Inserta un nuevo distrito en la base de datos.
     *
     * @param distrito Objeto Distrito con los datos a insertar.
     * @throws Exception Si ocurre un error al ejecutar la inserción en la base de
     *                   datos.
     */
    public void insertarDistrito(Distrito distrito) throws Exception {
        String sql = "{CALL SP_InsertarDistrito(?, ?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, distrito.getNombre());
            stmt.setInt(2, distrito.getCantonId());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza un distrito existente en la base de datos.
     *
     * @param id       ID del distrito a actualizar.
     * @param distrito Objeto Distrito con los nuevos datos.
     * @throws Exception Si ocurre un error al ejecutar la actualización en la base
     *                   de datos.
     */
    public void actualizarDistrito(int id, Distrito distrito) throws Exception {
        String sql = "{CALL SP_ActualizarDistrito(?, ?, ?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, distrito.getNombre());
            stmt.setInt(3, distrito.getCantonId());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un distrito de la base de datos dado su ID.
     *
     * @param id ID del distrito a eliminar.
     * @throws Exception Si ocurre un error al ejecutar la eliminación en la base de
     *                   datos.
     */
    public void eliminarDistrito(int id) throws Exception {
        String sql = "{CALL SP_EliminarDistrito(?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    /**
     * Lista todos los distritos registrados en la base de datos.
     *
     * @return Lista de objetos Distrito con los datos recuperados.
     * @throws Exception Si ocurre un error en la base de datos.
     */
    public List<Distrito> listarDistritos() throws Exception {
        List<Distrito> lista = new ArrayList<>();
        String sql = "SELECT * FROM FN_ListarDistritos()";

        try (Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Distrito d = new Distrito();
                d.setId(rs.getInt("C_Distrito"));
                d.setNombre(rs.getString("D_Distrito"));
                d.setCantonId(rs.getInt("C_Canton"));
                lista.add(d);
            }
        }

        return lista;
    }
}
