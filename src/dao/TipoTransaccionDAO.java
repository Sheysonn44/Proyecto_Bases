package dao;

import Modelo.TipoTransaccion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase TipoTransaccionDAO permite manejar las operaciones relacionadas con los tipos de transacciones.
 * Permite insertar, actualizar, eliminar
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 * 28-06-2025 TipoTransaccionDAO.java
 * 
 */
public class TipoTransaccionDAO {

    // Obtener todos los tipos de transacciones
    public List<TipoTransaccion> obtenerTipoTransacciones(Connection conn) {
        List<TipoTransaccion> lista = new ArrayList<>();
        String sql = "{CALL MostrarTiposTransacciones()}";

        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TipoTransaccion tipo = new TipoTransaccion();
                tipo.setId(rs.getInt("C_Tipo_Transaccion"));
                tipo.setDescripcion(rs.getString("D_Tipo_Transaccion"));
                lista.add(tipo);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener los tipos de transacción: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    // Insertar un tipo de transacción
    public void insertarTipoTransaccion(TipoTransaccion tipo, Connection conn) throws Exception {
        String sql = "{CALL InsertarTipoTransaccion(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, tipo.getDescripcion());
            stmt.execute();
        }
    }

    // Actualizar un tipo de transacción
    public void actualizarTipoTransaccion(TipoTransaccion tipo, Connection conn) throws Exception {
        String sql = "{CALL ActualizarTipoTransaccion(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, tipo.getId());
            stmt.setString(2, tipo.getDescripcion());
            stmt.execute();
        }
    }

    // Eliminar un tipo de transacción
    public void eliminarTipoTransaccion(int id, Connection conn) throws Exception {
        String sql = "{CALL EliminarTipoTransaccion(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
