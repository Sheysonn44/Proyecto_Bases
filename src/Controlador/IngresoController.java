package Controlador;

import dao.IngresoDAO;
import Modelo.Ingreso;

import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 28-08-2025 IngresoController.java
 * Controlador para manejar las operaciones relacionadas con los ingresos.
 * Este controlador utiliza IngresoDAO para interactuar con la base de datos.
 */
public class IngresoController {
    /* Atributo para acceder a la capa de datos */
    private IngresoDAO dao = new IngresoDAO();


    /**
     * Método para ejecutar el escenario de prueba.
     * Crea un objeto Ingreso y lo inserta en la base de datos.
     */

    public void ejecutarEscenario() {
        double monto = ThreadLocalRandom.current().nextDouble(6000, 15001);
        monto = Math.round(monto * 100.0) / 100.0;
        /* Crear un objeto Ingreso con datos de ejemplo */


        Ingreso ingreso = new Ingreso(
                1,                                      // Usuario
                3,                               // CuentaBancaria
                "federica lopez",                 // NombreCompleto
                monto,                                           // Monto
                Date.valueOf("2025-05-26"),                    // Fecha actual
                "Pago freelance",             // DescripcionIngreso
                2,                                     // Categoria
                1,                                    // MetodoPago
                1,                                   // Moneda
               " Cliente XYZ",                     // Destinatario
                1                                      // Tipo transaccion      
        );

        /* Escenario de prueba para la clase Ingreso */ 

        try {
            dao.insertarIngreso(ingreso);
            System.out.println("Ingreso insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error en el escenario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
