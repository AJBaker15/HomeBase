import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void createDatabaseInstance(Connection conn) throws SQLException, IOException {
        String createSQL = new String(Files.readAllBytes(Paths.get("resources/HomeBase_ShijieTang_create.sql")));
        String insertSQL = new String(Files.readAllBytes(Paths.get("resources/Insert SQL.sql")));

        //run Create statements
        runSQLScript(conn, createSQL);

        //run Insert statements
        runSQLScript(conn, insertSQL);

        System.out.println("Scripts executed successfully");
    }

    public static void runSQLScript(Connection conn, String sql) throws SQLException, IOException {
        Statement stmt = conn.createStatement();
        String[] statements = sql.split(";");
        for (String statement : statements) {
            if(!statement.trim().isEmpty()) {
                stmt.execute(statement);
            }
        }
        stmt.close();
    }
}
