package Controlador;

import Modelo.TipoProyeccion;
import dao.TipoProyeccionDAO;

public class TipoProyeccionController {

    TipoProyeccionDAO tipoP = new TipoProyeccionDAO();

    public void TipoProyeccion() {
        try {
            // Insertar
            TipoProyeccion nuevo = new TipoProyeccion("Proyección Mensual");
            tipoP.insertarTipoProyeccion(nuevo);

            // Editar
            TipoProyeccion editar = new TipoProyeccion(1, "Proyección Anual");
            tipoP.editarTipoProyeccion(editar);

            // Eliminar
            tipoP.eliminarTipoProyeccion(2);

            // Ver todos
            for (TipoProyeccion t : tipoP.verTiposProyeccion()) {
                System.out.println("ID: " + t.getcTipoProyeccion() + " - " + t.getdTipoProyeccion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
