package Controlador;

import Modelo.*;
import dao.*;
import db.Conexion;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 28-06-2025  DeudaController.java
 * Controlador para manejar las operaciones relacionadas con las deudas.
 * Este controlador utiliza DeudaDAO para interactuar con la base de datos.
 */

public class DeudaController {

    /* Atributo para acceder a la capa de datos */
    public void registrarDeudaConPagos() {
        
    /* Método para registrar una deuda con pagos asociados */

    try (Connection conn = Conexion.getConexion()) {
        Deuda deuda = new Deuda();
        deuda.setMonto(new BigDecimal("20000"));
        deuda.setTasaMensual(new BigDecimal("0.02")); 
        deuda.setTasaAnual(new BigDecimal("0.24"));
        deuda.setFechaAdquirida(Date.valueOf("2025-02-15"));
        deuda.setFechaVencimiento(Date.valueOf("2030-02-15"));
        deuda.setPlazo(60); 
        deuda.setAcreedor("Banco XYZ");
        deuda.setDescripcion("Deuda educativa");
        deuda.setCategoriaId(2);
        deuda.setCuentaBancariaId(4);
        deuda.setEstadoId(1);
        deuda.setTipoInteresId(2);
        deuda.setTipoDeudaId(2);
        deuda.setTipoTransaccion(1);
        deuda.setTipoMoneda(1);

        /* Crear la lista de pagos */
        List<Pago> pagos = new ArrayList<>();
        pagos.add(new Pago(new BigDecimal("20.33"), Date.valueOf("2025-03-15"), "Pago marzo", deuda.getCuentaBancariaId(), 1, "Banco XYZ",5, 4, deuda.getTipoMoneda()));
        pagos.add(new Pago(new BigDecimal("20.33"), Date.valueOf("2025-04-15"), "Pago abril", deuda.getCuentaBancariaId(), 1, "Banco XYZ",5, 4, deuda.getTipoMoneda()));

        
        deuda.setPagos(pagos);
        // Crear una instancia de DeudaDAO y llamar al método para insertar la deuda con pagos
        DeudaDAO dao = new DeudaDAO();
        int idDeuda = dao.insertarDeudaConPagos(deuda, conn);

            System.out.println("Deuda insertada y pagos insertados con ID: " + idDeuda);


        
       
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}