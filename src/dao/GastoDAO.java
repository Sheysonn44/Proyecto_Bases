package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Conexion;
import Modelo.Gasto;

/**
 * Clase GatoDAO permite manejar las operaciones relacionadas con los gastos.
 * Permite insertar registros de gasto en la base de datos utilizando
 * procedimientos almacenados.
 * 
 * 1-06-2025 Clase GastoDAO.java*
 * 
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 */
public class GastoDAO {

    /**
     * Inserta un nuevo gasto en la base de datos utilizando el procedimiento
     * almacenado
     * InsertarGasto_Actualizacion. También actualiza las entidades relacionadas
     * como
     * cuentas, transacciones y saldos.
     *
     * @param gasto Objeto Modelo.Gasto que contiene los datos del gasto a insertar.
     */

    public static void insertarGasto(Gasto gasto) {
        try {
            Connection conn = Conexion.getConexion();
            String sql = "{CALL InsertarGasto_Actualizacion(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement stmt = conn.prepareCall(sql);

            stmt.setBigDecimal(1, new java.math.BigDecimal(gasto.getM_Gasto()));
            stmt.setDate(2, new Date(gasto.getF_Gasto().getTime()));
            stmt.setString(3, gasto.getD_Descripcion());
            stmt.setInt(4, gasto.getC_Categoria());
            stmt.setInt(5, gasto.getC_Cuenta_Bancaria());
            stmt.setInt(6, gasto.getC_Metodo_Pago());
            stmt.setInt(7, gasto.getC_TipoMoneda());
            stmt.setString(8, gasto.getD_Destinatario());
            stmt.setInt(9, gasto.getC_TipoTransaccion());

            stmt.execute();

            System.out.println(" Gasto insertado correctamente.");
        } catch (Exception e) {
            System.out.println(" Error al insertar el gasto: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Gasto> obtenerGastos(Connection conn) {
        List<Gasto> lista = new ArrayList<>();
        try (CallableStatement stmt = conn.prepareCall("{CALL MostrarGastos()}")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Gasto gasto = new Gasto(
                        rs.getDouble("M_Gasto"),
                        rs.getDate("F_Gasto"),
                        rs.getString("D_Descripcion"),
                        rs.getInt("C_Categoria"),
                        rs.getInt("C_Cuenta_Bancaria"),
                        rs.getInt("C_Metodo_Pago"),
                        rs.getInt("C_TipoMoneda"),
                        rs.getString("D_Destinatario"),
                        rs.getInt("C_TipoTransaccion"));
                lista.add(gasto);
            }
        } catch (Exception e) {
            System.out.println(" Error al obtener los gastos: " + e.getMessage());
        }
        return lista;
    }

    public void actualizarGasto(Gasto gasto, int idGasto, Connection conn) {
        try (CallableStatement stmt = conn
                .prepareCall("{CALL ActualizarGasto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, idGasto);
            stmt.setBigDecimal(2, new java.math.BigDecimal(gasto.getM_Gasto()));
            stmt.setDate(3, new Date(gasto.getF_Gasto().getTime()));
            stmt.setString(4, gasto.getD_Descripcion());
            stmt.setInt(5, gasto.getC_Categoria());
            stmt.setInt(6, gasto.getC_Cuenta_Bancaria());
            stmt.setInt(7, gasto.getC_Metodo_Pago());
            stmt.setInt(8, gasto.getC_TipoMoneda());
            stmt.setString(9, gasto.getD_Destinatario());
            stmt.setInt(10, gasto.getC_TipoTransaccion());

            stmt.execute();
            System.out.println(" Gasto actualizado correctamente.");
        } catch (Exception e) {
            System.out.println(" Error al actualizar gasto: " + e.getMessage());
        }
    }

    public void eliminarGasto(int idGasto, Connection conn) {
        try (CallableStatement stmt = conn.prepareCall("{CALL EliminarGasto(?)}")) {
            stmt.setInt(1, idGasto);
            stmt.execute();
            System.out.println(" Gasto eliminado correctamente.");
        } catch (Exception e) {
            System.out.println(" Error al eliminar gasto: " + e.getMessage());
        }
    }
}
