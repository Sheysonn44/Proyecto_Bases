package dao;

import Modelo.PropositoFondoEmergencia;
import db.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para manejar las operaciones CRUD de PropositoFondoEmergencia.
 * Utiliza procedimientos almacenados para realizar las operaciones en la base
 * de datos.
 * 
 * 1-06-2025 Clase public class PropositoFondoEmergenciaDAO.java
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class PropositoFondoEmergenciaDAO {

    // insertar
    /**
     * Inserta un nuevo propósito de fondo de emergencia en la base de datos.
     *
     * @param proposito Objeto PropositoFondoEmergencia a insertar.
     * @throws Exception Si ocurre un error al insertar el propósito.
     */
    public void insertarProposito(PropositoFondoEmergencia proposito) throws Exception {
        String sql = "{call InsertarPropositoFondoEmergencia(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, proposito.getdProposito());
            cstmt.execute();
            System.out.println("Propósito insertado correctamente.");
        }
    }

    // Editar
    /**
     * Edita un propósito de fondo de emergencia existente en la base de datos.
     *
     * @param proposito Objeto PropositoFondoEmergencia con los datos actualizados.
     * @throws Exception Si ocurre un error al editar el propósito.
     */
    public void editarProposito(PropositoFondoEmergencia proposito) throws Exception {
        String sql = "{call EditarPropositoFondoEmergencia(?, ?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, proposito.getcProposito());
            cstmt.setString(2, proposito.getdProposito());
            cstmt.executeUpdate();
            System.out.println("Propósito editado correctamente.");
        }
    }

    // Eliminar
    /**
     * Elimina un propósito de fondo de emergencia de la base de datos.
     *
     * @param cProposito Identificador del propósito a eliminar.
     * @throws Exception Si ocurre un error al eliminar el propósito.
     */
    public void eliminarProposito(int cProposito) throws Exception {
        String sql = "{call EliminarPropositoFondoEmergencia(?)}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, cProposito);
            cstmt.executeUpdate();
            System.out.println("Propósito eliminado correctamente.");
        }
    }

    // ver propósitos
    /**
     * Recupera una lista de todos los propósitos de fondo de emergencia.
     *
     * @return Lista de objetos PropositoFondoEmergencia.
     * @throws Exception Si ocurre un error al recuperar los propósitos.
     */
    public List<PropositoFondoEmergencia> verPropositos() throws Exception {
        List<PropositoFondoEmergencia> lista = new ArrayList<>();
        String sql = "{call VerPropositosFondoEmergencia()}";
        try (Connection conn = Conexion.getConexion();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                int cProposito = rs.getInt("C_Proposito");
                String dProposito = rs.getString("D_Proposito");
                lista.add(new PropositoFondoEmergencia(cProposito, dProposito));
            }
        }
        return lista;
    }
}
