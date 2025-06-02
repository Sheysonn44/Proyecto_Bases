package Controlador;

import Modelo.TipoMoneda;
import dao.TipoMonedaDAO;

import java.util.List;

/**
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 28-06-2025 TipoMonedaController.java     
 * Controlador para gestionar las operaciones relacionadas con los tipos de moneda.
 * Permite insertar, mostrar, actualizar y eliminar tipos de moneda.
 */
public class TipoMonedaController {

    private final TipoMonedaDAO dao = new TipoMonedaDAO();
    // Método principal de prueba
    /**
     * Ejecuta un escenario de prueba para el controlador de tipos de moneda.
     * Muestra los tipos de moneda, inserta uno nuevo, actualiza uno existente y elimina otro.
     */
    public void ejecutarEscenario() {
        mostrarTiposMoneda();
        insertarTipoMoneda();
        actualizarTipoMoneda();
        eliminarTipoMoneda();
    }

    //  Mostrar todos los tipos de moneda
    public void mostrarTiposMoneda() {
        System.out.println("Listado de tipos de moneda:");
        List<TipoMoneda> lista = dao.obtenerTiposMoneda();
        for (TipoMoneda tipo : lista) {
            System.out.println("ID: " + tipo.getIdTipoMoneda() + " | Símbolo: " + tipo.getSimbolo() + " | Nombre: "
                    + tipo.getNombre());
        }
    }

    //  Insertar tipo de moneda
    public void insertarTipoMoneda() {
        TipoMoneda nuevo = new TipoMoneda("₡", "Colón Costarricense");
        dao.insertarTipoMoneda(nuevo);
    }

    //  Actualizar tipo de moneda
    public void actualizarTipoMoneda() {
        TipoMoneda actualizado = new TipoMoneda(1, "$", "Dólar Estadounidense");
        dao.actualizarTipoMoneda(actualizado);
    }

    //  Eliminar tipo de moneda
    public void eliminarTipoMoneda() {
        int idEliminar = 3; // cambia por un ID válido de tu tabla
        dao.eliminarTipoMoneda(idEliminar);
    }
}
