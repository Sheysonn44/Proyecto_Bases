package Modelo;

import java.sql.Date;

/**
 * Clase que representa un fondo de emergencia.
 * Contiene información sobre el monto inicial, monto actual, fecha de creación,
 * descripción, cuenta bancaria asociada, estado, propósito y tipo de moneda.
 * 
 * 1-06-2025 Clase FondoEmergencia.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class FondoEmergencia {

    private double montoInicial;
    private double montoActual;
    private Date fechaCreacion;
    private String descripcion;
    private int cuentaBancaria;
    private int estado;
    private int proposito;
    private int cTipoMoneda;

    /**
     * Constructor de la clase FondoEmergencia.
     *
     * @param montoInicial   Monto inicial del fondo de emergencia.
     * @param montoActual    Monto actual del fondo de emergencia.
     * @param fechaCreacion  Fecha de creación del fondo de emergencia.
     * @param descripcion    Descripción del fondo de emergencia.
     * @param cuentaBancaria Cuenta bancaria asociada al fondo de emergencia.
     * @param estado         Estado del fondo de emergencia.
     * @param proposito      Propósito del fondo de emergencia.
     * @param cTipoMoneda    Tipo de moneda del fondo de emergencia.
     */
    public FondoEmergencia(double montoInicial, double montoActual, Date fechaCreacion,
            String descripcion, int cuentaBancaria, int estado, int proposito, int cTipoMoneda) {
        this.montoInicial = montoInicial;
        this.montoActual = montoActual;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
        this.cuentaBancaria = cuentaBancaria;
        this.estado = estado;
        this.proposito = proposito;
        this.cTipoMoneda = cTipoMoneda;
    }

    // Getters
    public double getMontoInicial() {
        return montoInicial;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCuentaBancaria() {
        return cuentaBancaria;
    }

    public int getEstado() {
        return estado;
    }

    public int getProposito() {
        return proposito;
    }

    public int getTipoMoneda() {
        return cTipoMoneda;
    }

    // Setters
    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public void setMontoActual(double montoActual) {
        this.montoActual = montoActual;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCuentaBancaria(int cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setProposito(int proposito) {
        this.proposito = proposito;
    }

    public void setTipoMoneda(int cTipoMoneda) {
        this.cTipoMoneda = cTipoMoneda;
    }
}
