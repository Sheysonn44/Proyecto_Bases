package Controlador;

import dao.GastoDAO;
import db.Conexion;
import Modelo.Gasto;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.sql.Connection;
import java.util.Calendar;

/**
 * 
 *
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 *         28-06-2025 GastoController.java
 *         Controlador para manejar las operaciones relacionadas con los gastos.
 *         Este controlador utiliza GastoDAO para interactuar con la base de
 *         datos.
 */

public class GastoController {

    /* Atributo para acceder a la capa de datos */
    public void ejecutarEscenario() {

        // Primer gasto - Persona 1
        Gasto gasto1 = crearGasto(
                50.0, // Monto
                "Pago de Luz", // Descripción
                1, // Categoría transporte
                3, // Cuenta bancaria
                1, // Método pago
                1, // Tipo moneda
                "ICE", // Destinatario
                2 // Tipo transacción

        );

        // Segundo gasto - Persona 2
        Gasto gasto2 = crearGasto(
                100.0, // Monto
                "Compra en Alimento para Perros", // Descripción
                2, // Categoría alimentación
                7, // Cuenta bancaria diferente
                2, // Tarjeta
                1, // Tipo moneda
                "PALI", // Destinatario
                2 // Tipo transacción

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

    private void mostrarGastos() {
        try (Connection conn = Conexion.getConexion()) {
            List<Gasto> lista = new GastoDAO().obtenerGastos(conn);
            System.out.println("\n Lista de gastos:");
            for (Gasto g : lista) {
                System.out.println("Monto: " + g.getM_Gasto() +
                        " | Fecha: " + g.getF_Gasto() +
                        " | Descripción: " + g.getD_Descripcion() +
                        " | Destinatario: " + g.getD_Destinatario());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 Actualizar gasto por ID
    private void actualizarGasto(int idGasto) {
        try (Connection conn = Conexion.getConexion()) {
            Gasto gastoModificado = crearGasto(500.0, "Gasto corregido desde Java", 3, 4, 1, 1, "Corregido S.A.", 2);
            new GastoDAO().actualizarGasto(gastoModificado, idGasto, conn);
            System.out.println("Gasto actualizado (ID: " + idGasto + ").");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarGasto(int idGasto) {
        try (Connection conn = Conexion.getConexion()) {
            new GastoDAO().eliminarGasto(idGasto, conn);
            System.out.println(" Gasto eliminado (ID: " + idGasto + ").");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
