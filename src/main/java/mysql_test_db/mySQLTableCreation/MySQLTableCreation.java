package mysql_test_db.mySQLTableCreation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class MySQLTableCreation {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "1234";

        try(Connection connection = DriverManager.getConnection(url,username,password)) {
            //Crearea tabelei
            String createTable = """
                    CREATE TABLE IF NOT EXISTS produse(
                    id int auto_increment primary key,
                    name varchar(50) not null,
                    price decimal(10,2) not null);
                    """;
            try (Statement statement = connection.createStatement()){
                statement.execute(createTable);
                System.out.println("  Tabela produse a fost creata cu succes.");
            }
            // Inserarea rindurilor folosind PreparedStatement
            String insertSQL = "INSERT INTO produse (name, price) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setString(1, "Laptop");
                preparedStatement.setBigDecimal(2, new java.math.BigDecimal("2999.99"));
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "Telefon");
                preparedStatement.setBigDecimal(2, new java.math.BigDecimal("999.99"));
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "Tabletă");
                preparedStatement.setBigDecimal(2, new java.math.BigDecimal("1499.99"));
                preparedStatement.executeUpdate();

                System.out.println("Rindurile au fost inserate cu succes!");
            }
        }
        catch (Exception e){
            System.out.println("  Eroare la conectarea sau la operarea pe baza de date");
            e.printStackTrace();
        }
    }
}
