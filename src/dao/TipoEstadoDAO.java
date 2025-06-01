package dao;

import java.sql.*;
import java.util.*;
import Modelo.TiposEstado;

/**
 * Clase TipoEstadoDAO para gestionar las operaciones CRUD sobre los tipos de estado
 * en la base de datos.
 */
public class TipoEstadoDAO {
    private Connection conexion;

    /**
     * Constructor que recibe una conexión a la base de datos.
     *
     * @param conexion Objeto Connection utilizado para conectarse a la base de datos.
     */
    public TipoEstadoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta un nuevo tipo de estado en la base de datos.
     *
     * @param estado Objeto TiposEstado que contiene la descripción del estado a insertar.
     * @throws SQLException Si ocurre un error durante la ejecución de la consulta.
     */
    public void insertar(TiposEstado estado) throws SQLException {
        String sql = "INSERT INTO Tipos_Estado (D_Estado) VALUES (?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, estado.getDEstado());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza la descripción de un tipo de estado existente.
     *
     * @param estado Objeto TiposEstado con el código y la nueva descripción del estado.
     * @throws SQLException Si ocurre un error durante la ejecución de la consulta.
     */
    public void actualizar(TiposEstado estado) throws SQLException {
        String sql = "UPDATE Tipos_Estado SET D_Estado = ? WHERE C_Estado = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, estado.getDEstado());
            stmt.setInt(2, estado.getCEstado());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un tipo de estado de la base de datos.
     *
     * @param cEstado Código del estado a eliminar.
     * @throws SQLException Si ocurre un error durante la ejecución de la consulta.
     */
    public void eliminar(int cEstado) throws SQLException {
        String sql = "DELETE FROM Tipos_Estado WHERE C_Estado = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cEstado);
            stmt.executeUpdate();
        }
    }

    /**
     * Lista todos los tipos de estado disponibles en la base de datos.
     *
     * @return Lista de objetos TiposEstado obtenidos de la base de datos.
     * @throws SQLException Si ocurre un error durante la ejecución de la consulta.
     */
    public List<TiposEstado> listarTodos() throws SQLException {
        List<TiposEstado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Tipos_Estado";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TiposEstado estado = new TiposEstado(
                    rs.getInt("C_Estado"),
                    rs.getString("D_Estado")
                );
                lista.add(estado);
            }
        }
        return lista;
    }
}
