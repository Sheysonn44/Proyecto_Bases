package dao;

import Modelo.Ahorro;
import db.Conexion;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Clase AhorroDao sirve para gestionar las operaciones relacionadas con los
 * ahorros.
 * Proporciona métodos para insertar, eliminar, editar, mostrar ahorros y
 * manipular su saldo.
 * 
 * 1-06-2025 Clase AhorroDAO.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class AhorroDAO {

    /**
     * Inserta un nuevo ahorro en la base de datos mediante un procedimiento
     * almacenado.
     *
     * @param ahorro Objeto Ahorro que contiene la información a insertar.
     * @throws Exception Si ocurre un error durante la conexión o ejecución.
     */
    public void insertarAhorro(Ahorro ahorro) throws Exception {
        String sql = "{call InsertarAhorro(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

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
            cstmt.setInt(12, ahorro.getTipoMoneda());

            cstmt.execute();

            System.out.println("Ahorro insertado correctamente.");
        }
    }

    /**
     * Elimina un ahorro específico por su ID utilizando un procedimiento
     * almacenado.
     *
     * @param cAhorro ID del ahorro a eliminar.
     * @throws Exception Si ocurre un error durante la operación.
     */
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

    /**
     * Edita un ahorro existente mediante un procedimiento almacenado.
     *
     * @param ahorro  Objeto Ahorro con los nuevos datos.
     * @param cAhorro ID del ahorro que se desea actualizar.
     * @throws Exception Si ocurre un error en la operación.
     */
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

    /**
     * Muestra todos los ahorros registrados consultando una vista en la base de
     * datos.
     *
     * @throws Exception Si ocurre un error al obtener los datos.
     */
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

    /**
     * Obtiene el saldo actual (M_Actual) del ahorro vinculado a una cuenta
     * bancaria.
     *
     * @param cuentaBancaria ID de la cuenta bancaria asociada.
     * @return Saldo actual del ahorro.
     * @throws Exception Si la cuenta no existe o ocurre un error en la consulta.
     */
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

    /**
     * Resta un monto especifico al saldo actual de una cuenta bancaria.
     *
     * @param cuentaBancaria ID de la cuenta bancaria a modificar.
     * @param monto          Monto a restar del ahorro.
     * @throws Exception Si ocurre un error durante la actualizacion.
     */
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
