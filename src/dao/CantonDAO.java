package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Canton;
import db.Conexion;

/**
 * Clase CantonDAO para manejar las operaciones de acceso a datos relacionadas
 * con la entidad Canton.
 * Permite insertar, actualizar, eliminar y listar cantones en la base de datos.
 * 1-06-2025 Clase CantonDAO.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 
 */
public class CantonDAO {
    /**
     * Inserta un nuevo canton en la base de datos.
     *
     * @param canton Objeto Canton con los datos a insertar.
     * @throws Exception Si ocurre un error al ejecutar la inserción en la base de
     *                   datos.
     */
    public void insertarCanton(Canton canton) throws Exception {
        String sql = "{CALL SP_InsertarCanton(?, ?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, canton.getNombre());
            stmt.setInt(2, canton.getProvinciaId());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza un canton existente en la base de datos.
     *
     * @param id     ID del canton a actualizar.
     * @param canton Objeto Canton con los nuevos datos.
     * @throws Exception Si ocurre un error al ejecutar la actualización en la base
     *                   de datos.
     */
    public void actualizarCanton(int id, Canton canton) throws Exception {
        String sql = "{CALL SP_ActualizarCanton(?, ?, ?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, canton.getNombre());
            stmt.setInt(3, canton.getProvinciaId());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un canton de la base de datos dado su ID.
     *
     * @param id ID del canton a eliminar.
     * @throws Exception Si ocurre un error al ejecutar la eliminación en la base de
     *                   datos.
     */
    public void eliminarCanton(int id) throws Exception {
        String sql = "{CALL SP_EliminarCanton(?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    /**
     * Lista todos los cantones registrados en la base de datos.
     *
     * @return Lista de objetos Canton con los datos recuperados.
     * @throws Exception Si ocurre un error al ejecutar la consulta en la base de
     *                   datos.
     */
    public List<Canton> listarCantones() throws Exception {
        List<Canton> lista = new ArrayList<>();
        String sql = "SELECT * FROM FN_ListarCantones()";

        try (Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Canton c = new Canton();
                c.setId(rs.getInt("C_Canton"));
                c.setNombre(rs.getString("D_Canton"));
                c.setProvinciaId(rs.getInt("C_Provincia"));
                lista.add(c);
            }
        }

        return lista;
    }
}
