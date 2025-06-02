
package Controlador;

import dao.TipoMetodoPagoDAO;
import Modelo.TipoMetodoPago;

/**
 * 
 * 
 * Controlador para manejar las operaciones relacionadas con los tipos
 * de métodos de pago.
 * 
 * 1-06-2025 Clase TipoMetodoPagoController.java*
 * 
 * @author Jocelyn Abarca*
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 
 */
class TipoMetodoPagoController {
    public void TipoMetodoPago() {

        TipoMetodoPagoDAO dao = new TipoMetodoPagoDAO();

        try {
            // Insertar
            TipoMetodoPago nuevo = new TipoMetodoPago("Tarjeta Crédito");
            dao.insertarTipoMetodoPago(nuevo);

            // Editar
            TipoMetodoPago editar = new TipoMetodoPago(1, "Tarjeta Débito");
            dao.editarTipoMetodoPago(editar);

            // Eliminar
            dao.eliminarTipoMetodoPago(2);

            // Ver todos
            for (TipoMetodoPago t : dao.verTiposMetodoPago()) {
                System.out.println("ID: " + t.getcMetodoPago() + " - " + t.getdMetodoPago());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}