package Modelo;

/**
 * Clase Rol que representa un rol en el sistema.
 * Contiene un código de rol y una descripción del rol.
 * 
 * 1-06-2025 Clase Rol.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class Rol {
    private int cRol;
    private String dRol;

    public Rol() {
    }

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
