
package dao;

import db.Conexion;
import Modelo.Crypto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CargarDatosCryptoDAO {

    // ✅ Insertar un nuevo precio histórico
    public void insertar(Crypto crypto) throws Exception {
        String sql = "INSERT INTO PrecioHistoricoCripto (D_Simbolo, F_Fecha, M_PrecioCierre) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, crypto.getSymbol());
            stmt.setDate(2, crypto.getDate());
            stmt.setBigDecimal(3, java.math.BigDecimal.valueOf(crypto.getClosePrice()));
            stmt.executeUpdate();
        }
    }

    // ✅ Obtener la última fecha registrada para una criptomoneda
    public Date obtenerUltimaFecha(String symbol) throws Exception {
        String sql = "SELECT MAX(F_Fecha) FROM PrecioHistoricoCripto WHERE D_Simbolo = ?";

        try (Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, symbol.toUpperCase());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDate(1);
            }
        }

        return null;
    }
}
