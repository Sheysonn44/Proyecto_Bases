package Controlador;

import Modelo.PropositoFondoEmergencia;
import dao.PropositoFondoEmergenciaDAO;

public class PropositoFondoEmergenciaController {

    public void propositoFondoEmergencia() {
        PropositoFondoEmergenciaDAO dao = new PropositoFondoEmergenciaDAO();

        try {
            // Insertar
            PropositoFondoEmergencia nuevo = new PropositoFondoEmergencia("Emergencia Médica");
            dao.insertarProposito(nuevo);

            // Editar
            PropositoFondoEmergencia editar = new PropositoFondoEmergencia(1, "Emergencia Familiar");
            dao.editarProposito(editar);

            // Eliminar
            dao.eliminarProposito(2);

            // Ver todos
            for (PropositoFondoEmergencia p : dao.verPropositos()) {
                System.out.println("ID: " + p.getcProposito() + " - " + p.getdProposito());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}