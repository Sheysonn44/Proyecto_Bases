package Controlador;

import Modelo.TipoInteres;
import dao.TipoInteresDAO;

public class TipoInteresController {

    public void tiposInteres() {

        TipoInteresDAO dao = new TipoInteresDAO();

        try {
            // Insertar
            TipoInteres nuevo = new TipoInteres("Interés Variable");
            dao.insertarTipoInteres(nuevo);

            // Editar
            TipoInteres editar = new TipoInteres(1, "Interés Fijo");
            dao.editarTipoInteres(editar);

            // Eliminar
            dao.eliminarTipoInteres(2);

            // Ver todos
            for (TipoInteres t : dao.verTiposInteres()) {
                System.out.println("ID: " + t.getcTipoInteres() + " - " + t.getdTipoInteres());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
