package Modelo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase que representa un movimiento de inversión.
 * Contiene información sobre el monto, fecha, tipo de moneda y tipo de
 * movimiento.
 * 
 * 1-06-2025 Clase MovimientoInversion.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class MovimientoInversion {
    private int id;
    private BigDecimal monto;
    private Date fecha;
    private int inversionId;
    private int tipoMoneda;
    private int tipoMovimiento;

    /**
     * Constructor de la clase MovimientoInversion.
     *
     * @param id             Identificador del movimiento.
     * @param monto          Monto del movimiento.
     * @param fecha          Fecha del movimiento.
     * @param inversionId    Identificador de la inversión asociada.
     * @param tipoMoneda     Tipo de moneda del movimiento.
     * @param tipoMovimiento Tipo de movimiento (ingreso o egreso).
     */

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
