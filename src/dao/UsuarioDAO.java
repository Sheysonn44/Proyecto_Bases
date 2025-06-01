package dao;

import Modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase RolDAO para manejar las operaciones CRUD de los roles en la base de datos.
 */
public class UsuarioDAO {
   /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexion Objeto Connection para conectarse a la base de datos.
     */
    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

      /**
     * Inserta un nuevo rol utilizando un procedimiento almacenado.
     *
     * @param rol Objeto Rol que contiene los datos del rol a insertar.
     * @throws SQLException Si ocurre un error durante la ejecución de la consulta.
     */
    public int insertarUsuario(Usuario usuario) throws SQLException {
        String sql = "{call InsertarUsuario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, usuario.getdNombre());
            stmt.setString(2, usuario.getdApellido1());
            stmt.setString(3, usuario.getdApellido2());
            stmt.setString(4, usuario.getdCorreo());
            stmt.setString(5, usuario.getdContrasena());
            stmt.setInt(6, usuario.getcRol());
            stmt.setInt(7, usuario.getcProvincia());
            stmt.setInt(8, usuario.getcCanton());
            stmt.setInt(9, usuario.getcDistrito());
            stmt.registerOutParameter(10, Types.INTEGER); 

            stmt.executeUpdate();
            return stmt.getInt(10);
        }
    }

    /**
     * Actualiza los datos de un rol existente utilizando un procedimiento almacenado.
     *
     * @param rol Objeto Rol con los datos actualizados.
     * @throws SQLException Si ocurre un error durante la ejecución de la consulta.
     */
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "{call ActualizarUsuario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, usuario.getcUsuario());
            stmt.setString(2, usuario.getdNombre());
            stmt.setString(3, usuario.getdApellido1());
            stmt.setString(4, usuario.getdApellido2());
            stmt.setString(5, usuario.getdCorreo());
            stmt.setString(6, usuario.getdContrasena());
            stmt.setInt(7, usuario.getcRol());
            stmt.setInt(8, usuario.getcProvincia());
            stmt.setInt(9, usuario.getcCanton());
            stmt.setInt(10, usuario.getcDistrito());

            stmt.executeUpdate();
        }
    }

      /**
     * Elimina un rol de la base de datos utilizando un procedimiento almacenado.
     *
     * @param cRol Código del rol a eliminar.
     * @throws SQLException Si ocurre un error durante la ejecución de la consulta.
     */
    public void eliminarUsuario(int cUsuario) throws SQLException {
        String sql = "{call EliminarUsuario(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, cUsuario);
            stmt.executeUpdate();
        }
    }

     /**
     * Obtiene la lista de roles desde una vista en la base de datos.
     *
     * @return Lista de objetos Rol con los datos obtenidos.
     * @throws SQLException Si ocurre un error durante la ejecución de la consulta.
     */
    
    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Usuarios"; 
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setcUsuario(rs.getInt("C_Usuario"));
                u.setdNombre(rs.getString("D_Nombre"));
                u.setdApellido1(rs.getString("D_Apellido_1"));
                u.setdApellido2(rs.getString("D_Apellido_2"));
                u.setdCorreo(rs.getString("D_Correo"));
                u.setdContrasena(rs.getString("D_Contraseña"));
                u.setcRol(rs.getInt("C_Rol"));
                u.setcProvincia(rs.getInt("C_Provincia"));
                u.setcCanton(rs.getInt("C_Canton"));
                u.setcDistrito(rs.getInt("C_Distrito"));
                lista.add(u);
            }
        }
        return lista;
    }
}