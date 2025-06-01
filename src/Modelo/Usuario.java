package Modelo;

public class Usuario {
    private int cUsuario;
    private String dNombre;
    private String dApellido1;
    private String dApellido2;
    private String dCorreo;
    private String dContrasena;
    private int cRol;
    private int cProvincia;
    private int cCanton;
    private int cDistrito;

    public Usuario() {}

    public Usuario(int cUsuario, String dNombre, String dApellido1, String dApellido2, String dCorreo,
                   String dContrasena, int cRol, int cProvincia, int cCanton, int cDistrito) {
        this.cUsuario = cUsuario;
        this.dNombre = dNombre;
        this.dApellido1 = dApellido1;
        this.dApellido2 = dApellido2;
        this.dCorreo = dCorreo;
        this.dContrasena = dContrasena;
        this.cRol = cRol;
        this.cProvincia = cProvincia;
        this.cCanton = cCanton;
        this.cDistrito = cDistrito;
    }

    public int getcUsuario() {
        return cUsuario;
    }

    public String getdNombre() {
        return dNombre;
    }

    public String getdApellido1() {
        return dApellido1;
    }

    public String getdApellido2() {
        return dApellido2;
    }

    public String getdCorreo() {
        return dCorreo;
    }

    public String getdContrasena() {
        return dContrasena;
    }

    public int getcRol() {
        return cRol;
    }

    public int getcProvincia() {
        return cProvincia;
    }

    public int getcCanton() {
        return cCanton;
    }

    public int getcDistrito() {
        return cDistrito;
    }

    public void setcUsuario(int cUsuario) {
        this.cUsuario = cUsuario;
    }

    public void setdNombre(String dNombre) {
        this.dNombre = dNombre;
    }

    public void setdApellido1(String dApellido1) {
        this.dApellido1 = dApellido1;
    }

    public void setdApellido2(String dApellido2) {
        this.dApellido2 = dApellido2;
    }

    public void setdCorreo(String dCorreo) {
        this.dCorreo = dCorreo;
    }

    public void setdContrasena(String dContrasena) {
        this.dContrasena = dContrasena;
    }

    public void setcRol(int cRol) {
        this.cRol = cRol;
    }

    public void setcProvincia(int cProvincia) {
        this.cProvincia = cProvincia;
    }

    public void setcCanton(int cCanton) {
        this.cCanton = cCanton;
    }

    public void setcDistrito(int cDistrito) {
        this.cDistrito = cDistrito;
    }


}