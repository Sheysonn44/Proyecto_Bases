package Modelo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Clase que representa un pago en el sistema.
 * Contiene información sobre el monto, fecha, descripción, cuenta, método de
 * pago,
 * destinatario, categoría
 * de pago, tipo de transacción y tipo de moneda.
 * 
 * 1-06-2025 Clase Pago.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class Pago {
    private BigDecimal monto;
    private Date fechaPago;
    private String descripcion;
    private int cuentaId;
    private int metodoPagoId;
    private String destinatario;
    private int categoriaPagoId;
    private int tipoTransaccionId;
    private int tipoMonedaId;

    /**
     * Constructor de la clase Pago.
     *
     * @param monto             Monto del pago.
     * @param fechaPago         Fecha del pago.
     * @param descripcion       Descripción del pago.
     * @param cuentaId          ID de la cuenta asociada al pago.
     * @param metodoPagoId      ID del método de pago utilizado.
     * @param destinatario      Destinatario del pago.
     * @param categoriaPagoId   ID de la categoría del pago.
     * @param tipoTransaccionId ID del tipo de transacción.
     * @param tipoMonedaId      ID del tipo de moneda utilizada.
     */
    public Pago(BigDecimal monto, Date fechaPago, String descripcion, int cuentaId, int metodoPagoId,
            String destinatario, int categoriaPagoId, int tipoTransaccionId, int tipoMonedaId) {
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.descripcion = descripcion;
        this.cuentaId = cuentaId;
        this.metodoPagoId = metodoPagoId;
        this.destinatario = destinatario;
        this.categoriaPagoId = categoriaPagoId;
        this.tipoTransaccionId = tipoTransaccionId;
        this.tipoMonedaId = tipoMonedaId;
    }

    // Getters
    public BigDecimal getMonto() {
        return monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public int getMetodoPagoId() {
        return metodoPagoId;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public int getCategoriaPagoId() {
        return categoriaPagoId;
    }

    public int getTipoTransaccionId() {
        return tipoTransaccionId;
    }

    public int getTipoMonedaId() {
        return tipoMonedaId;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public void setMetodoPagoId(int metodoPagoId) {
        this.metodoPagoId = metodoPagoId;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setCategoriaPagoId(int categoriaPagoId) {
        this.categoriaPagoId = categoriaPagoId;
    }

    public void setTipoTransaccionId(int tipoTransaccionId) {
        this.tipoTransaccionId = tipoTransaccionId;
    }

    public void setTipoMonedaId(int tipoMonedaId) {
        this.tipoMonedaId = tipoMonedaId;
    }

}
