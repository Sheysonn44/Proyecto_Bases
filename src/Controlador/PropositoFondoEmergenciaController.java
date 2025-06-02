package Controlador;

import Modelo.PropositoFondoEmergencia;
import dao.PropositoFondoEmergenciaDAO;

/**
 * Controlador para manejar las operaciones relacionadas con los propósitos del
 * fondo de emergencia.
 * Utiliza PropositoFondoEmergenciaDAO para interactuar con la base de datos.
 * 
 * Permite insertar, editar, eliminar y visualizar propósitos.
 * 
 * @autor Jocelyn Abarca
 * @autor Adrian Chavarria
 * @autor Marcos Montero
 * @autor Jeison Alvarez
 *        01-06-2025 PropositoFondoEmergenciaController.java
 */
public class PropositoFondoEmergenciaController {

    /**
     * Método principal para gestionar las operaciones del propósito del fondo de
     * emergencia.
     * Inserta, edita, elimina y muestra los propósitos existentes en la base de
     * datos.
     */
    public void propositoFondoEmergencia() {
        PropositoFondoEmergenciaDAO dao = new PropositoFondoEmergenciaDAO();

        try {
            // Insertar un nuevo propósito
            PropositoFondoEmergencia nuevo = new PropositoFondoEmergencia("Emergencia Médica");
            dao.insertarProposito(nuevo);

            // Editar un propósito existente
            PropositoFondoEmergencia editar = new PropositoFondoEmergencia(1, "Emergencia Familiar");
            dao.editarProposito(editar);

            // Eliminar un propósito por ID
            dao.eliminarProposito(2);

            // Ver todos los propósitos registrados
            for (PropositoFondoEmergencia p : dao.verPropositos()) {
                System.out.println("ID: " + p.getcProposito() + " - " + p.getdProposito());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
