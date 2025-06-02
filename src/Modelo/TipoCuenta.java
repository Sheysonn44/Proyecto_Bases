package Modelo;

/**
 * Clase que representa un Tipo de Cuenta.
 * Esta clase contiene un identificador y una descripción del tipo de cuenta.
 * 1-06-2025 Clase TipoCuenta.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoCuenta {
    private int idTipoCuenta;
    private String descripcion;

    public TipoCuenta(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoCuenta(int idTipoCuenta, String descripcion) {
        this.idTipoCuenta = idTipoCuenta;
        this.descripcion = descripcion;
    }

    // Getters
    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
