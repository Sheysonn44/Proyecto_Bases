
package Controlador;

import Modelo.CuentaBancaria;
import dao.CuentaBancariaDAO;
import db.Conexion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 *         28-06-2025 Clase AhorroController.java
 *         Controlador para manejar las operaciones de cuentas bancarias.
 *         Permite mostrar, insertar, actualizar y eliminar cuentas.
 */
public class CuentaBancariaController {

    /**
     * Muestra una lista de todas las cuentas bancarias registradas.
     * Utiliza el DAO para obtener las cuentas desde la base de datos
     * 
     */
    public void mostrarCuentas() {
        try (Connection conn = Conexion.getConexion()) {
            CuentaBancariaDAO dao = new CuentaBancariaDAO();
            List<CuentaBancaria> cuentas = dao.obtenerCuentas(conn);

            System.out.println(" Lista de cuentas bancarias:");
            for (CuentaBancaria c : cuentas) {
                System.out.println(" ID: " + c.getIdCuenta()
                        + " | Banco: " + c.getBanco()
                        + " | Cuenta: " + c.getNumeroCuenta()
                        + " | Saldo: " + c.getSaldoActual());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserta una nueva cuenta bancaria en la base de datos.
     * Utiliza el DAO para realizar la inserción.
     * 
     */
    public void insertarCuenta() {
        try (Connection conn = Conexion.getConexion()) {
            CuentaBancariaDAO dao = new CuentaBancariaDAO();

            CuentaBancaria nuevaCuenta = new CuentaBancaria(

                    "Banco Costa Rica",
                    "006-0006",
                    new BigDecimal("15000.75"),
                    Date.valueOf("2024-06-01"),
                    8,
                    1,
                    2,
                    2,
                    1);

            dao.insertarCuenta(nuevaCuenta, conn);
            System.out.println(" Cuenta insertada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza una cuenta bancaria existente en la base de datos.
     * Utiliza el DAO para realizar la actualización.
     * 
     */
    public void actualizarCuenta() {
        try (Connection conn = Conexion.getConexion()) {
            CuentaBancariaDAO dao = new CuentaBancariaDAO();

            CuentaBancaria cuentaActualizada = new CuentaBancaria(
                    4, // ID de la cuenta que ya existe
                    "Banco Nacional Actualizado",
                    "005-0005",
                    new BigDecimal("30000.00"),
                    Date.valueOf("2024-06-15"),
                    8, 1, 1, 1, 1);

            dao.actualizarCuenta(cuentaActualizada, conn);
            System.out.println(" Cuenta actualizada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una cuenta bancaria de la base de datos.
     * Utiliza el DAO para realizar la eliminación.
     * 
     */
    public void eliminarCuenta() {
        try (Connection conn = Conexion.getConexion()) {
            CuentaBancariaDAO dao = new CuentaBancariaDAO();

            int idAEliminar = 1; // cambia este ID por uno real que exista
            dao.eliminarCuenta(idAEliminar, conn);
            System.out.println(" Cuenta eliminada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
