package Modelo;

/**
 * Clase TipoInversion representa un tipo de inversión con sus atributos y métodos.
 * Permite manejar la información relacionada con el tipo de inversión, incluyendo
 * su identificador y nombre.
 */
public class TipoInversion {
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

