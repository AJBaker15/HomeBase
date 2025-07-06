import java.sql.*;
import java.util.Scanner;

public class ViewingsDAO {
    private Connection conn;

    // Constructor
    public ViewingsDAO(Connection conn) {
        this.conn = conn;
    }

    // Add a new viewing
    public void addViewing() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Viewing ID:");
        int id = sc.nextInt(); sc.nextLine();

        System.out.println("Enter Home ID:");
        int homeVID = sc.nextInt();

        System.out.println("Enter Agent ID:");
        int agentVID = sc.nextInt();

        System.out.println("Enter Seller ID:");
        int sellerVID = sc.nextInt();

        System.out.println("Enter Client ID:");
        int clientVID = sc.nextInt(); sc.nextLine();

        System.out.println("Enter Date of Viewing (YY-MM-DD): ");
        Date vDate = new Date(sc.nextLong());


        String sql = "INSERT INTO Viewing VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setInt(2, homeVID);
        stmt.setInt(3, agentVID);
        stmt.setInt(4, sellerVID);
        stmt.setInt(5, clientVID);
        stmt.setDate(6, vDate);
        stmt.executeUpdate();

        System.out.println("Viewing added successfully!");
    }

    // Update viewing's date
    public void updateViewing() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Viewing ID to update:");
        int id = sc.nextInt();

        System.out.println("Enter new Date (YY-MM-DD): ");
        Date newVDate = new Date(sc.nextInt());

        String sql = "UPDATE Viewing SET view_date=? WHERE veiwing_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDate(1, newVDate);
        stmt.setInt(2, id);

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Viewing Date updated!");
        } else {
            System.out.println("Viewing ID not found!");
        }
    }

    // Delete a viewing
    public void deleteViewing() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Viewing ID to delete:");
        int id = sc.nextInt();

        String sql = "DELETE FROM Viewing WHERE viewing_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Viewing deleted!");
        } else {
            System.out.println("Viewing ID not found!");
        }
    }

    // List all viewings
    public void listAllViewings() throws SQLException {
        String sql = "SELECT * FROM Viewing";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n All Viewings:");
        System.out.println("Viewing ID | Home ID | Agent ID | Seller ID | Client ID | Date of Viewing (YY-MM-DD)");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("viewing_id") + " | " +
                            rs.getString("home_id") + " | " +
                            rs.getInt("agent_id") + " | " +
                            rs.getInt("seller_id") + " | " +
                            rs.getInt("client_id") + " | " +
                            rs.getDate("view_date") + " | "
            );
        }
    }
}
