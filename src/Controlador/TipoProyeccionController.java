package Controlador;

import Modelo.TipoProyeccion;
import dao.TipoProyeccionDAO;

/**
 * Controlador para manejar las operaciones relacionadas con los tipos de
 * proyección.
 * Utiliza TipoProyeccionDAO para insertar, editar, eliminar y visualizar los
 * tipos de proyección financiera.
 * 
 * Este controlador permite gestionar clasificaciones como proyecciones
 * mensuales, anuales, etc.,
 * que son útiles en la planificación financiera del sistema.
 * 
 * @autor Jocelyn Abarca
 * @autor Adrian Chavarria
 * @autor Marcos Montero
 * @autor Jeison Alvarez
 *        01-06-2025 TipoProyeccionController.java
 */
public class TipoProyeccionController {

    // Instancia del DAO para acceder a la base de datos
    TipoProyeccionDAO tipoP = new TipoProyeccionDAO();

    /**
     * Método principal que ejecuta operaciones de prueba sobre los tipos de
     * proyección:
     * inserción, edición, eliminación y visualización.
     */
    public void TipoProyeccion() {
        try {
            // Insertar un nuevo tipo de proyección
            TipoProyeccion nuevo = new TipoProyeccion("Proyección Mensual");
            tipoP.insertarTipoProyeccion(nuevo);

            // Editar un tipo de proyección existente
            TipoProyeccion editar = new TipoProyeccion(1, "Proyección Anual");
            tipoP.editarTipoProyeccion(editar);

            // Eliminar un tipo de proyección por ID
            tipoP.eliminarTipoProyeccion(2);

            // Ver todos los tipos de proyección registrados
            for (TipoProyeccion t : tipoP.verTiposProyeccion()) {
                System.out.println("ID: " + t.getcTipoProyeccion() + " - " + t.getdTipoProyeccion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
