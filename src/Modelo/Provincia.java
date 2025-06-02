package Modelo;

/**
 * Clase Provincia representa una provincia con sus atributos y métodos.
 * Permite manejar la información relacionada con la provincia, incluyendo
 * su identificador y nombre.
 * 
 * 1-06-2025 Clase Provincia.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class Provincia {
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
