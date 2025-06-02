package Modelo;

/*
 * Clase que representa un tipo de deuda.
 * Contiene un código y una descripción del tipo de deuda.
 *   1-06-2025 Clase TipoDeuda.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoDeuda {
    private int cTipoDeuda;
    private String dTipoDeuda;

    public TipoDeuda() {
    }

    public TipoDeuda(int cTipoDeuda, String dTipoDeuda) {
        this.cTipoDeuda = cTipoDeuda;
        this.dTipoDeuda = dTipoDeuda;
    }

    public int getcTipoDeuda() {
        return cTipoDeuda;
    }

    public void setcTipoDeuda(int cTipoDeuda) {
        this.cTipoDeuda = cTipoDeuda;
    }

    public String getdTipoDeuda() {
        return dTipoDeuda;
    }

    public void setdTipoDeuda(String dTipoDeuda) {
        this.dTipoDeuda = dTipoDeuda;
    }
}