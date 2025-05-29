package Controlador;

import dao.GastoDAO;
import Modelo.Gasto;

import java.util.Date;
import java.util.Random;
import java.util.Calendar;



/**
 * 
 *
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 28-08-2025  GastoController.java
 * Controlador para manejar las operaciones relacionadas con los gastos.
 * Este controlador utiliza GastoDAO para interactuar con la base de datos.
 */


public class GastoController {


    /* Atributo para acceder a la capa de datos */
    public void ejecutarEscenario() {

        // Primer gasto - Persona 1
        Gasto gasto1 = crearGasto(
                50.0,                          // Monto    
                "Pago de Uber",          // Descripción
                1,                         // Categoría transporte
                3,                    // Cuenta bancaria
                1,                        // Método pago
                1,                        // Tipo moneda
                "Uber Costa Rica",      // Destinatario
                2                    // Tipo transacción

        );

        // Segundo gasto - Persona 2
        Gasto gasto2 = crearGasto(
                100.0,                               // Monto
                "Compra en supermercado",      // Descripción
                2,                               // Categoría alimentación
                4,                          // Cuenta bancaria diferente
                2,                              // Tarjeta
                1,                              // Tipo moneda
                "AutoMercado",                // Destinatario
                2                          // Tipo transacción

        );

        // Insertar los gastos
        GastoDAO.insertarGasto(gasto1);
        GastoDAO.insertarGasto(gasto2);
    }

    /* Método para crear un gasto */
    private Gasto crearGasto(
            double monto,
            String descripcion,
            int categoria,
            int cuentaBancaria,
            int metodoPago,
            int tipoMoneda,
            String destinatario,
            int tipoTransaccion
         
    ) {

        /* Generar fecha aleatoria en abril de 2025 */
        Date fechaAleatoria = generarFechaAleatoriaAbril();

        /* Crear el objeto Gasto */
        return new Gasto(
                monto,
                fechaAleatoria,
                descripcion,
                categoria,
                cuentaBancaria,
                metodoPago,
                tipoMoneda,
                destinatario,
                tipoTransaccion
            
        );
    }
 
    /**
     * Genera una fecha aleatoria en abril de 2025.
     *
     * @return Fecha aleatoria en abril de 2025.
     */
    private Date generarFechaAleatoriaAbril() {
        Calendar cal = Calendar.getInstance();
        Random rand = new Random();

        cal.set(Calendar.YEAR, 2025);
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.DAY_OF_MONTH, 1 + rand.nextInt(30)); // Abril tiene 30 días

        return cal.getTime();
    }
}

