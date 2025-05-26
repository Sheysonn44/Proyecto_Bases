package dao;

import java.sql.*;
import java.math.BigDecimal;
import db.Conexion;
import Modelo.*;
/*
 * * Clase para manejar las inversiones hipotecarias.
 * * Esta clase contiene un método para ejecutar un procedimiento almacenado
 * * que registra una inversión hipotecaria en la base de datos.
 * * El procedimiento almacenado se llama sp_RegistrarInversionHipotecaria
 * * y recibe varios parámetros relacionados con la inversión.
 */
public class InversionDAO {
    public void registrarInversion(Inversion i) throws Exception {
    Connection conn = Conexion.getConexion();

    CallableStatement cs = conn.prepareCall("{call sp_registrarInversionHipotecaria(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

    cs.setString(1, i.getNombre());
    cs.setString(2, i.getTipoInversion());
    cs.setBigDecimal(3, i.getMonto());
    cs.setBigDecimal(4, i.getRentabilidad());
    cs.setDate(5, i.getFechaInicio());
    cs.setString(6, i.getDescripcion());
    cs.setInt(7, i.getCuentaBancaria());
    cs.setInt(8, i.getEstado());
    cs.setInt(9, i.getTipoInversionId());
    cs.setInt(10, i.getCategoriaSalida());
    cs.setInt(11, i.getCategoriaIngreso());
    cs.setInt(12, i.getTipoMoneda());
    cs.setInt(13, i.getTipoMovimiento());
    cs.setInt(14, i.getTipoTransaccion());
    cs.execute();

    ResultSet rs = cs.getResultSet();
    if (rs != null && rs.next()) {
        System.out.println("📢 " + rs.getString("Mensaje"));
        rs.close();
    }

    cs.close();
    conn.close();
}

}

