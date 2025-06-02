package Modelo;

/**
 * Clase Distrito representa un distrito con sus atributos y métodos.
 * Permite manejar la información relacionada con el distrito, incluyendo
 * su identificador, nombre y el identificador del cantón al que pertenece.
 * 1-06-2025 Clase Distrito.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */

public class Distrito {
    private int id;
    private String nombre;
    private int cantonId;

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

    public int getCantonId() {
        return cantonId;
    }

    public void setCantonId(int cantonId) {
        this.cantonId = cantonId;
    }
}
