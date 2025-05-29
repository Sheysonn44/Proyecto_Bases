package dao;



import Modelo.FondoEmergencia;
import db.Conexion;

import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase responsable de manejar las operaciones de acceso a datos
 * relacionadas con los fondos de emergencia.
 * Utiliza procedimientos almacenados para insertar, eliminar, editar y consultar datos.
 */
public class FondoEmergenciaDAO {

  
/**
     * Inserta un nuevo fondo de emergencia en la base de datos.
     *
     * @param fondo Objeto {@link Modelo.FondoEmergencia} con los datos a insertar.
     * @throws Exception Si ocurre un error al ejecutar el procedimiento almacenado.
     */
    public void insertarFondoEmergencia(FondoEmergencia fondo)
            throws Exception {

        String sql = "{call InsertarFondoEmergencia(?, ?, ?, ?, ?, ?, ?, ?)}";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        try (Connection conn = Conexion.getConexion();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setDouble(1, fondo.getMontoInicial());
            cstmt.setDouble(2, fondo.getMontoActual());
            cstmt.setDate(3, fondo.getFechaCreacion());
            cstmt.setString(4, fondo.getDescripcion());
            cstmt.setInt(5, fondo.getCuentaBancaria());
            cstmt.setInt(6, fondo.getEstado());
            cstmt.setInt(7, fondo.getProposito());
            cstmt.setInt(8, fondo.getTipoMoneda());

            cstmt.execute();
            System.out.println("Fondo de emergencia insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar fondo de emergencia: " + e.getMessage());
            throw e;
        }
    }

     /**
     * Elimina un fondo de emergencia según su ID.
     *
     * @param cFondoEmergencia ID del fondo de emergencia que se desea eliminar.
     * @throws Exception Si ocurre un error durante la eliminación.
     */

public void eliminarFondoEmergencia(int cFondoEmergencia) throws Exception {
        String sql = "{call EliminarFondoEmergencia(?)}";

        try (Connection conn = Conexion.getConexion();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, cFondoEmergencia);
            cstmt.executeUpdate();
            System.out.println("Fondo eliminado correctamente.");
        }
    }
 /**
     * Edita la información de un fondo de emergencia existente.
     *
     * @param fondo Objeto Modelo.FondoEmergencia} con los nuevos datos.
     * @param cFondoEmergencia ID del fondo que se desea actualizar.
     * @throws Exception Si ocurre un error al ejecutar el procedimiento almacenado.
     */
    public void editarFondoEmergencia(FondoEmergencia fondo, int cFondoEmergencia) throws Exception {
        String sql = "{call EditarFondoEmergencia(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = Conexion.getConexion();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, cFondoEmergencia);
            cstmt.setDouble(2, fondo.getMontoInicial());
            cstmt.setDouble(3, fondo.getMontoActual());
            cstmt.setDate(4, fondo.getFechaCreacion());
            cstmt.setString(5, fondo.getDescripcion());
            cstmt.setInt(6, fondo.getCuentaBancaria());
            cstmt.setInt(7, fondo.getEstado());
            cstmt.setInt(8, fondo.getProposito());

            cstmt.executeUpdate();
            System.out.println("Fondo actualizado correctamente.");
        }
    }
      /**
     * Muestra todos los fondos de emergencia consultando desde la vista VistaFondosEmergencia.
     *
     * @throws Exception Si ocurre un error al realizar la consulta SQL.
     */
    public void mostrarFondosEmergencia() throws Exception {
        String sql = "SELECT C_Fondo_Emergencia, M_Inicial, M_Actual, F_Creacion, D_Descripcion, C_Cuenta_Bancaria, C_Estado, C_Proposito FROM VistaFondosEmergencia";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("Listado de Fondos de Emergencia:");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("| %-5s | %-10s | %-10s | %-12s | %-30s | %-18s | %-8s | %-10s |\n",
                    "ID", "Monto Inicial", "Monto Actual", "Fecha Creación", "Descripción", "Cuenta Bancaria", "Estado", "Propósito");
            System.out.println("------------------------------------------------------------------------------------------");

            while (rs.next()) {
                int cFondo = rs.getInt("C_Fondo_Emergencia");
                double montoInicial = rs.getDouble("M_Inicial");
                double montoActual = rs.getDouble("M_Actual");
                Date fecha = rs.getDate("F_Creacion");
                String descripcion = rs.getString("D_Descripcion");
                int cuentaBancaria = rs.getInt("C_Cuenta_Bancaria");
                int estado = rs.getInt("C_Estado");
                int proposito = rs.getInt("C_Proposito");

                System.out.printf("| %-5d | %10.2f | %10.2f | %-12s | %-30s | %-18d | %-8d | %-10d |\n",
                        cFondo, montoInicial, montoActual, fecha.toString(), descripcion, cuentaBancaria, estado, proposito);
            }

            System.out.println("------------------------------------------------------------------------------------------");
        }
    }


   
}
