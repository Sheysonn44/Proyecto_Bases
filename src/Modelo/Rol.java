package Modelo;

public class Rol {
    private int cRol;
    private String dRol;

    public Rol() {}

    public Rol(int cRol, String dRol) {
        this.cRol = cRol;
        this.dRol = dRol;
    }

    public int getcRol() {
        return cRol;
    }

    public void setcRol(int cRol) {
        this.cRol = cRol;
    }

    public String getdRol() {
        return dRol;
    }

    public void setdRol(String dRol) {
        this.dRol = dRol;
    }
}

