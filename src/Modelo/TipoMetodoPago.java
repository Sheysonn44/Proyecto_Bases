package Modelo;

/**
 * Clase que representa un tipo de interés.
 * Contiene un código y una descripción del tipo de interés.
 * 1-06-2025 Clase TipoMetodoPago.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoMetodoPago {
    private int cMetodoPago;
    private String dMetodoPago;

    public TipoMetodoPago() {
    }

    /**
     * Constructor de la clase TipoMetodoPago.
     *
     * @param cMetodoPago Código del método de pago.
     * @param dMetodoPago Descripción del método de pago.
     */
    public TipoMetodoPago(int cMetodoPago, String dMetodoPago) {
        this.cMetodoPago = cMetodoPago;
        this.dMetodoPago = dMetodoPago;
    }

    public TipoMetodoPago(String dMetodoPago) {
        this.dMetodoPago = dMetodoPago;
    }

    public int getcMetodoPago() {
        return cMetodoPago;
    }

    public void setcMetodoPago(int cMetodoPago) {
        this.cMetodoPago = cMetodoPago;
    }

    public String getdMetodoPago() {
        return dMetodoPago;
    }

    public void setdMetodoPago(String dMetodoPago) {
        this.dMetodoPago = dMetodoPago;
    }
}
