package Modelo;

/**
 * Clase que representa un tipo de interés.
 * Contiene un código y una descripción del tipo de interés.
 * 1-06-2025 Clase TipoInteres.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoInteres {
    private int cTipoInteres;
    private String dTipoInteres;

    public TipoInteres() {
    }

    /**
     * Constructor de la clase TipoInteres.
     *
     * @param cTipoInteres Código del tipo de interés.
     * @param dTipoInteres Descripción del tipo de interés.
     */
    public TipoInteres(int cTipoInteres, String dTipoInteres) {
        this.cTipoInteres = cTipoInteres;
        this.dTipoInteres = dTipoInteres;
    }

    public TipoInteres(String dTipoInteres) {
        this.dTipoInteres = dTipoInteres;
    }

    public int getcTipoInteres() {
        return cTipoInteres;
    }

    public void setcTipoInteres(int cTipoInteres) {
        this.cTipoInteres = cTipoInteres;
    }

    public String getdTipoInteres() {
        return dTipoInteres;
    }

    public void setdTipoInteres(String dTipoInteres) {
        this.dTipoInteres = dTipoInteres;
    }
}
