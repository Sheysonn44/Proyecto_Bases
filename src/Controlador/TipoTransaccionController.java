package Controlador;

import Modelo.TipoTransaccion;
import dao.TipoTransaccionDAO;
import db.Conexion;

import java.sql.Connection;
import java.util.List;

/*** 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 *  28-06-2025 TipoTransaccionController.java
 * Controlador para gestionar las operaciones relacionadas con los tipos de transacción.
 * Permite insertar, mostrar, actualizar y eliminar tipos de transacción.
 */
public class TipoTransaccionController {

    public void mostrarTiposTransaccion() {
        try (Connection conn = Conexion.getConexion()) {
            TipoTransaccionDAO dao = new TipoTransaccionDAO();
            List<TipoTransaccion> lista = dao.obtenerTipoTransacciones(conn);

            System.out.println("Lista de Tipos de Transacción:");
            for (TipoTransaccion tipo : lista) {
                System.out.println("ID: " + tipo.getId() + " | Descripción: " + tipo.getDescripcion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertarTipoTransaccion(String descripcion) {
        try (Connection conn = Conexion.getConexion()) {
            TipoTransaccionDAO dao = new TipoTransaccionDAO();
            TipoTransaccion tipo = new TipoTransaccion();
            tipo.setDescripcion(descripcion);

            dao.insertarTipoTransaccion(tipo, conn);
            System.out.println("Tipo de transacción insertado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarTipoTransaccion(int id, String nuevaDescripcion) {
        try (Connection conn = Conexion.getConexion()) {
            TipoTransaccionDAO dao = new TipoTransaccionDAO();
            TipoTransaccion tipo = new TipoTransaccion();
            tipo.setId(id);
            tipo.setDescripcion(nuevaDescripcion);

            dao.actualizarTipoTransaccion(tipo, conn);
            System.out.println("Tipo de transacción actualizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarTipoTransaccion(int id) {
        try (Connection conn = Conexion.getConexion()) {
            TipoTransaccionDAO dao = new TipoTransaccionDAO();
            dao.eliminarTipoTransaccion(id, conn);
            System.out.println("Tipo de transacción eliminado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
