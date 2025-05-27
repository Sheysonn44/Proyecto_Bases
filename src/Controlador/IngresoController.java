package Controlador;

import dao.IngresoDAO;
import Modelo.Ingreso;

import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * IngresoController.java
 * Controlador para manejar las operaciones relacionadas con los ingresos.
 * Este controlador utiliza IngresoDAO para interactuar con la base de datos.
 */
public class IngresoController {

    private IngresoDAO dao = new IngresoDAO();

    public void ejecutarEscenario() {
        double monto = ThreadLocalRandom.current().nextDouble(6000, 15001);
        monto = Math.round(monto * 100.0) / 100.0;
        // Crear un objeto Ingreso con datos de ejemplo
        Ingreso ingreso = new Ingreso(
                1,                      // cUsuario
                3,                      // cCuentaBancaria
                "Juan Pérez",           // nombreCompleto
                monto,                // monto
                Date.valueOf("2025-05-26"), // fecha actual
                "Pago freelance",       // descripcionIngreso
                2,                      // categoria
                1,                      // metodoPago
                1,                  // moneda
                "Cliente XYZ"           // dDestinatario
        );

        try {
            dao.insertarIngreso(ingreso);
            System.out.println("Ingreso insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error en el escenario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
