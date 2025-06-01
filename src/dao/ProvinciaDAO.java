package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Provincia;
import db.Conexion;
/**
 * Clase ProvinciaDAO para manejar las operaciones de acceso a datos relacionadas
 * con la entidad Provincia.
 * Permite insertar, actualizar, eliminar y listar provincias en la base de datos.
 */
public class ProvinciaDAO {

    /**
     * Inserta una nueva provincia en la base de datos.
     *
     * @param provincia Objeto Provincia con los datos a insertar.
     * @throws Exception Si ocurre un error al ejecutar la inserción en la base de datos.
     */
    public void insertarProvincia(Provincia provincia) throws Exception {
        String sql = "{CALL SP_InsertarProvincia(?)}";

        try (Connection conn = Conexion.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, provincia.getNombre());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza una provincia existente en la base de datos.
     *
     * @param id       ID de la provincia a actualizar.
     * @param provincia Objeto Provincia con los nuevos datos.
     * @throws Exception Si ocurre un error al ejecutar la actualización en la base de datos.
     */
    public void actualizarProvincia(int id, Provincia provincia) throws Exception {
        String sql = "{CALL SP_ActualizarProvincia(?, ?)}";

        try (Connection conn = Conexion.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, provincia.getNombre());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina una provincia de la base de datos dado su ID.
     *
     * @param id ID de la provincia a eliminar.
     * @throws Exception Si ocurre un error al ejecutar la eliminación en la base de datos.
     */
    public void eliminarProvincia(int id) throws Exception {
        String sql = "{CALL SP_EliminarProvincia(?)}";

        try (Connection conn = Conexion.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    /**
     * Lista todas las provincias registradas en la base de datos.
     *
     * @return Lista de objetos Provincia con los datos recuperados.
     * @throws Exception Si ocurre un error al ejecutar la consulta en la base de datos.
     */
    public List<Provincia> listarProvincias() throws Exception {
        List<Provincia> lista = new ArrayList<>();
        String sql = "SELECT * FROM FN_ListarProvincias()";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Provincia p = new Provincia();
                p.setId(rs.getInt("C_Provincia"));
                p.setNombre(rs.getString("D_Provincia"));
                lista.add(p);
            }
        }

        return lista;
    }
}
