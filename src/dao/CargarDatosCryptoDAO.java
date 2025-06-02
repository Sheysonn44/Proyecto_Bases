
package dao;

import db.Conexion;
import Modelo.Crypto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * CargarDatosCryptoDAO.java
 * 
 * Esta clase se encarga de interactuar con la base de datos para insertar y
 * obtener
 * datos históricos de criptomonedas.
 * 1-06-2025 Clase CargarDatosCryptoDAO.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class CargarDatosCryptoDAO {

    // Insertar un nuevo precio histórico
    /**
     * Inserta un nuevo registro de precio histórico de una criptomoneda en la base
     * de datos.
     * 
     * @param crypto Objeto Crypto que contiene el símbolo, fecha y precio de
     *               cierre.
     * @throws Exception Si ocurre un error al insertar el registro.
     */
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

    // Obtener la última fecha registrada para una criptomoneda
    /**
     * Obtiene la última fecha registrada de precios históricos para una
     * criptomoneda específica.
     * 
     * @param symbol Símbolo de la criptomoneda.
     * @return La última fecha registrada, o null si no hay registros.
     * @throws Exception Si ocurre un error al consultar la base de datos.
     */
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
