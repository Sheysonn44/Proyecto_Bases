package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.TipoInversion;
import db.Conexion;

/**
 * Clase TipoInversionDAO para manejar las operaciones de acceso a datos
 * relacionadas
 * con la entidad TipoInversion.
 * Permite insertar, actualizar, eliminar y listar tipos de inversión en la base
 * de datos.
 * * 1-06-2025 Clase TipoInversionDAO*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoInversionDAO {
    /**
     * Inserta un nuevo tipo de inversión en la base de datos.
     *
     * @param tipo Objeto TipoInversion con los datos a insertar.
     * @throws Exception Si ocurre un error al ejecutar la inserción en la base de
     *                   datos.
     */
    public void insertarTipoInversion(TipoInversion tipo) throws Exception {
        String sql = "{CALL SP_InsertarTipoInversion(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, tipo.getNombre());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza un tipo de inversión existente en la base de datos.
     *
     * @param id   ID del tipo de inversión a actualizar.
     * @param tipo Objeto TipoInversion con los nuevos datos.
     * 
     * @throws Exception Si ocurre un error al ejecutar la actualización en la base
     *                   de datos.
     */
    public void actualizarTipoInversion(int id, TipoInversion tipo) throws Exception {
        String sql = "{CALL SP_ActualizarTipoInversion(?, ?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, tipo.getNombre());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un tipo de inversión de la base de datos dado su ID.
     *
     * @param id ID del tipo de inversión a eliminar.
     * @throws Exception Si ocurre un error al ejecutar la eliminación en la base de
     *                   datos.
     * 
     */
    public void eliminarTipoInversion(int id) throws Exception {
        String sql = "{CALL SP_EliminarTipoInversion(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    /**
     * Lista todos los tipos de inversión disponibles en la base de datos.
     *
     * @return Lista de objetos TipoInversion con los datos recuperados.
     * @throws Exception Si ocurre un error al ejecutar la consulta en la base de
     *                   datos.
     * 
     */
    public List<TipoInversion> listarTiposInversion() throws Exception {
        List<TipoInversion> lista = new ArrayList<>();
        String sql = "SELECT * FROM FN_ListarTiposInversion()";
        try (Connection conn = Conexion.getConexion();

                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TipoInversion tipo = new TipoInversion();
                tipo.setId(rs.getInt("C_Tipo_Inversion"));
                tipo.setNombre(rs.getString("D_Tipo_Inversion"));
                lista.add(tipo);
            }
        }
        return lista;
    }
}
