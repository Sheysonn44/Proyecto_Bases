package Modelo;

import java.sql.Date;

/**
 * Representa un registro de precio de cierre de una criptomoneda en una fecha
 * específica.
 * 
 * Esta clase se puede usar para almacenar o transferir información sobre
 * valores históricos
 * de criptomonedas (por ejemplo, BTC) relacionados a una fecha concreta.
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 
 *         1-06-2025 Clase Crypto.java*
 */
public class Crypto {

    private String symbol;
    private Date date;
    private double closePrice;

    /**
     * Constructor con parámetros.
     * 
     * @param symbol     símbolo o identificador de la criptomoneda (ej. "BTC").
     * @param date       fecha del registro de precio.
     * @param closePrice precio de cierre en esa fecha.
     */
    public Crypto(String symbol, Date date, double closePrice) {
        this.symbol = symbol;
        this.date = date;
        this.closePrice = closePrice;
    }

    /**
     * Constructor por defecto.
     */
    public Crypto() {
        // Constructor vacío
    }

    /**
     * Obtiene el símbolo de la criptomoneda.
     * 
     * @return símbolo (ej. "BTC").
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Establece el símbolo de la criptomoneda.
     * 
     * @param symbol símbolo a establecer.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Obtiene la fecha del registro.
     * 
     * @return fecha de la cotización.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Establece la fecha del registro.
     * 
     * @param date fecha a establecer.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Obtiene el precio de cierre de la criptomoneda.
     * 
     * @return precio de cierre.
     */
    public double getClosePrice() {
        return closePrice;
    }

    /**
     * Establece el precio de cierre de la criptomoneda.
     * 
     * @param closePrice precio de cierre a establecer.
     */
    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }
}
