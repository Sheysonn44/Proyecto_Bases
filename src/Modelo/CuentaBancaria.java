package Modelo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Representa una cuenta bancaria en el sistema financiero personal.
 * Contiene información como el banco, número de cuenta, saldo, fecha de
 * creación,
 * y diferentes atributos relacionados al estado, tipo de cuenta, tipo de
 * movimiento y moneda.
 * 
 * Esta clase se utiliza para insertar, consultar o actualizar cuentas bancarias
 * en la base de datos del usuario.
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 
 *         1-06-2025 Clase CuentaBancaria.java*
 */
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

    /**
     * Constructor sin ID, útil para insertar una nueva cuenta en la base de datos.
     * 
     * @param banco          nombre del banco.
     * @param numeroCuenta   número de cuenta bancaria.
     * @param saldoActual    saldo actual en la cuenta.
     * @param fechaCreacion  fecha de creación de la cuenta.
     * @param usuarioId      identificador del usuario propietario.
     * @param estado         estado de la cuenta (ej. activa, inactiva).
     * @param tipoCuenta     tipo de cuenta (ej. ahorro, corriente).
     * @param tipoMovimiento tipo de movimiento asociado.
     * @param tipoMoneda     tipo de moneda (ej. colones, dólares, BTC).
     */
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

    /**
     * Constructor con ID, útil para consultas o actualizaciones.
     * 
     * @param idCuenta       identificador único de la cuenta.
     * @param banco          nombre del banco.
     * @param numeroCuenta   número de cuenta bancaria.
     * @param saldoActual    saldo actual.
     * @param fechaCreacion  fecha de creación.
     * @param usuarioId      identificador del usuario.
     * @param estado         estado de la cuenta.
     * @param tipoCuenta     tipo de cuenta.
     * @param tipoMovimiento tipo de movimiento.
     * @param tipoMoneda     tipo de moneda.
     */
    public CuentaBancaria(int idCuenta, String banco, String numeroCuenta, BigDecimal saldoActual, Date fechaCreacion,
            int usuarioId, int estado, int tipoCuenta, int tipoMovimiento, int tipoMoneda) {
        this(banco, numeroCuenta, saldoActual, fechaCreacion, usuarioId, estado, tipoCuenta, tipoMovimiento,
                tipoMoneda);
        this.idCuenta = idCuenta;
    }

    // Getters y Setters (sin documentación)

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }
}
