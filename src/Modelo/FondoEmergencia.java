package Modelo;

import java.sql.Date;

public class FondoEmergencia {

    private double montoInicial;
    private double montoActual;
    private Date fechaCreacion;
    private String descripcion;
    private int cuentaBancaria;
    private int estado;
    private int proposito;

    // Constructor completo (sin ID, ya que se genera en BD)
    public FondoEmergencia(double montoInicial, double montoActual, Date fechaCreacion,
                           String descripcion, int cuentaBancaria, int estado, int proposito) {
        this.montoInicial = montoInicial;
        this.montoActual = montoActual;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
        this.cuentaBancaria = cuentaBancaria;
        this.estado = estado;
        this.proposito = proposito;
    }

    // Constructor vacío
    public FondoEmergencia() {
    }

    // Getters
    public double getMontoInicial() { return montoInicial;}
    public double getMontoActual() {  return montoActual;}     
    public Date getFechaCreacion() {   return fechaCreacion; }
     

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
}
