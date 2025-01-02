package mysql_test_db.mySQLTableCreation;

import java.sql.Connection;
import java.sql.DriverManager;

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
        }
        catch (Exception e){
            System.out.println("  Eroare la conectarea sau la operarea pe baza de date");
            e.printStackTrace();
        }
    }
}
