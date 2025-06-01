package Modelo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Clase que representa un pago en el sistema.
 * Contiene información sobre el monto, fecha, descripción, cuenta, método de
 * pago,
 * destinatario, categoría, estado, tipo de moneda, tipo de movimiento y tipo de
 * transacción.
 */
public class Inversion {
    private String nombre;
    private String tipoInversion;
    private BigDecimal monto;
    private BigDecimal rentabilidad;
    private Date fechaInicio;
    private String descripcion;
    private int cuentaBancaria;
    private int estado;
    private int tipoInversionId;
    private int categoriaSalida;
    private int categoriaIngreso;
    private int tipoMoneda;
    private int tipoMovimiento;
    private int tipoTransaccion;

    // Constructor completo
    /**
     * Constructor de la clase Inversion.
     *
     * @param nombre           Nombre de la inversión.
     * @param tipoInversion    Tipo de inversión.
     * @param monto            Monto de la inversión.
     * @param rentabilidad     Rentabilidad de la inversión.
     * @param fechaInicio      Fecha de inicio de la inversión.
     * @param descripcion      Descripción de la inversión.
     * @param cuentaBancaria   ID de la cuenta bancaria asociada.
     * @param estado           Estado de la inversión (activo, inactivo, etc.).
     * @param tipoInversionId  ID del tipo de inversión.
     * @param categoriaSalida  ID de la categoría de salida asociada.
     * @param categoriaIngreso ID de la categoría de ingreso asociada.
     * @param tipoMoneda       ID del tipo de moneda utilizada.
     * @param tipoMovimiento   ID del tipo de movimiento (ingreso, egreso).
     * @param tipoTransaccion  ID del tipo de transacción (compra, venta, etc.).
     */
    public Inversion(String nombre, String tipoInversion, BigDecimal monto, BigDecimal rentabilidad,
            Date fechaInicio, String descripcion, int cuentaBancaria, int estado,
            int tipoInversionId, int categoriaSalida, int categoriaIngreso,
            int tipoMoneda, int tipoMovimiento, int tipoTransaccion) {
        this.nombre = nombre;
        this.tipoInversion = tipoInversion;
        this.monto = monto;
        this.rentabilidad = rentabilidad;
        this.fechaInicio = fechaInicio;
        this.descripcion = descripcion;
        this.cuentaBancaria = cuentaBancaria;
        this.estado = estado;
        this.tipoInversionId = tipoInversionId;
        this.categoriaSalida = categoriaSalida;
        this.categoriaIngreso = categoriaIngreso;
        this.tipoMoneda = tipoMoneda;
        this.tipoMovimiento = tipoMovimiento;
        this.tipoTransaccion = tipoTransaccion;
    }

    public Inversion() {
        // Constructor por defecto
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipoInversion() {
        return tipoInversion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public BigDecimal getRentabilidad() {
        return rentabilidad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
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

    public int getTipoInversionId() {
        return tipoInversionId;
    }

    public int getCategoriaSalida() {
        return categoriaSalida;
    }

    public int getCategoriaIngreso() {
        return categoriaIngreso;
    }

    public int getTipoMoneda() {
        return tipoMoneda;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public int getTipoTransaccion() {
        return tipoTransaccion;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoInversion(String tipoInversion) {
        this.tipoInversion = tipoInversion;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public void setRentabilidad(BigDecimal rentabilidad) {
        this.rentabilidad = rentabilidad;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
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

    public void setTipoInversionId(int tipoInversionId) {
        this.tipoInversionId = tipoInversionId;
    }

    public void setCategoriaSalida(int categoriaSalida) {
        this.categoriaSalida = categoriaSalida;
    }

    public void setCategoriaIngreso(int categoriaIngreso) {
        this.categoriaIngreso = categoriaIngreso;
    }

    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public void setTipoTransaccion(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
}
