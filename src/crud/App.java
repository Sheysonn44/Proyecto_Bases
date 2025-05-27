package crud;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import Modelo.Gasto;
import dao.GastoDAO;
import java.util.Date;


public class App {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();

        // Cargar el archivo de propiedades
        FileInputStream fis = new FileInputStream("config.properties");
        props.load(fis);
   
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Conexión exitosa");

            //  Gasto gasto = new Gasto(
            //     500.0,
            //     new Date(), // hoy
            //     "Pago de Uber",
            //     1, // categoría transporte
            //     6, // id cuenta bancaria
            //     1 // método pago efectivo            
            // );

            // GastoDAO.insertarGasto(gasto);
         


            conn.close();

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createProduct(Connection conn, String productName, int supplierId, int categoryId,
            String quantityPerUnit, double unitPrice, int unitsInStock) {
        try {
            Statement stmt = conn.createStatement();
            String insertSQL = "INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock) "
                    +
                    "VALUES ('" + productName + "', " + supplierId + ", " + categoryId + ", '" + quantityPerUnit + "', "
                    + unitPrice + ", " + unitsInStock + ")";
            int rowsAffected = stmt.executeUpdate(insertSQL);
            System.out.println("✅ Producto creado, filas afectadas: " + rowsAffected);
            stmt.close();
        } catch (Exception e) {
            System.out.println("❌ Error al crear producto: " + e.getMessage());
        }
    }

    // Método para leer productos
    private static void readProducts(Connection conn, boolean showAll) {
        try {
            Statement stmt = conn.createStatement();
            String query = showAll ? "SELECT * FROM Products" : "SELECT ProductName FROM Products";
            ResultSet rs = stmt.executeQuery(query);
            if (showAll) {
                // si showall es true, muestra todas las columnas de la tabla
                while (rs.next()) {
                    System.out.print("ID: " + rs.getInt("ProductID") + ", ");
                    System.out.print("Nombre: " + rs.getString("ProductName") + ", ");
                    System.out.print("Precio: " + rs.getDouble("UnitPrice") + ", ");
                    System.out.println("Stock: " + rs.getInt("UnitsInStock"));
                }
            } else {
                // si showall es false, muestra solo el nombre del producto
                System.out.println("Lista de Nombres de Productos:");
                while (rs.next()) {
                    System.out.println("Nombre: " + rs.getString("ProductName"));
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error al leer productos: " + e.getMessage());
        }

    }

    private static void updateProduct(Connection conn, int productId, String newProductName) {
        try {
            Statement stmt = conn.createStatement();
            String updateSQL = "UPDATE Products SET ProductName = '" + newProductName + "' WHERE ProductID = "
                    + productId;
            int rowsAffected = stmt.executeUpdate(updateSQL);
            System.out.println("✅ Producto actualizado, filas afectadas: " + rowsAffected);
            stmt.close();
        } catch (Exception e) {
            System.out.println("❌ Error al actualizar producto: " + e.getMessage());
        }
    }

    private static void deleteProduct(Connection conn, int productId) {
        try {
            Statement stmt = conn.createStatement();
            String deleteSQL = "DELETE FROM Products WHERE ProductID = " + productId;
            int rowsAffected = stmt.executeUpdate(deleteSQL);
            System.out.println("✅ Producto eliminado, filas afectadas: " + rowsAffected);
            stmt.close();
        } catch (Exception e) {
            System.out.println("❌ Error al eliminar producto: " + e.getMessage());
        }
    }

}
