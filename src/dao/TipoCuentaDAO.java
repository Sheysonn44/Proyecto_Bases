package dao;

import Modelo.TipoCuenta;
import db.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 28-06-2025 TipoCuentaDAO.java
 * Clase DAO para manejar operaciones CRUD en la tabla Tipo_Cuenta
*/
public class TipoCuentaDAO {

    // Insertar un nuevo tipo de cuenta
    public void insertarTipoCuenta(TipoCuenta tipoCuenta) {
        try (Connection conn = Conexion.getConexion()) {
            CallableStatement stmt = conn.prepareCall("{CALL InsertarTipoCuenta(?)}");
            stmt.setString(1, tipoCuenta.getDescripcion());
            stmt.execute();
            System.out.println("Tipo de cuenta insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar tipo de cuenta: " + e.getMessage());
        }
    }

    // Mostrar todos los tipos de cuenta
    public List<TipoCuenta> obtenerTiposCuenta() {
        List<TipoCuenta> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConexion()) {
            CallableStatement stmt = conn.prepareCall("{CALL MostrarTipoCuenta}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoCuenta tipo = new TipoCuenta(
                        rs.getInt("C_Tipo_Cuenta"),
                        rs.getString("D_Tipo_Cuenta"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener tipos de cuenta: " + e.getMessage());
        }
        return lista;
    }

    // Actualizar tipo de cuenta
    public void actualizarTipoCuenta(TipoCuenta tipoCuenta) {
        try (Connection conn = Conexion.getConexion()) {
            CallableStatement stmt = conn.prepareCall("{CALL ActualizarTipoCuenta(?, ?)}");
            stmt.setInt(1, tipoCuenta.getIdTipoCuenta());
            stmt.setString(2, tipoCuenta.getDescripcion());
            stmt.execute();
            System.out.println("Tipo de cuenta actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar tipo de cuenta: " + e.getMessage());
        }
    }

    // Eliminar tipo de cuenta
    public void eliminarTipoCuenta(int idTipoCuenta) {
        try (Connection conn = Conexion.getConexion()) {
            CallableStatement stmt = conn.prepareCall("{CALL EliminarTipoCuenta(?)}");
            stmt.setInt(1, idTipoCuenta);
            stmt.execute();
            System.out.println("Tipo de cuenta eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar tipo de cuenta: " + e.getMessage());
        }
    }
}
