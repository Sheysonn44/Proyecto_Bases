package Controlador;

import Modelo.Proyeccion;
import dao.ProyeccionDAO;

public class ProyeccionController {
    public void proyeccion() {

        ProyeccionDAO dao = new ProyeccionDAO();

        try {
            // Insertar
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

            // Editar
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

            // Eliminar
            dao.eliminarProyeccion(2);

            // Ver todas
            for (Proyeccion p : dao.verProyecciones()) {
                System.out.println("ID: " + p.getcProyeccion() + ", Fecha: " + p.getfProyeccion() + ", Estimado: "
                        + p.getmEstimado());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
