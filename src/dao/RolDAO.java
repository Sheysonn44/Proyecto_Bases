package dao;

import Modelo.Rol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase RolDAO que gestiona las operaciones CRUD para los roles en la base de datos.
 */
public class RolDAO {

    private Connection conexion;

    /**
     * Constructor que inicializa la conexión a la base de datos.
     *
     * @param conexion Objeto Connection para ejecutar operaciones SQL.
     */
    public RolDAO(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta un nuevo rol en la base de datos utilizando un procedimiento almacenado.
     *
     * @param rol Objeto Rol con los datos del rol a insertar.
     * @throws SQLException Si ocurre un error durante la ejecución.
     */
    public void insertarRol(Rol rol) throws SQLException {
        String sql = "{call InsertarRol(?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, rol.getcRol());
            stmt.setString(2, rol.getdRol());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza un rol existente en la base de datos utilizando un procedimiento almacenado.
     *
     * @param rol Objeto Rol con el código y la nueva descripción del rol.
     * @throws SQLException Si ocurre un error durante la ejecución.
     */
    public void actualizarRol(Rol rol) throws SQLException {
        String sql = "{call ActualizarRol(?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, rol.getcRol());
            stmt.setString(2, rol.getdRol());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un rol de la base de datos mediante su código, usando un procedimiento almacenado.
     *
     * @param cRol Código del rol a eliminar.
     * @throws SQLException Si ocurre un error durante la ejecución.
     */
    public void eliminarRol(int cRol) throws SQLException {
        String sql = "{call EliminarRol(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, cRol);
            stmt.executeUpdate();
        }
    }

    /**
     * Obtiene una lista de todos los roles disponibles consultando la vista Vista_Roles.
     *
     * @return Lista de objetos Rol obtenidos de la base de datos.
     * @throws SQLException Si ocurre un error durante la ejecución.
     */
    public List<Rol> listarRoles() throws SQLException {
        List<Rol> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Roles";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Rol r = new Rol();
                r.setcRol(rs.getInt("C_Rol"));
                r.setdRol(rs.getString("D_Rol"));
                lista.add(r);
            }
        }
        return lista;
    }
}
