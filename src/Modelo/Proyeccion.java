package Modelo;

import java.sql.Date;

/**
 * Clase que representa una proyección financiera.
 * Contiene información sobre la proyección, incluyendo su fecha, monto
 * estimado,
 * frecuencia, cuenta bancaria asociada, estado, tipo de proyección y tipo de
 * moneda.
 * 
 * 1-06-2025 Clase Proyeccion.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class Proyeccion {
    private int cProyeccion;
    private Date fProyeccion;
    private double mEstimado;
    private int qFrecuencia;
    private int cCuentaBancaria;
    private int cEstado;
    private int cTipoProyeccion;
    private int cTipoMoneda;

    public Proyeccion() {
    }

    /**
     * Constructor de la clase Proyeccion.
     *
     * @param cProyeccion     Código de la proyección.
     * @param fProyeccion     Fecha de la proyección.
     * @param mEstimado       Monto estimado de la proyección.
     * @param qFrecuencia     Frecuencia de la proyección.
     * @param cCuentaBancaria Código de la cuenta bancaria asociada.
     * @param cEstado         Código del estado de la proyección.
     * @param cTipoProyeccion Código del tipo de proyección.
     * @param cTipoMoneda     Código del tipo de moneda de la proyección.
     */
    public Proyeccion(int cProyeccion, Date fProyeccion, double mEstimado, int qFrecuencia,
            int cCuentaBancaria, int cEstado, int cTipoProyeccion, int cTipoMoneda) {
        this.cProyeccion = cProyeccion;
        this.fProyeccion = fProyeccion;
        this.mEstimado = mEstimado;
        this.qFrecuencia = qFrecuencia;
        this.cCuentaBancaria = cCuentaBancaria;
        this.cEstado = cEstado;
        this.cTipoProyeccion = cTipoProyeccion;
        this.cTipoMoneda = cTipoMoneda;
    }

    // Getters y Setters
    public int getcProyeccion() {
        return cProyeccion;
    }

    public void setcProyeccion(int cProyeccion) {
        this.cProyeccion = cProyeccion;
    }

    public Date getfProyeccion() {
        return fProyeccion;
    }

    public void setfProyeccion(Date fProyeccion) {
        this.fProyeccion = fProyeccion;
    }

    public double getmEstimado() {
        return mEstimado;
    }

    public void setmEstimado(double mEstimado) {
        this.mEstimado = mEstimado;
    }

    public int getqFrecuencia() {
        return qFrecuencia;
    }

    public void setqFrecuencia(int qFrecuencia) {
        this.qFrecuencia = qFrecuencia;
    }

    public int getcCuentaBancaria() {
        return cCuentaBancaria;
    }

    public void setcCuentaBancaria(int cCuentaBancaria) {
        this.cCuentaBancaria = cCuentaBancaria;
    }

    public int getcEstado() {
        return cEstado;
    }

    public void setcEstado(int cEstado) {
        this.cEstado = cEstado;
    }

    public int getcTipoProyeccion() {
        return cTipoProyeccion;
    }

    public void setcTipoProyeccion(int cTipoProyeccion) {
        this.cTipoProyeccion = cTipoProyeccion;
    }

    public int getcTipoMoneda() {
        return cTipoMoneda;
    }

    public void setcTipoMoneda(int cTipoMoneda) {
        this.cTipoMoneda = cTipoMoneda;
    }
}
