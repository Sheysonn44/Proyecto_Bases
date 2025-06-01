package dao;

import Modelo.Proyeccion;
import db.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ProyeccionDAO.java
 * 
 * Esta clase maneja las operaciones de base de datos relacionadas con las
 * proyecciones.
 * Permite insertar, editar, eliminar y consultar proyecciones.
 */
public class ProyeccionDAO {

    // Insertar proyección
    /**
     * Inserta una nueva proyección en la base de datos.
     * 
     * @param proyeccion La proyección a insertar.
     * @throws Exception Si ocurre un error al insertar la proyección.
     */
    public void insertarProyeccion(Proyeccion proyeccion) throws Exception {
        String sql = "{call InsertarProyeccion(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setDate(1, proyeccion.getfProyeccion());
            cstmt.setDouble(2, proyeccion.getmEstimado());
            cstmt.setInt(3, proyeccion.getqFrecuencia());
            cstmt.setInt(4, proyeccion.getcCuentaBancaria());
            cstmt.setInt(5, proyeccion.getcEstado());
            cstmt.setInt(6, proyeccion.getcTipoProyeccion());
            cstmt.setInt(7, proyeccion.getcTipoMoneda());

            cstmt.execute();
            System.out.println("Proyección insertada correctamente.");
        }
    }

    // Editar proyección
    /**
     * Actualiza una proyección existente en la base de datos.
     * 
     * @param proyeccion La proyección con los nuevos datos.
     * @throws Exception Si ocurre un error al editar la proyección.
     */
    public void editarProyeccion(Proyeccion proyeccion) throws Exception {
        String sql = "{call EditarProyeccion(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, proyeccion.getcProyeccion());
            cstmt.setDate(2, proyeccion.getfProyeccion());
            cstmt.setDouble(3, proyeccion.getmEstimado());
            cstmt.setInt(4, proyeccion.getqFrecuencia());
            cstmt.setInt(5, proyeccion.getcCuentaBancaria());
            cstmt.setInt(6, proyeccion.getcEstado());
            cstmt.setInt(7, proyeccion.getcTipoProyeccion());
            cstmt.setInt(8, proyeccion.getcTipoMoneda());

            cstmt.executeUpdate();
            System.out.println("Proyección actualizada correctamente.");
        }
    }

    // Eliminar proyección
    /**
     * Elimina una proyección de la base de datos.
     * 
     * @param cProyeccion El ID de la proyección a eliminar.
     * @throws Exception Si ocurre un error al eliminar la proyección.
     */
    public void eliminarProyeccion(int cProyeccion) throws Exception {
        String sql = "{call EliminarProyeccion(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, cProyeccion);
            cstmt.executeUpdate();
            System.out.println("Proyección eliminada correctamente.");
        }
    }

    // Ver todas las proyecciones
    /**
     * Recupera todas las proyecciones de la base de datos.
     * 
     * @return Una lista de proyecciones.
     * @throws Exception Si ocurre un error al recuperar las proyecciones.
     */
    public List<Proyeccion> verProyecciones() throws Exception {
        List<Proyeccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM VistaProyecciones"; 
        try (Connection conn = Conexion.getConexion();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Proyeccion p = new Proyeccion();
                p.setcProyeccion(rs.getInt("C_Proyeccion"));
                p.setfProyeccion(rs.getDate("F_Proyeccion"));
                p.setmEstimado(rs.getDouble("M_Estimado"));
                p.setqFrecuencia(rs.getInt("Q_Frecuencia"));
                p.setcCuentaBancaria(rs.getInt("C_Cuenta_Bancaria"));
                p.setcEstado(rs.getInt("C_Estado"));
                p.setcTipoProyeccion(rs.getInt("C_Tipo_Proyeccion"));
                p.setcTipoMoneda(rs.getInt("C_TipoMoneda"));

                lista.add(p);
            }
        }
        return lista;
    }
}
