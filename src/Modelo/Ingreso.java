package Modelo;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ingreso {

    private int cUsuario;
    private int cCuentaBancaria;
    private String nombreCompleto;
    private double monto;
    private Date fecha;
    private String descripcionIngreso;
    private int categoria;
    private int metodoPago;
    private int cTipoMoneda;
    private String dDestinatario;

    // Constructor
    public Ingreso(int cUsuario, int cCuentaBancaria, String nombreCompleto, double monto, Date fecha, 
                   String descripcionIngreso, int categoria, int metodoPago, int cTipoMoneda, String dDestinatario) {
        this.cUsuario = cUsuario;
        this.cCuentaBancaria = cCuentaBancaria;
        this.nombreCompleto = nombreCompleto;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcionIngreso = descripcionIngreso;
        this.categoria = categoria;
        this.metodoPago = metodoPago;
        this.cTipoMoneda = cTipoMoneda;
        this.dDestinatario = dDestinatario;
    }
    public Ingreso() {
        // Default constructor
    }

    // Getters
    public int getcUsuario() { return cUsuario; }
    public int getcCuentaBancaria() { return cCuentaBancaria; }
    public String getNombreCompleto() { return nombreCompleto; }
    public double getMonto() { return monto; }
    public Date getFecha() { return fecha; }
    public String getDescripcionIngreso() { return descripcionIngreso; }
    public int getCategoria() { return categoria; }
    public int getMetodoPago() { return metodoPago; }
    public int getCtipoMoneda() { return cTipoMoneda; }
    public String getdDestinatario() { return dDestinatario; }

       // Setters
    public void setcUsuario(int cUsuario) { this.cUsuario = cUsuario; }
    public void setcCuentaBancaria(int cCuentaBancaria) { this.cCuentaBancaria = cCuentaBancaria; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public void setMonto(double monto) { this.monto = monto; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public void setDescripcionIngreso(String descripcionIngreso) { this.descripcionIngreso = descripcionIngreso; }
    public void setCategoria(int categoria) { this.categoria = categoria; }
    public void setMetodoPago(int metodoPago) { this.metodoPago = metodoPago; }
    public void setdSimbolo(int dSimbolo) { this.cTipoMoneda = cTipoMoneda; }
    public void setdDestinatario(String dDestinatario) { this.dDestinatario = dDestinatario; }

}
