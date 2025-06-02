package Controlador;

import dao.InversionDAO;
import db.Conexion;
import Modelo.Inversion;
import dao.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Controlador para manejar las operaciones relacionadas con las inversiones.
 * Este controlador utiliza InversionDAO para interactuar con la base de datos.
 *
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 *         28-06-2025 InversionController.java
 */

public class InversionController {
    /* Atributo para acceder a la capa de datos */
    private InversionDAO dao = new InversionDAO();

    /**
     * Método para ejecutar el escenario de prueba.
     * Crea una inversión hipotecaria y registra los ingresos mensuales.
     * 
     * @throws Exception
     */
    public void escenario4() throws Exception {

        Inversion inversion = new Inversion();
        inversion.setNombre("Prueba final "); // Nombre de la inversión
        inversion.setTipoInversion("Hipotecaria"); // Tipo de inversión
        inversion.setMonto(new BigDecimal("10.00")); // Monto de la inversión
        inversion.setRentabilidad(new BigDecimal("0.12")); // Rentabilidad 12% anual
        inversion.setFechaInicio(new java.sql.Date(System.currentTimeMillis())); // Fecha de inicio (hoy)
        inversion.setDescripcion("Inversión"); // Descripción de la inversión
        inversion.setCuentaBancaria(6); // Cuenta bancaria asociada
        inversion.setEstado(1); // Estado
        inversion.setTipoInversionId(1);
        inversion.setCategoriaIngreso(2);
        inversion.setCategoriaSalida(3); // Tipo de inversión
        inversion.setTipoMoneda(1); // Tipo de moneda
        inversion.setTipoTransaccion(2); // Tipo de transacción (Egreso)

        try {
            // Registrar la inversión hipotecaria
            dao.registrarInversionHipotecaria(inversion);
        } catch (Exception e) {
            System.out.println("Error al registrar la inversión: " + e.getMessage());
            e.printStackTrace();

        }

    }
}
