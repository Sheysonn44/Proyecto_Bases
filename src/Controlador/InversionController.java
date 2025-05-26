package Controlador;

import dao.InversionDAO;
import Modelo.Inversion;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class InversionController {

    private InversionDAO dao = new InversionDAO();

    public void ejecutarEscenario() {
        Inversion inversion = null;
        inversion = new Inversion(
                "Ana Gómez", // D_Nombre
                "Hipoteca Casa", // T_Inversion
                new BigDecimal("10.00"), // M_Inversion
                new BigDecimal("0.08"), // M_Rentabilidad
                Date.valueOf(LocalDate.now()), // F_Inicio
                "Escenario 1 - Inversión típica",
                5, // C_Cuenta_Bancaria
                1, // C_Estado
                2, // C_TipoInversion
                4, // C_Categoria_Salida
                4, // C_Categoria_Ingreso
                1, // C_TipoMoneda
                2, // C_Tipo_Movimiento
                1 // C_Tipo_Transaccion
        );
        try {
            dao.registrarInversion(inversion);
        } catch (Exception e) {
            System.out.println("❌ Error en el escenario: " + e.getMessage());
        }

    }
}
