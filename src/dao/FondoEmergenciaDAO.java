package dao;



import Modelo.FondoEmergencia;
import db.Conexion;

import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FondoEmergenciaDAO {

  

    public void insertarFondoEmergencia(FondoEmergencia fondo)
            throws Exception {

        String sql = "{call InsertarFondoEmergencia(?, ?, ?, ?, ?, ?, ?)}";

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

            cstmt.execute();
            System.out.println("Fondo de emergencia insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar fondo de emergencia: " + e.getMessage());
            throw e;
        }
    }

   
}
