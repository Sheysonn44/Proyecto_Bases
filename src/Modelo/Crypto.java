package Modelo;

import java.sql.Date;

public class Crypto {

    private String symbol;
    private Date date;
    private double closePrice;

    // Constructor
    public Crypto(String symbol, Date date, double closePrice) {
        this.symbol = symbol;
        this.date = date;
        this.closePrice = closePrice;
    }

    public Crypto() {
        // Default constructor
    }

    // Getters
    public String getSymbol() {
        return symbol;
    }

    public Date getDate() {
        return date;
    }

    public double getClosePrice() {
        return closePrice;
    }

    // Setters
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }
}