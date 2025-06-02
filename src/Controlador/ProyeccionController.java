package Controlador;

import Modelo.Proyeccion;
import dao.ProyeccionDAO;

/**
 * Controlador para manejar las operaciones relacionadas con proyecciones
 * financieras.
 * Utiliza ProyeccionDAO para insertar, editar, eliminar y mostrar proyecciones.
 * 
 * Cada proyección incluye una fecha, monto estimado, número de meses y varias
 * relaciones clave.
 * 
 * @autor Jocelyn Abarca
 * @autor Adrian Chavarria
 * @autor Marcos Montero
 * @autor Jeison Alvarez
 *        01-06-2025 ProyeccionController.java
 */
public class ProyeccionController {

    /**
     * Método principal para gestionar las operaciones sobre proyecciones.
     * Permite insertar una nueva proyección, editar una existente, eliminar una por
     * ID,
     * y visualizar todas las proyecciones almacenadas.
     */
    public void proyeccion() {

        ProyeccionDAO dao = new ProyeccionDAO();

        try {
            // Insertar una nueva proyección
            Proyeccion nueva = new Proyeccion(
                    0,
                    java.sql.Date.valueOf("2025-12-31"),
                    10000.00,
                    12,
                    1,
                    1,
                    1,
                    1);
            dao.insertarProyeccion(nueva);

            // Editar una proyección existente
            Proyeccion editar = new Proyeccion(
                    1,
                    java.sql.Date.valueOf("2025-11-30"),
                    12000.00,
                    10,
                    1,
                    1,
                    1,
                    1);
            dao.editarProyeccion(editar);

            // Eliminar una proyección por ID
            dao.eliminarProyeccion(2);

            // Mostrar todas las proyecciones
            for (Proyeccion p : dao.verProyecciones()) {
                System.out.println("ID: " + p.getcProyeccion() +
                        ", Fecha: " + p.getfProyeccion() +
                        ", Estimado: " + p.getmEstimado());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
