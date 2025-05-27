package Controlador;

import Modelo.Ahorro;
import dao.AhorroDAO;

import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

public class AhorroController {

    private AhorroDAO dao = new AhorroDAO();

    public void ejecutarEscenario() {
      

        // Crear un objeto Ahorro con datos de ejemplo
        Ahorro ahorro = new Ahorro(
                "Meta vacaciones 2025",               // metaAhorro
                Date.valueOf("2025-01-01"),           // fechaInicio
                6000,                        // montoDeposito
                Date.valueOf("2025-01-15"),           // fechaDeposito
                20000.00,                            // montoObjetivo
                6000,                       // montoActual (igual al depósito inicial)
                Date.valueOf("2025-12-31"),           // fechaFinal
                "Ahorro para vacaciones",            // descripcion
                3,                                  // cuentaBancaria
                1,                                  // estado (activo)
                2                                   // metodoPago
        );

        try {
            dao.insertarAhorro(ahorro);
            System.out.println("Ahorro insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error en el escenario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}