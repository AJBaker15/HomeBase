import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("🤡 MySQL JDBC Driver not found!");
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/HomeBaseDB";
        String user = "root";
        String password = "xxxxxx";  // <== change it for your‘s

        return DriverManager.getConnection(url, user, password);
    }
}
