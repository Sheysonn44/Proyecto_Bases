package Controlador;

import Modelo.Pago;
import dao.PagoDAO;
import db.Conexion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * Controlador para manejar las operaciones relacionadas con los pagos.
 * Este controlador utiliza PagoDAO para interactuar con la base de datos.
 * 
 * Incluye métodos para mostrar, actualizar y eliminar pagos.
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 *         01-06-2025 PagoController.java
 */
public class PagoController {

    /**
     * Muestra todos los pagos registrados en la base de datos.
     * Imprime la lista de pagos con sus detalles por consola.
     */
    public void mostrarPagos() {
        try (Connection conn = Conexion.getConexion()) {
            PagoDAO dao = new PagoDAO();
            List<Pago> pagos = dao.obtenerPagos(conn);

            System.out.println(" Lista de pagos:");
            for (Pago p : pagos) {
                System.out.println(" Monto: " + p.getMonto() +
                        " | Fecha: " + p.getFechaPago() +
                        " | Descripción: " + p.getDescripcion() +
                        " | Destinatario: " + p.getDestinatario());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un pago específico.
     * Usa un objeto Pago con nuevos datos y lo actualiza en la base de datos.
     */
    public void actualizarPago() {
        try (Connection conn = Conexion.getConexion()) {
            PagoDAO dao = new PagoDAO();
            Pago pago = new Pago(
                    new BigDecimal("60.00"),
                    Date.valueOf("2024-06-10"),
                    "Pago corregido desde Java",
                    4, 1, "Nuevo Destinatario", 2, 5, 1);
            int idPago = 6;
            dao.actualizarPago(pago, idPago, conn);
            System.out.println(" Pago actualizado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un pago específico de la base de datos.
     * El ID del pago a eliminar está definido dentro del método.
     */
    public void eliminarPago() {
        try (Connection conn = Conexion.getConexion()) {
            PagoDAO dao = new PagoDAO();
            int idPago = 6;
            dao.eliminarPago(idPago, conn);
            System.out.println(" Pago eliminado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
