package dao;

import Modelo.Ahorro;
import db.Conexion;

import java.math.BigDecimal;
import java.sql.*;

public class AhorroDAO {

    // Insertar un ahorro
    public void insertarAhorro(Ahorro ahorro) throws Exception {
        String sql = "{call InsertarAhorro(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setString(1, ahorro.getMetaAhorro());
            cstmt.setDate(2, ahorro.getFechaInicio());
            cstmt.setDouble(3, ahorro.getMontoDeposito());
            cstmt.setDate(4, ahorro.getFechaDeposito());
            cstmt.setDouble(5, ahorro.getMontoObjetivo());
            cstmt.setDouble(6, ahorro.getMontoActual());
            cstmt.setDate(7, ahorro.getFechaFinal());
            cstmt.setString(8, ahorro.getDescripcion());
            cstmt.setInt(9, ahorro.getCuentaBancaria());
            cstmt.setInt(10, ahorro.getEstado());
            cstmt.setInt(11, ahorro.getMetodoPago());

            cstmt.execute();

            System.out.println("Ahorro insertado correctamente.");
        }
    }

    // Eliminar un ahorro por su ID
    public void eliminarAhorro(int cAhorro) throws Exception {
        String sql = "{call EliminarAhorro(?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, cAhorro);
            cstmt.executeUpdate();

            System.out.println("Ahorro eliminado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar ahorro: " + e.getMessage());
            throw e;
        }
    }

    // Editar un ahorro
    public void editarAhorro(Ahorro ahorro, int cAhorro) throws Exception {
        String sql = "{call EditarAhorro(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, cAhorro);
            cstmt.setString(2, ahorro.getMetaAhorro());
            cstmt.setDate(3, ahorro.getFechaInicio());
            cstmt.setDouble(4, ahorro.getMontoDeposito());
            cstmt.setDate(5, ahorro.getFechaDeposito());
            cstmt.setDouble(6, ahorro.getMontoObjetivo());
            cstmt.setDouble(7, ahorro.getMontoActual());
            cstmt.setDate(8, ahorro.getFechaFinal());
            cstmt.setString(9, ahorro.getDescripcion());
            cstmt.setInt(10, ahorro.getCuentaBancaria());
            cstmt.setInt(11, ahorro.getMetodoPago());

            cstmt.executeUpdate();

            System.out.println("Ahorro actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al editar ahorro: " + e.getMessage());
            throw e;
        }
    }

    // Mostrar ahorros
    public void mostrarAhorros() throws Exception {
        String sql = "SELECT C_Ahorro, D_Meta_Ahorro, F_Inicio, M_Monto_Deposito, F_Deposito, M_Objetivo, M_Actual, F_Final, D_Descripcion, C_Cuenta_Bancaria, C_Metodo_Pago FROM VistaAhorros";

        try (Connection conn = Conexion.getConexion();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int cAhorro = rs.getInt("C_Ahorro");
                String metaAhorro = rs.getString("D_Meta_Ahorro");
                Date fechaInicio = rs.getDate("F_Inicio");
                double montoDeposito = rs.getDouble("M_Monto_Deposito");
                Date fechaDeposito = rs.getDate("F_Deposito");
                double montoObjetivo = rs.getDouble("M_Objetivo");
                double montoActual = rs.getDouble("M_Actual");
                Date fechaFinal = rs.getDate("F_Final");
                String descripcion = rs.getString("D_Descripcion");
                int cuentaBancaria = rs.getInt("C_Cuenta_Bancaria");
                int metodoPago = rs.getInt("C_Metodo_Pago");

                System.out.printf(
                        "Ahorro ID: %d, Meta: %s, Inicio: %s, Depósito: %.2f, Fecha Depósito: %s, Objetivo: %.2f, Actual: %.2f, Final: %s, Descripción: %s, Cuenta Bancaria: %d, Método Pago: %d%n",
                        cAhorro, metaAhorro, fechaInicio, montoDeposito, fechaDeposito, montoObjetivo, montoActual,
                        fechaFinal, descripcion, cuentaBancaria, metodoPago);
            }
        }
    }

    public double obtenerSaldoCuenta(int cuentaBancaria) throws Exception {
        String sql = "SELECT M_Actual FROM Ahorros WHERE C_Cuenta_Bancaria = ?";
        try (Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cuentaBancaria);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("M_Actual");
            } else {
                throw new Exception("Cuenta bancaria no encontrada.");
            }
        }
    }

    public void rebajarAhorro(int cuentaBancaria, BigDecimal monto) throws Exception {
        String sql = "UPDATE Ahorros SET M_Actual = M_Actual - ? WHERE C_Cuenta_Bancaria = ?";
        try (Connection conn = Conexion.getConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBigDecimal(1, monto);
            stmt.setInt(2, cuentaBancaria);
            stmt.executeUpdate();
        }
    }

}
