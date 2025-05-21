import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();

        FileInputStream fis = new FileInputStream("config.properties");
        props.load(fis);
       /* 
       String url = "jdbc:sqlserver://localhost:1433;databaseName=Northwind;user=gato;password=1234;Encrypt=true;trustServerCertificate=true";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Northwind;encrypt=true;trustServerCertificate=true";
        String user = "gato";
        String password = "1234"; 
       
       
       */      
         String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");          

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("✅ Conexión exitosa");
/* 
            Statement stmt = conn.create Statement();
            //ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            String insertSQL = "INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock) " +
                               "VALUES ('Producto prueba', 1, 1, '10 cajas', 20.00, 100)";

            int rowsAffected = stmt.executeUpdate(insertSQL);
            System.out.println("✅ Inserción exitosa, filas afectadas: " + rowsAffected);

            ResultSet rs = stmt.executeQuery("SELECT * FROM Products ");

            while (rs.next()) {
                System.out.println("Productos: " + rs.getString(2)); 
            }

            rs.close();
            stmt.close();
            conn.close();

**/

            // Crear un producto
            //createProduct(conn, "producto par probar", 1, 1, "9 cajas", 20.00, 100);

            // Leer productos
          readProducts(conn,true);

            // Actualizar un producto
           //updateProduct(conn, 81, "Producto actualizado");

            // Eliminar un producto
          // deleteProduct(conn, 80);

            conn.close();



        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

   private static void createProduct(Connection conn, String productName, int supplierId, int categoryId, String quantityPerUnit, double unitPrice, int unitsInStock) {
        try {
            Statement stmt = conn.createStatement();
            String insertSQL = "INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock) " +
                               "VALUES ('" + productName + "', " + supplierId + ", " + categoryId + ", '" + quantityPerUnit + "', " + unitPrice + ", " + unitsInStock + ")";
            int rowsAffected = stmt.executeUpdate(insertSQL);
            System.out.println("✅ Producto creado, filas afectadas: " + rowsAffected);
            stmt.close();
        } catch (Exception e) {
            System.out.println("❌ Error al crear producto: " + e.getMessage());
        }
    }

   private static void readProducts(Connection conn, boolean showAll) {
        try {
            Statement stmt = conn.createStatement();
            String query = showAll ? "SELECT * FROM Products" : "SELECT ProductName FROM Products";
            ResultSet rs = stmt.executeQuery(query);
            if (showAll) {
                //si showall es true, muestra todas las columnas de la tabla
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
            String updateSQL = "UPDATE Products SET ProductName = '" + newProductName + "' WHERE ProductID = " + productId;
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
