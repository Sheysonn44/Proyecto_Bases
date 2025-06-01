package Controlador;

import Modelo.Pago;
import dao.PagoDAO;
import db.Conexion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class PagoController {

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

