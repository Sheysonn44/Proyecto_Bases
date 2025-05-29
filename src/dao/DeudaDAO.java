package dao;

import Modelo.Deuda;
import java.sql.*;
import java.util.*;

/**
 * Clase responsable del manejo de datos relacionados con deudas.
 * Permite insertar una deuda con sus pagos asociados utilizando procedimientos almacenados.
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

 

}
