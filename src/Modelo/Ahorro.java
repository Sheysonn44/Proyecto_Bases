package Modelo;

import java.sql.Date;

/**
 * Clase que representa un ahorro con sus atributos y métodos.
 * 1-06-2025 Clase Ahorro.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */

public class Ahorro {

    private String metaAhorro;
    private Date fechaInicio;
    private double montoDeposito;
    private Date fechaDeposito;
    private double montoObjetivo;
    private double montoActual;
    private Date fechaFinal;
    private String descripcion;
    private int cuentaBancaria;
    private int estado;
    private int metodoPago;
    private int cTipoMoneda;

    /**
     * Constructor de la clase Ahorro.
     *
     * @param metaAhorro     Descripción de la meta de ahorro.
     * @param fechaInicio    Fecha de inicio del ahorro.
     * @param montoDeposito  Monto del depósito inicial.
     * @param fechaDeposito  Fecha del depósito inicial.
     * @param montoObjetivo  Monto objetivo del ahorro.
     * @param montoActual    Monto actual ahorrado.
     * @param fechaFinal     Fecha final para alcanzar el objetivo.
     * @param descripcion    Descripción adicional del ahorro.
     * @param cuentaBancaria ID de la cuenta bancaria asociada.
     * @param estado         Estado del ahorro (activo, inactivo, etc.).
     * @param metodoPago     Método de pago utilizado para el ahorro.
     * @param cTipoMoneda    Tipo de moneda utilizada en el ahorro.
     */
    public Ahorro(String metaAhorro, Date fechaInicio, double montoDeposito, Date fechaDeposito,
            double montoObjetivo, double montoActual, Date fechaFinal, String descripcion,
            int cuentaBancaria, int estado, int metodoPago, int cTipoMoneda) {
        this.metaAhorro = metaAhorro;
        this.fechaInicio = fechaInicio;
        this.montoDeposito = montoDeposito;
        this.fechaDeposito = fechaDeposito;
        this.montoObjetivo = montoObjetivo;
        this.montoActual = montoActual;
        this.fechaFinal = fechaFinal;
        this.descripcion = descripcion;
        this.cuentaBancaria = cuentaBancaria;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.cTipoMoneda = cTipoMoneda;
    }

    // Getters
    public String getMetaAhorro() {
        return metaAhorro;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public double getMontoDeposito() {
        return montoDeposito;
    }

    public Date getFechaDeposito() {
        return fechaDeposito;
    }

    public double getMontoObjetivo() {
        return montoObjetivo;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public Date getFechaFinal() {
        return fechaFinal;
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

    public int getMetodoPago() {
        return metodoPago;
    }

    public int getTipoMoneda() {
        return cTipoMoneda;
    }

    // Setters
    public void setMetaAhorro(String metaAhorro) {
        this.metaAhorro = metaAhorro;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setMontoDeposito(double montoDeposito) {
        this.montoDeposito = montoDeposito;
    }

    public void setFechaDeposito(Date fechaDeposito) {
        this.fechaDeposito = fechaDeposito;
    }

    public void setMontoObjetivo(double montoObjetivo) {
        this.montoObjetivo = montoObjetivo;
    }

    public void setMontoActual(double montoActual) {
        this.montoActual = montoActual;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
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

    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setTipoMoneda(int cTipoMoneda) {
        this.cTipoMoneda = cTipoMoneda;
    }
}
