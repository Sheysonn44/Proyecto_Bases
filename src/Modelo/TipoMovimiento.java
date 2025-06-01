package Modelo;

public class TipoMovimiento {
    private int cTipoMovimiento;
    private String dTipoMovimiento;

    public TipoMovimiento() {}

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