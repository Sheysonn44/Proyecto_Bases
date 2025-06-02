package Modelo;

/*
 * Clase que representa un tipo de deuda.
 * Contiene un código y una descripción del tipo de deuda.
 *  1-06-2025 Clase TiposEstado.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TiposEstado {
    private int cEstado;
    private String dEstado;

    public TiposEstado() {
    }

    public TiposEstado(int cEstado, String dEstado) {
        this.cEstado = cEstado;
        this.dEstado = dEstado;
    }

    public int getCEstado() {
        return cEstado;
    }

    public void setCEstado(int cEstado) {
        this.cEstado = cEstado;
    }

    public String getDEstado() {
        return dEstado;
    }

    public void setDEstado(String dEstado) {
        this.dEstado = dEstado;
    }
}