package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import db.Conexion;
import Modelo.Gasto;


/**
 * Clase GatoDAO permite manejar las operaciones relacionadas con los gastos.
 * Permite insertar registros de gasto en la base de datos utilizando procedimientos almacenados.
 */
public class GastoDAO {


 /**
     * Inserta un nuevo gasto en la base de datos utilizando el procedimiento almacenado
     * InsertarGasto_Actualizacion. También actualiza las entidades relacionadas como
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
}


