package Controlador;

import Modelo.Ahorro;
import dao.AhorroDAO;

import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 28-08-2025 Clase AhorroController.java
 * Controlador para manejar las operaciones relacionadas con los ahorros.
 * Este controlador utiliza AhorroDAO para interactuar con la base de datos.
 */

public class AhorroController {
    /* Atributo para acceder a la capa de datos */
    private AhorroDAO dao = new AhorroDAO();

    /* Método para ejecutar el escenario de prueba */
    
    public void ejecutarEscenario() {

        /* Escenario de prueba para la clase Ahorro */
        
        Ahorro ahorro = new Ahorro(
                "Hospital ",      // MetaAhorro
                Date.valueOf("2025-01-01"),           // FechaInicio
                6000,                     // MontoDeposito
                Date.valueOf("2025-01-15"),           // FechaDeposito
                20000.00,                 // MontoObjetivo
                6000,                       // MontoActual (igual al depósito inicial)
                Date.valueOf("2025-12-31"),           // FechaFinal
                "Ahorro para hospital",   // Descripcion
                3,                       //CuentaBancaria
                1,                               //Estado (activo)
                2,                                 // MetodoPago
                1                            
        );

        /* Escenario de prueba para la clase Ahorro */
        try {
            dao.insertarAhorro(ahorro);
            System.out.println("Ahorro insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error en el escenario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}