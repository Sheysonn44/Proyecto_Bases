package Modelo;

/**
 * Clase que representa un tipo de interés.
 * Contiene un código y una descripción del tipo de interés.
 * 1-06-2025 Clase TipoProyeccion.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoProyeccion {
    private int cTipoProyeccion;
    private String dTipoProyeccion;

    public TipoProyeccion() {
    }

    /**
     * Constructor de la clase TipoProyeccion.
     *
     * @param cTipoProyeccion Código del tipo de proyección.
     * @param dTipoProyeccion Descripción del tipo de proyección.
     */
    public TipoProyeccion(int cTipoProyeccion, String dTipoProyeccion) {
        this.cTipoProyeccion = cTipoProyeccion;
        this.dTipoProyeccion = dTipoProyeccion;
    }

    public TipoProyeccion(String dTipoProyeccion) {
        this.dTipoProyeccion = dTipoProyeccion;
    }

    public int getcTipoProyeccion() {
        return cTipoProyeccion;
    }

    public void setcTipoProyeccion(int cTipoProyeccion) {
        this.cTipoProyeccion = cTipoProyeccion;
    }

    public String getdTipoProyeccion() {
        return dTipoProyeccion;
    }

    public void setdTipoProyeccion(String dTipoProyeccion) {
        this.dTipoProyeccion = dTipoProyeccion;
    }
}
