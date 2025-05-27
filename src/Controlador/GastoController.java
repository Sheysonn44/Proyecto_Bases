package Controlador;

import dao.GastoDAO;
import Modelo.Gasto;

import java.util.Date;
import java.util.Random;
import java.util.Calendar;

public class GastoController {

    public void ejecutarEscenario() {

        // Primer gasto - Persona 1
        Gasto gasto1 = crearGasto(
                50.0,
                "Pago de Uber",
                1, // categoría transporte
                3, // cuenta bancaria
                1, // método pago
                1, // tipo moneda
                "Uber Costa Rica",
                2 // tipo transacción

        );

        // Segundo gasto - Persona 2
        Gasto gasto2 = crearGasto(
                100.0,
                "Compra en supermercado",
                2, // categoría alimentación
                4, // cuenta bancaria diferente
                2, // tarjeta
                1, // tipo moneda
                "AutoMercado",
                2 // tipo transacción

        );

        // Insertar los gastos
        GastoDAO.insertarGasto(gasto1);
        GastoDAO.insertarGasto(gasto2);
    }

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
        Date fechaAleatoria = generarFechaAleatoriaAbril();
        

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

    private Date generarFechaAleatoriaAbril() {
        Calendar cal = Calendar.getInstance();
        Random rand = new Random();

        cal.set(Calendar.YEAR, 2025);
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.DAY_OF_MONTH, 1 + rand.nextInt(30)); // Abril tiene 30 días

        return cal.getTime();
    }
}

