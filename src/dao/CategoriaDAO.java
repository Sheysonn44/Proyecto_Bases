package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Categoria;
import db.Conexion;
/**
 * Clase CategoriaDAO para manejar las operaciones de acceso a datos relacionadas
 * con la entidad Categoria.
 * Permite insertar, actualizar, eliminar y listar categorías en la base de datos.
 */
public class CategoriaDAO {
    /**
     * Inserta una nueva categoría en la base de datos.
     *
     * @param categoria Objeto Categoria con los datos a insertar.
     * @throws Exception Si ocurre un error al ejecutar la inserción en la base de datos.
     */
    public void insertarCategoria(Categoria categoria) throws Exception {
        String sql = "{CALL SP_InsertarCategoria(?)}";
        try (Connection conn = Conexion.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, categoria.getNombre());
            stmt.executeUpdate();
        }
    }
    /**
     * Actualiza una categoría existente en la base de datos.
     *
     * @param id       ID de la categoría a actualizar.
     * @param categoria Objeto Categoria con los nuevos datos.
     * @throws Exception Si ocurre un error al ejecutar la actualización en la base de datos.
     */
    public void actualizarCategoria(int id, Categoria categoria) throws Exception {
        String sql = "{CALL SP_ActualizarCategoria(?, ?)}";
        try (Connection conn = Conexion.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, categoria.getNombre());
            stmt.executeUpdate();
        }
    }
    /**
     * Elimina una categoría de la base de datos dado su ID.
     *
     * @param id ID de la categoría a eliminar.
     * @throws Exception Si ocurre un error al ejecutar la eliminación en la base de datos.
     */
    public void eliminarCategoria(int id) throws Exception {
        String sql = "{CALL SP_EliminarCategoria(?)}";
        try (Connection conn = Conexion.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    /**
     * Lista todas las categorías disponibles en la base de datos.
     *
     * @return Lista de objetos Categoria.
     * @throws Exception Si ocurre un error al ejecutar la consulta en la base de datos.
     */
    public List<Categoria> listarCategorias() throws Exception {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM FN_ListarCategorias()";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("C_Categoria"));
                c.setNombre(rs.getString("D_Nombre"));
                lista.add(c);
            }
        }
        return lista;
    }
}
