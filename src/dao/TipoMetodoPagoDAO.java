package dao;

import Modelo.TipoMetodoPago;
import db.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para manejar las operaciones de TipoMetodoPago en la base de datos.
 * Contiene métodos para insertar, editar, eliminar y listar tipos de métodos de
 * pago.
 * 
 * 1-06-2025 Clase TipoMetodoPagoDAO.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class TipoMetodoPagoDAO {

    // Insertar
    /**
     * Inserta un nuevo tipo de método de pago en la base de datos.
     *
     * @param tipo Objeto TipoMetodoPago que contiene los datos a insertar.
     * @throws Exception Si ocurre un error al ejecutar la operación.
     */
    public void insertarTipoMetodoPago(TipoMetodoPago tipo) throws Exception {
        String sql = "{call InsertarTipoMetodoPago(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, tipo.getdMetodoPago());
            cstmt.execute();
            System.out.println("Tipo de método de pago insertado correctamente.");
        }
    }

    // Editar
    /**
     * Edita un tipo de método de pago existente en la base de datos.
     *
     * @param tipo Objeto TipoMetodoPago que contiene los datos a editar.
     * @throws Exception Si ocurre un error al ejecutar la operación.
     */
    public void editarTipoMetodoPago(TipoMetodoPago tipo) throws Exception {
        String sql = "{call EditarTipoMetodoPago(?, ?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, tipo.getcMetodoPago());
            cstmt.setString(2, tipo.getdMetodoPago());
            cstmt.executeUpdate();
            System.out.println("Tipo de método de pago editado correctamente.");
        }
    }

    // Eliminar
    /**
     * Elimina un tipo de método de pago de la base de datos.
     *
     * @param cMetodoPago Identificador del tipo de método de pago a eliminar.
     * @throws Exception Si ocurre un error al ejecutar la operación.
     */
    public void eliminarTipoMetodoPago(int cMetodoPago) throws Exception {
        String sql = "{call EliminarTipoMetodoPago(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, cMetodoPago);
            cstmt.executeUpdate();
            System.out.println("Tipo de método de pago eliminado correctamente.");
        }
    }

    // Ver todos
    /**
     * Recupera una lista de todos los tipos de métodos de pago desde la base de
     * datos.
     *
     * @return Lista de objetos TipoMetodoPago.
     * @throws Exception Si ocurre un error al ejecutar la operación.
     */
    public List<TipoMetodoPago> verTiposMetodoPago() throws Exception {
        List<TipoMetodoPago> lista = new ArrayList<>();
        String sql = "{call VerTiposMetodoPago()}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("C_Metodo_Pago");
                String descripcion = rs.getString("D_Metodo_Pago");
                lista.add(new TipoMetodoPago(id, descripcion));
            }
        }
        return lista;
    }
}
