package Modelo;

/**
 * Clase que representa un propósito de fondo de emergencia.
 * Contiene un código y una descripción del propósito.
 * 
 * 1-06-2025 Clase PropositoFondoEmergencia.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class PropositoFondoEmergencia {
    private int cProposito;
    private String dProposito;

    /**
     * Constructor que inicializa el propósito de fondo de emergencia con un código
     * y una descripción.
     *
     * @param cProposito Código del propósito.
     * @param dProposito Descripción del propósito.
     */
    public PropositoFondoEmergencia(int cProposito, String dProposito) {
        this.cProposito = cProposito;
        this.dProposito = dProposito;
    }

    public PropositoFondoEmergencia(String dProposito) {
        this.dProposito = dProposito;
    }

    public PropositoFondoEmergencia() {
    }

    public int getcProposito() {
        return cProposito;
    }

    public void setcProposito(int cProposito) {
        this.cProposito = cProposito;
    }

    public String getdProposito() {
        return dProposito;
    }

    public void setdProposito(String dProposito) {
        this.dProposito = dProposito;
    }
}
