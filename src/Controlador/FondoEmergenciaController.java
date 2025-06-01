package Controlador;

import Modelo.FondoEmergencia;
import dao.FondoEmergenciaDAO;

import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 28-08-2025 FondoEmergenciaController.java
 * Controlador para manejar las operaciones relacionadas con los fondos de emergencia.
 * Este controlador utiliza FondoEmergenciaDAO para interactuar con la base de datos.
 */

public class FondoEmergenciaController {

    /* Atributo para acceder a la capa de datos */
    private FondoEmergenciaDAO dao = new FondoEmergenciaDAO();

    /**
     * Método para ejecutar el escenario de prueba.
     * Crea un objeto FondoEmergencia y lo inserta en la base de datos.
     */
    public void ejecutarEscenario() {
      
        /*Generar un monto inicial y actual aleatorio entre 5000 y 10000 */ 
        FondoEmergencia fondo = new FondoEmergencia(
                
                7000,                         // Monto inicial
                7000,                          // Monto actual (igual al inicial)
                Date.valueOf("2025-01-01"),              // Fecha de creación
                "Fondo para hospital ",     // Descripción
                3,                          // Cuenta bancaria
                1,                                  // Estado (activo)
                2,                             // Propósito (salud)
                1                                
        );      



         /* Escenario de prueba para la clase FondoEmergencia */
        try {
            dao.insertarFondoEmergencia(fondo);
            System.out.println("Fondo de emergencia insertado correctamente.");
        } catch (Exception e) {
            System.err.println("Error en el escenario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

