package dao;

import Modelo.TipoInteres;
import db.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para manejar las operaciones CRUD de TipoInteres.
 */
public class TipoInteresDAO {
    // insertar
    /**
     * Inserta un nuevo tipo de interés en la base de datos.
     *
     * @param tipo Objeto TipoInteres a insertar.
     * @throws Exception Si ocurre un error al insertar el tipo de interés.
     */
    public void insertarTipoInteres(TipoInteres tipo) throws Exception {
        String sql = "{call InsertarTipoInteres(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, tipo.getdTipoInteres());
            cstmt.execute();
            System.out.println("Tipo de interés insertado correctamente.");
        }
    }

    // Editar
    /**
     * Edita un tipo de interés existente en la base de datos.
     *
     * @param tipo Objeto TipoInteres con los datos actualizados.
     * @throws Exception Si ocurre un error al editar el tipo de interés.
     */
    public void editarTipoInteres(TipoInteres tipo) throws Exception {
        String sql = "{call EditarTipoInteres(?, ?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, tipo.getcTipoInteres());
            cstmt.setString(2, tipo.getdTipoInteres());
            cstmt.executeUpdate();
            System.out.println("Tipo de interés editado correctamente.");
        }
    }

    // Eliminar
    /**
     * Elimina un tipo de interés de la base de datos.
     *
     * @param cTipoInteres ID del tipo de interés a eliminar.
     * @throws Exception Si ocurre un error al eliminar el tipo de interés.
     */
    public void eliminarTipoInteres(int cTipoInteres) throws Exception {
        String sql = "{call EliminarTipoInteres(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, cTipoInteres);
            cstmt.executeUpdate();
            System.out.println("Tipo de interés eliminado correctamente.");
        }
    }

    // verTiposInteres
    /**
     * Recupera una lista de todos los tipos de interés desde la base de datos.
     *
     * @return Lista de objetos TipoInteres.
     * @throws Exception Si ocurre un error al recuperar los tipos de interés.
     */
    public List<TipoInteres> verTiposInteres() throws Exception {
        List<TipoInteres> lista = new ArrayList<>();
        String sql = "{call VerTiposInteres()}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("C_Tipo_Interes");
                String descripcion = rs.getString("D_Tipo_Interes");
                lista.add(new TipoInteres(id, descripcion));
            }
        }
        return lista;
    }
}
