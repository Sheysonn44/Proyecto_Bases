package Modelo;

/*
 * Clase que representa un tipo de deuda.
 * Contiene un código y una descripción del tipo de deuda.
 *  1-06-2025 Clase TipoMovimiento.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoMovimiento {
    private int cTipoMovimiento;
    private String dTipoMovimiento;

    public TipoMovimiento() {
    }

    /**
     * Constructor de la clase TipoMovimiento.
     * 
     * @param cTipoMovimiento Código del tipo de movimiento.
     * @param dTipoMovimiento Descripción del tipo de movimiento.
     */
    public TipoMovimiento(int cTipoMovimiento, String dTipoMovimiento) {
        this.cTipoMovimiento = cTipoMovimiento;
        this.dTipoMovimiento = dTipoMovimiento;
    }

    public int getcTipoMovimiento() {
        return cTipoMovimiento;
    }

    public void setcTipoMovimiento(int cTipoMovimiento) {
        this.cTipoMovimiento = cTipoMovimiento;
    }

    public String getdTipoMovimiento() {
        return dTipoMovimiento;
    }

    public void setdTipoMovimiento(String dTipoMovimiento) {
        this.dTipoMovimiento = dTipoMovimiento;
    }
}