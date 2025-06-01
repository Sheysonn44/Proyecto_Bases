package Modelo;

import java.math.BigDecimal;
import java.sql.Date;

public class CuentaBancaria {
    private int idCuenta;
    private String banco;
    private String numeroCuenta;
    private BigDecimal saldoActual;
    private Date fechaCreacion;
    private int usuarioId;
    private int estado;
    private int tipoCuenta;
    private int tipoMovimiento;
    private int tipoMoneda;

    // Constructor sin ID (para insertar)
    public CuentaBancaria(String banco, String numeroCuenta, BigDecimal saldoActual, Date fechaCreacion,
                          int usuarioId, int estado, int tipoCuenta, int tipoMovimiento, int tipoMoneda) {
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.saldoActual = saldoActual;
        this.fechaCreacion = fechaCreacion;
        this.usuarioId = usuarioId;
        this.estado = estado;
        this.tipoCuenta = tipoCuenta;
        this.tipoMovimiento = tipoMovimiento;
        this.tipoMoneda = tipoMoneda;
    }

    // Constructor con ID (para obtener/actualizar)
    public CuentaBancaria(int idCuenta, String banco, String numeroCuenta, BigDecimal saldoActual, Date fechaCreacion,
                          int usuarioId, int estado, int tipoCuenta, int tipoMovimiento, int tipoMoneda) {
        this(banco, numeroCuenta, saldoActual, fechaCreacion, usuarioId, estado, tipoCuenta, tipoMovimiento, tipoMoneda);
        this.idCuenta = idCuenta;
    }

    // Getters y Setters
    public int getIdCuenta() { return idCuenta; }
    public void setIdCuenta(int idCuenta) { this.idCuenta = idCuenta; }

    public String getBanco() { return banco; }
    public void setBanco(String banco) { this.banco = banco; }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public BigDecimal getSaldoActual() { return saldoActual; }
    public void setSaldoActual(BigDecimal saldoActual) { this.saldoActual = saldoActual; }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public int getEstado() { return estado; }
    public void setEstado(int estado) { this.estado = estado; }

    public int getTipoCuenta() { return tipoCuenta; }
    public void setTipoCuenta(int tipoCuenta) { this.tipoCuenta = tipoCuenta; }

    public int getTipoMovimiento() { return tipoMovimiento; }
    public void setTipoMovimiento(int tipoMovimiento) { this.tipoMovimiento = tipoMovimiento; }

    public int getTipoMoneda() { return tipoMoneda; }
    public void setTipoMoneda(int tipoMoneda) { this.tipoMoneda = tipoMoneda; }
}

