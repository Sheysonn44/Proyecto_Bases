package Modelo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Clase que representa una deuda.
 * Contiene información sobre el monto, tasas, fechas, acreedor, descripción,
 * categoría, cuenta bancaria, estado, tipo de interés, tipo de deuda,
 * tipo de transacción y tipo de moneda.
 * Además, incluye una lista de pagos asociados a la deuda.
 */
public class Deuda {
    private int id; 
    private BigDecimal monto;
    private BigDecimal tasaMensual;
    private BigDecimal tasaAnual;
    private Date fechaAdquirida;
    private Date fechaVencimiento;
    private int plazo;
    private String acreedor;
    private String descripcion;
    private int categoriaId;
    private int cuentaBancariaId;
    private int estadoId;
    private int tipoInteresId;
    private int tipoDeudaId;
    private int tipoTransaccion;
    private int tipoMoneda;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getTasaMensual() {
        return tasaMensual;
    }

    public void setTasaMensual(BigDecimal tasaMensual) {
        this.tasaMensual = tasaMensual;
    }

    public BigDecimal getTasaAnual() {
        return tasaAnual;
    }

    public void setTasaAnual(BigDecimal tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public Date getFechaAdquirida() {
        return fechaAdquirida;
    }

    public void setFechaAdquirida(Date fechaAdquirida) {
        this.fechaAdquirida = fechaAdquirida;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getAcreedor() {
        return acreedor;
    }

    public void setAcreedor(String acreedor) {
        this.acreedor = acreedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getCuentaBancariaId() {
        return cuentaBancariaId;
    }

    public void setCuentaBancariaId(int cuentaBancariaId) {
        this.cuentaBancariaId = cuentaBancariaId;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public int getTipoInteresId() {
        return tipoInteresId;
    }

    public void setTipoInteresId(int tipoInteresId) {
        this.tipoInteresId = tipoInteresId;
    }

    public int getTipoDeudaId() {
        return tipoDeudaId;
    }

    public void setTipoDeudaId(int tipoDeudaId) {
        this.tipoDeudaId = tipoDeudaId;
    }

    public int getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    private List<Pago> pagos;

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

}
