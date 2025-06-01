package Modelo;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que representa un ingreso en el sistema.
 * Contiene información sobre el usuario, cuenta bancaria, monto, fecha,
 * descripción, categoría, método de pago, tipo de moneda y destinatario.
 */
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
    private int ctipotran;
    private String dDestinatario;

    /**
     * Constructor de la clase Ingreso.
     *
     * @param cUsuario           ID del usuario que realiza el ingreso.
     * @param cCuentaBancaria    ID de la cuenta bancaria asociada al ingreso.
     * @param nombreCompleto     Nombre completo del usuario.
     * @param monto              Monto del ingreso.
     * @param fecha              Fecha del ingreso.
     * @param descripcionIngreso Descripción del ingreso.
     * @param categoria          Categoría del ingreso.
     * @param metodoPago         Método de pago utilizado para el ingreso.
     * @param cTipoMoneda        Código del tipo de moneda del ingreso.
     * @param dDestinatario      Destinatario del ingreso.
     * @param ctipotran          Tipo de transacción (ingreso o egreso).
     */
    public Ingreso(int cUsuario, int cCuentaBancaria, String nombreCompleto, double monto, Date fecha,
            String descripcionIngreso, int categoria, int metodoPago, int cTipoMoneda, String dDestinatario,
            int ctipotran) {
        this.cUsuario = cUsuario;
        this.cCuentaBancaria = cCuentaBancaria;
        this.nombreCompleto = nombreCompleto;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcionIngreso = descripcionIngreso;
        this.categoria = categoria;
        this.metodoPago = metodoPago;
        this.cTipoMoneda = cTipoMoneda;
        this.ctipotran = ctipotran;
        this.dDestinatario = dDestinatario;
    }

    public Ingreso() {
        // Default constructor
    }

    // Getters
    public int getcUsuario() {
        return cUsuario;
    }

    public int getcCuentaBancaria() {
        return cCuentaBancaria;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcionIngreso() {
        return descripcionIngreso;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getMetodoPago() {
        return metodoPago;
    }

    public int getCtipoMoneda() {
        return cTipoMoneda;
    }

    public int getCtipotran() {
        return ctipotran;
    }

    public String getdDestinatario() {
        return dDestinatario;
    }

    // Setters
    public void setcUsuario(int cUsuario) {
        this.cUsuario = cUsuario;
    }

    public void setcCuentaBancaria(int cCuentaBancaria) {
        this.cCuentaBancaria = cCuentaBancaria;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcionIngreso(String descripcionIngreso) {
        this.descripcionIngreso = descripcionIngreso;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setdSimbolo(int dSimbolo) {
        this.cTipoMoneda = cTipoMoneda;
    }

    public void setctipotran(int ctipotran) {
        this.ctipotran = ctipotran;
    }

    public void setdDestinatario(String dDestinatario) {
        this.dDestinatario = dDestinatario;
    }

}
