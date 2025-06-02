package dao;

import Modelo.TipoProyeccion;
import db.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase TipoProyeccionDAO sirve para gestionar las operaciones relacionadas con
 * los tipos de proyeccion.
 * Proporciona métodos para insertar, eliminar, editar y mostrar tipos de
 * proyección.
 * 1-06-2025 Clase TipoProyeccionDAO*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */

public class TipoProyeccionDAO {

    /**
     * Inserta un nuevo tipo de proyección en la base de datos.
     *
     * @param tipo Objeto TipoProyeccion que contiene los datos a insertar.
     * @throws Exception Si ocurre un error al insertar el tipo de proyección.
     */
    public void insertarTipoProyeccion(TipoProyeccion tipo) throws Exception {
        String sql = "{call InsertarTipoProyeccion(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, tipo.getdTipoProyeccion());
            cstmt.execute();
            System.out.println("Tipo de proyección insertado correctamente.");
        }
    }

    /**
     * Edita un tipo de proyección existente.
     *
     * @param tipo Objeto TipoProyeccion con los datos actualizados.
     * @throws Exception Si ocurre un error al editar el tipo de proyección.
     */

    public void editarTipoProyeccion(TipoProyeccion tipo) throws Exception {
        String sql = "{call EditarTipoProyeccion(?, ?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, tipo.getcTipoProyeccion());
            cstmt.setString(2, tipo.getdTipoProyeccion());
            cstmt.executeUpdate();
            System.out.println("Tipo de proyección editado correctamente.");
        }
    }

    /**
     * Elimina un tipo de proyección por su ID.
     *
     * @param cTipoProyeccion ID del tipo de proyección a eliminar.
     * @throws Exception Si ocurre un error al eliminar el tipo de proyección.
     */
    public void eliminarTipoProyeccion(int cTipoProyeccion) throws Exception {
        String sql = "{call EliminarTipoProyeccion(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, cTipoProyeccion);
            cstmt.executeUpdate();
            System.out.println("Tipo de proyección eliminado correctamente.");
        }
    }

    /**
     * Recupera una lista de todos los tipos de proyección.
     *
     * @return Lista de objetos TipoProyeccion.
     * @throws Exception Si ocurre un error al recuperar los tipos de proyección.
     */
    public List<TipoProyeccion> verTiposProyeccion() throws Exception {
        List<TipoProyeccion> lista = new ArrayList<>();
        String sql = "{call VerTiposProyeccion()}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("C_Tipo_Proyeccion");
                String descripcion = rs.getString("D_Tipo_Proyeccion");
                lista.add(new TipoProyeccion(id, descripcion));
            }
        }
        return lista;
    }
}
