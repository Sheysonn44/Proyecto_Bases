package dao;

import Modelo.CuentaBancaria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancariaDAO {

    // INSERTAR cuenta bancaria
    public void insertarCuenta(CuentaBancaria cuenta, Connection conn) throws SQLException {
        String sql = "{call sp_Insertar_Cuentas_Bancarias(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, cuenta.getBanco());
            stmt.setString(2, cuenta.getNumeroCuenta());
            stmt.setBigDecimal(3, cuenta.getSaldoActual());
            stmt.setDate(4, cuenta.getFechaCreacion());
            stmt.setInt(5, cuenta.getUsuarioId());
            stmt.setInt(6, cuenta.getEstado());
            stmt.setInt(7, cuenta.getTipoCuenta());
            stmt.setInt(8, cuenta.getTipoMovimiento());
            stmt.setInt(9, cuenta.getTipoMoneda());
            stmt.executeUpdate();
        }
    }

    //  OBTENER todas las cuentas bancarias
    public List<CuentaBancaria> obtenerCuentas(Connection conn) throws SQLException {
        List<CuentaBancaria> cuentas = new ArrayList<>();
        String sql = "{call sp_Mostrar_Cuentas_Bancarias()}";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CuentaBancaria cuenta = new CuentaBancaria(
                    rs.getInt("C_Cuenta_Bancaria"),
                    rs.getString("D_Banco"),
                    rs.getString("D_Numero_Cuenta"),
                    rs.getBigDecimal("M_Saldo_Actual"),
                    rs.getDate("F_Creacion"),
                    rs.getInt("C_Usuario"),
                    rs.getInt("D_Estado"),
                    rs.getInt("T_Cuenta"),
                    rs.getInt("T_Movimiento"),
                    rs.getInt("C_TipoMoneda")
                );
                cuentas.add(cuenta);
            }
        }
        return cuentas;
    }

    //  ACTUALIZAR cuenta bancaria
    public void actualizarCuenta(CuentaBancaria cuenta, Connection conn) throws SQLException {
        String sql = "{call sp_Actualizar_cuenta_bancaria(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, cuenta.getIdCuenta());
            stmt.setString(2, cuenta.getBanco());
            stmt.setString(3, cuenta.getNumeroCuenta());
            stmt.setBigDecimal(4, cuenta.getSaldoActual());
            stmt.setDate(5, cuenta.getFechaCreacion());
            stmt.setInt(6, cuenta.getUsuarioId());
            stmt.setInt(7, cuenta.getEstado());
            stmt.setInt(8, cuenta.getTipoCuenta());
            stmt.setInt(9, cuenta.getTipoMovimiento());
            stmt.setInt(10, cuenta.getTipoMoneda());
            stmt.executeUpdate();
        }
    }

    //  ELIMINAR cuenta bancaria
    public void eliminarCuenta(int idCuenta, Connection conn) throws SQLException {
        String sql = "{call sp_Eliminar_cuenta_bancaria(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, idCuenta);
            stmt.executeUpdate();
        }
    }
}
