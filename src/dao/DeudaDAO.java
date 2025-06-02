package dao;

import Modelo.Deuda;
import java.sql.*;
import java.util.*;

/**
 * Clase responsable del manejo de datos relacionados con deudas.
 * Permite insertar una deuda con sus pagos asociados utilizando procedimientos almacenados.
 * 
 * 1-06-2025 Clase DeudaDAO.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class DeudaDAO {
   
    /**
     * Inserta una deuda en la base de datos y registra sus pagos asociados.
     *
     * @param deuda Objeto Deuda con la información a registrar.
     * @param conn Conexión activa a la base de datos.
     * @return ID generado de la deuda insertada.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public int insertarDeudaConPagos(Deuda deuda, Connection conn) throws SQLException {
        String sql = "{call InsertarDeuda(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setBigDecimal(1, deuda.getMonto());
            stmt.setBigDecimal(2, deuda.getTasaMensual());
            stmt.setBigDecimal(3, deuda.getTasaAnual());
            stmt.setDate(4, deuda.getFechaAdquirida());
            stmt.setDate(5, deuda.getFechaVencimiento());
            stmt.setInt(6, deuda.getPlazo());
            stmt.setString(7, deuda.getAcreedor());
            stmt.setString(8, deuda.getDescripcion());
            stmt.setInt(9, deuda.getCategoriaId());
            stmt.setInt(10, deuda.getCuentaBancariaId());
            stmt.setInt(11, deuda.getEstadoId());
            stmt.setInt(12, deuda.getTipoInteresId());
            stmt.setInt(13, deuda.getTipoDeudaId());
            stmt.setInt(14, deuda.getTipoTransaccion());
            stmt.setInt(15, deuda.getTipoMoneda());
            stmt.registerOutParameter(16, Types.INTEGER);

            stmt.executeUpdate();
            int idDeuda = stmt.getInt(16);

           PagoDAO pagoDAO = new PagoDAO();
            pagoDAO.registrarPagos(deuda.getPagos(), idDeuda, conn);

            return idDeuda;
        }
    }

 /**
     * Actualiza una deuda existente.
     * @param deuda Objeto con datos actualizados, debe incluir el id.
     * @param conn Conexión activa.
     * @throws SQLException 
     */
    public void actualizarDeuda(Deuda deuda, Connection conn) throws SQLException {
        String sql = "{call ActualizarDeuda(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, deuda.getId());
            stmt.setBigDecimal(2, deuda.getMonto());
            stmt.setBigDecimal(3, deuda.getTasaMensual());
            stmt.setBigDecimal(4, deuda.getTasaAnual());
            stmt.setDate(5, deuda.getFechaAdquirida());
            stmt.setDate(6, deuda.getFechaVencimiento());
            stmt.setInt(7, deuda.getPlazo());
            stmt.setString(8, deuda.getAcreedor());
            stmt.setString(9, deuda.getDescripcion());
            stmt.setInt(10, deuda.getCategoriaId());
            stmt.setInt(11, deuda.getCuentaBancariaId());
            stmt.setInt(12, deuda.getEstadoId());
            stmt.setInt(13, deuda.getTipoInteresId());
            stmt.setInt(14, deuda.getTipoDeudaId());
            stmt.setInt(15, deuda.getTipoTransaccion());
            stmt.setInt(16, deuda.getTipoMoneda());

            stmt.executeUpdate();
        }
    }

    /**
     * Elimina una deuda por su id.
     * @param idDeuda id de la deuda a eliminar.
     * @param conn Conexión activa.
     * @throws SQLException 
     */
    public void eliminarDeuda(int idDeuda, Connection conn) throws SQLException {
        String sql = "{call EliminarDeuda(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, idDeuda);
            stmt.executeUpdate();
        }
    }

    /**
     * Lista todas las deudas (vista o select simple).
     * @param conn Conexión activa.
     * @return Lista de deudas.
     * @throws SQLException 
     */
    public List<Deuda> listarDeudas(Connection conn) throws SQLException {
        List<Deuda> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Deudas"; 
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Deuda deuda = new Deuda();
                deuda.setId(rs.getInt("IdDeuda"));
                deuda.setMonto(rs.getBigDecimal("Monto"));
                deuda.setTasaMensual(rs.getBigDecimal("TasaMensual"));
                deuda.setTasaAnual(rs.getBigDecimal("TasaAnual"));
                deuda.setFechaAdquirida(rs.getDate("FechaAdquirida"));
                deuda.setFechaVencimiento(rs.getDate("FechaVencimiento"));
                deuda.setPlazo(rs.getInt("Plazo"));
                deuda.setAcreedor(rs.getString("Acreedor"));
                deuda.setDescripcion(rs.getString("Descripcion"));
                deuda.setCategoriaId(rs.getInt("CategoriaId"));
                deuda.setCuentaBancariaId(rs.getInt("CuentaBancariaId"));
                deuda.setEstadoId(rs.getInt("EstadoId"));
                deuda.setTipoInteresId(rs.getInt("TipoInteresId"));
                deuda.setTipoDeudaId(rs.getInt("TipoDeudaId"));
                deuda.setTipoTransaccion(rs.getInt("TipoTransaccion"));
                deuda.setTipoMoneda(rs.getInt("TipoMoneda"));
                
                lista.add(deuda);
            }
        }
        return lista;
    }
}