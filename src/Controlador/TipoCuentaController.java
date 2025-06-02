package Controlador;

import Modelo.TipoCuenta;
import dao.TipoCuentaDAO;

import java.util.List;

/**
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 28-06-2025 TipoCuentaController.java
 * Controlador para gestionar las operaciones relacionadas con los tipos de cuenta.
 * Permite insertar, mostrar, actualizar y eliminar tipos de cuenta.
 */
public class TipoCuentaController {

    private final TipoCuentaDAO dao = new TipoCuentaDAO();

    // Método principal de prueba
    public void ejecutarEscenario() {
        insertarTipoCuenta("Cuenta de ahorro");
        mostrarTiposCuenta();
        actualizarTipoCuenta(1, "Cuenta corriente actualizada");
        eliminarTipoCuenta(2);
    }

    // Insertar un tipo de cuenta
    public void insertarTipoCuenta(String descripcion) {
        TipoCuenta tipoCuenta = new TipoCuenta(descripcion);
        dao.insertarTipoCuenta(tipoCuenta);
    }

    // Mostrar todos los tipos de cuenta
    public void mostrarTiposCuenta() {
        List<TipoCuenta> tipos = dao.obtenerTiposCuenta();
        System.out.println("Lista de Tipos de Cuenta:");
        for (TipoCuenta tipo : tipos) {
            System.out.println("ID: " + tipo.getIdTipoCuenta() + " | Descripción: " + tipo.getDescripcion());
        }
    }

    // Actualizar un tipo de cuenta
    public void actualizarTipoCuenta(int id, String nuevaDescripcion) {
        TipoCuenta tipoCuenta = new TipoCuenta(id, nuevaDescripcion);
        dao.actualizarTipoCuenta(tipoCuenta);
    }

    // Eliminar un tipo de cuenta
    public void eliminarTipoCuenta(int id) {
        dao.eliminarTipoCuenta(id);
    }
}
