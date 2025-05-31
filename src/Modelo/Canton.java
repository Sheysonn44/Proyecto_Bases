package Modelo;

    
/**
 * Clase Canton representa un cantón con sus atributos y métodos.
 * Permite manejar la información relacionada con el cantón, incluyendo
 * su identificador, nombre y el identificador de la provincia a la que pertenece.
 */
public class Canton {
    private int id;
    private String nombre;
    private int provinciaId;

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

    public int getProvinciaId() {
        return provinciaId;
    }
    public void setProvinciaId(int provinciaId) {
        this.provinciaId = provinciaId;
    }
}

