package Controlador;

import dao.InversionDAO;
import Modelo.Inversion;

import java.math.BigDecimal;
import java.time.LocalDate;
import dao.GastoDAO;
import Modelo.Gasto;
import java.util.Date;

/**
 * GastoController.java
 * Controlador para manejar las operaciones relacionadas con los gastos.
 * Este controlador utiliza GastoDAO para interactuar con la base de datos.
 */
public class GastoController {

    private GastoDAO dao = new GastoDAO();

    public void ejecutarEscenario() {
        
        Gasto gasto = new Gasto(
                500.0,
                new Date(), // hoy
                "Pago de Uber",
                1, // categoría transporte
                6, // id cuenta bancaria
                1 // método pago efectivo            
            );
        try {
            dao.insertarGasto(gasto);
        } catch (Exception e) {
            System.out.println(" Error en el escenario: " + e.getMessage());
        }

    }
}
