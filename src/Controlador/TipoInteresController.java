package Controlador;

import Modelo.TipoInteres;
import dao.TipoInteresDAO;

/**
 * Controlador para manejar las operaciones relacionadas con los tipos de
 * interés.
 * Utiliza TipoInteresDAO para insertar, editar, eliminar y visualizar los tipos
 * de interés.
 * 
 * Este controlador es útil para gestionar la descripción de los distintos tipos
 * de interés
 * que pueden ser utilizados en inversiones o préstamos.
 * 
 * @autor Jocelyn Abarca
 * @autor Adrian Chavarria
 * @autor Marcos Montero
 * @autor Jeison Alvarez
 *        01-06-2025 TipoInteresController.java
 */
public class TipoInteresController {

    /**
     * Método principal para gestionar las operaciones sobre tipos de interés.
     * Inserta un nuevo tipo, edita uno existente, elimina otro por ID
     * y muestra todos los tipos de interés registrados.
     */
    public void tiposInteres() {

        TipoInteresDAO dao = new TipoInteresDAO();

        try {
            // Insertar un nuevo tipo de interés
            TipoInteres nuevo = new TipoInteres("Interés Variable");
            dao.insertarTipoInteres(nuevo);

            // Editar un tipo de interés existente
            TipoInteres editar = new TipoInteres(1, "Interés Fijo");
            dao.editarTipoInteres(editar);

            // Eliminar un tipo de interés por ID
            dao.eliminarTipoInteres(2);

            // Ver todos los tipos de interés registrados
            for (TipoInteres t : dao.verTiposInteres()) {
                System.out.println("ID: " + t.getcTipoInteres() + " - " + t.getdTipoInteres());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
