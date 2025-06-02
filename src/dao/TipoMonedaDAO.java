package dao;

import Modelo.TipoMoneda;
import db.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**@author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 *  28-06-2025 TipoMonedaDAO.java
 * Clase DAO para manejar operaciones CRUD en la tabla Tipo_Moneda
 * usando procedimientos almacenados.
 */
public class TipoMonedaDAO {

    // 🔹 Insertar
    public void insertarTipoMoneda(TipoMoneda tipoMoneda) {
        String sql = "{call InsertarTipoMoneda(?, ?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, tipoMoneda.getSimbolo());
            stmt.setString(2, tipoMoneda.getNombre());
            stmt.execute();
            System.out.println("Tipo de moneda insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar tipo de moneda: " + e.getMessage());
        }
    }

    //  Mostrar todos
    public List<TipoMoneda> obtenerTiposMoneda() {
        List<TipoMoneda> lista = new ArrayList<>();
        String sql = "{call MostrarTiposMoneda()}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TipoMoneda tipo = new TipoMoneda(
                        rs.getInt("C_TipoMoneda"),
                        rs.getString("D_Simbolo"),
                        rs.getString("D_Nombre"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener tipos de moneda: " + e.getMessage());
        }
        return lista;
    }

    //  Actualizar
    public void actualizarTipoMoneda(TipoMoneda tipoMoneda) {
        String sql = "{call ActualizarTipoMoneda(?, ?, ?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, tipoMoneda.getIdTipoMoneda());
            stmt.setString(2, tipoMoneda.getSimbolo());
            stmt.setString(3, tipoMoneda.getNombre());
            stmt.execute();
            System.out.println("Tipo de moneda actualizado.");
        } catch (Exception e) {
            System.out.println("Error al actualizar tipo de moneda: " + e.getMessage());
        }
    }

    //  Eliminar
    public void eliminarTipoMoneda(int id) {
        String sql = "{call EliminarTipoMoneda(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Tipo de moneda eliminado.");
        } catch (Exception e) {
            System.out.println("Error al eliminar tipo de moneda: " + e.getMessage());
        }
    }
}
