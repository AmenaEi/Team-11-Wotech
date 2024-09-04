import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.println("Please provide your name:");
        var personsName = sc.nextLine();


        String url = "jdbc:sqlite:my.db";

        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                /*var meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                */

                var statement = conn.createStatement();
                //statement.execute("CREATE TABLE people (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(20))");
                statement.execute("INSERT INTO people (name) VALUES ('" + personsName + "')");
                //DO NOT DO THIS!!! EASY TO HACK!!! --> INSERT INTO people (name) VALUES ('');DROP TABLE people;--')
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}