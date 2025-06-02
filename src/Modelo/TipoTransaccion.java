package Modelo;

/**@author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 *         28-06-2025
 * Representa un tipo de transacción.
 */
public class TipoTransaccion {
    private int id;
    private String descripcion;

    public TipoTransaccion() {
    }

    // Constructor
    public TipoTransaccion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public TipoTransaccion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
