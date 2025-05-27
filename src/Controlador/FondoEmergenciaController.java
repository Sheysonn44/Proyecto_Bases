package Controlador;

import Modelo.FondoEmergencia;
import dao.FondoEmergenciaDAO;

import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

public class FondoEmergenciaController {

    private FondoEmergenciaDAO dao = new FondoEmergenciaDAO();

    public void ejecutarEscenario() {
      

        FondoEmergencia fondo = new FondoEmergencia(
                
                7000,
                7000, 
                Date.valueOf("2025-01-01"),
                "Fondo para emergencias ",
                3, // Cuenta bancaria
                1, // Estado (activo)
                2  // Propósito (salud)
        );

        try {
            dao.insertarFondoEmergencia(fondo);
            System.out.println("Fondo de emergencia insertado correctamente.");
        } catch (Exception e) {
            System.err.println("Error en el escenario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

