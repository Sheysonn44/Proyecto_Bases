package Modelo;

import java.math.BigDecimal;
import java.util.Date;

public class MovimientoInversion {
    private int id;
    private BigDecimal monto;
    private Date fecha;
    private int inversionId;
    private int tipoMoneda;
    private int tipoMovimiento;

    public MovimientoInversion(int id, BigDecimal monto, Date fecha, int inversionId, int tipoMoneda,
            int tipoMovimiento) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.inversionId = inversionId;
        this.tipoMoneda = tipoMoneda;
        this.tipoMovimiento = tipoMovimiento;
    }
    public MovimientoInversion() {
        // Constructor por defecto
    }
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getInversionId() {
        return inversionId;
    }

    public void setInversionId(int inversionId) {
        this.inversionId = inversionId;
    }

    public int getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

}
