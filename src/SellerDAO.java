import java.sql.*;
import java.util.Scanner;

public class SellerDAO {
    private Connection conn;

    // Constructor: needs the database connection
    public SellerDAO(Connection conn) {
        this.conn = conn;
    }

    // Add a new seller
    public void add() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Seller ID:");
        int id = sc.nextInt(); sc.nextLine();

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        String sql = "INSERT INTO Seller VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setString(3, address);
        stmt.executeUpdate();

        System.out.println("🍻 cheers，Seller added successfully!");
    }

    // Update an existing seller
    
    public void update() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Seller ID to update:");
        int id = sc.nextInt(); sc.nextLine();

        System.out.println("Enter new Name:");
        String name = sc.nextLine();

        System.out.println("Enter new Address:");
        String address = sc.nextLine();

        String sql = "UPDATE Seller SET name=?, address=? WHERE seller_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, address);
        stmt.setInt(3, id);

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("🥂 Seller updated!");
        } else {
            System.out.println("🤡 Seller ID not found!");
        }
    }

    // Delete a seller
    public void delete() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Seller ID to delete:");
        int id = sc.nextInt();

        String sql = "DELETE FROM Seller WHERE seller_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("🥂  Seller deleted!");
        } else {
            System.out.println("🤡 Seller ID not found!");
        }
    }

    // List all sellers

    public void list() throws SQLException {
        String sql = "SELECT * FROM Seller";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n⚠️ All Sellers:");
        while (rs.next()) {
            int id = rs.getInt("seller_id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            System.out.println(id + " | " + name + " | " + address);
        }
    }
}
