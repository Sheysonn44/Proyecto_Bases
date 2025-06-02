package Modelo;

/**
 * Clase que representa un Tipo de Moneda.
 * 1-06-2025 Clase TipoMoneda.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoMoneda {

    private int idTipoMoneda;
    private String simbolo;
    private String nombre;

    /**
     * Constructor para crear un objeto TipoMoneda con un ID, símbolo y nombre.
     */
    public TipoMoneda(String simbolo, String nombre) {
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    public TipoMoneda(int idTipoMoneda, String simbolo, String nombre) {
        this.idTipoMoneda = idTipoMoneda;
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    // Getters
    public int getIdTipoMoneda() {
        return idTipoMoneda;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    // Setters
    public void setIdTipoMoneda(int idTipoMoneda) {
        this.idTipoMoneda = idTipoMoneda;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
