package mysql_test_db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // URL-ul bazei de date
        String user = "root"; // Utilizatorul
        String password = "1234"; // Parola
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            DatabaseMetaData metaData = connection.getMetaData();

            System.out.println("  Versiunea JDBC:: " + metaData.getJDBCMajorVersion() + " . " + metaData.getJDBCMinorVersion());
            System.out.println("  Nume server baza de date:: " + metaData.getDatabaseProductName());
            System.out.println("  Versiunea MySQL:: " + metaData.getDatabaseProductVersion());
            if (connection != null) {
                System.out.println("Conexiune reușită cu baza de date!");
            }
        } catch (SQLException e) {
            System.out.println("Eroare la conectarea cu baza de date: " + e.getMessage());
        }


    }
}
