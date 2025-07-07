import java.sql.*;
import java.util.Scanner;

public class ClientDAO {
    private Connection conn;

    // Constructor
    public ClientDAO(Connection conn) {
        this.conn = conn;
    }

    // Add a new client
    public void add() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Client ID:");
        int id = sc.nextInt(); sc.nextLine();

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        System.out.println("Enter Phone Number:");
        String phone_number = sc.nextLine();

        System.out.println("Enter Preferred Property Type:");
        String pref_property_type = sc.nextLine();

        System.out.println("Enter Price Range:");
        String price_range = sc.nextLine();

        System.out.println("Enter Preferred Number of Bedrooms:");
        int pref_bedrooms = sc.nextInt();

        System.out.println("Enter Preferred Number of Bathrooms:");
        int pref_bathrooms = sc.nextInt();

        String sql = "INSERT INTO Client VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setString(3, address);
        stmt.setString(4, phone_number);
        stmt.setString(5, pref_property_type);
        stmt.setString(6, price_range);
        stmt.setInt(7, pref_bedrooms);
        stmt.setInt(8, pref_bathrooms);
        stmt.executeUpdate();

        System.out.println("🍻 Client added successfully!");
    }

    // Update client info
    public void update() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Client ID to update:");
        int id = sc.nextInt(); sc.nextLine();

        System.out.println("Enter new Phone Number:");
        String phone_number = sc.nextLine();

        String sql = "UPDATE Client SET phone_number=? WHERE client_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, phone_number);
        stmt.setInt(2, id);

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("🥂 Client updated!");
        } else {
            System.out.println("🤡 Client ID not found!");
        }
    }

    // Delete a client
    public void delete() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Client ID to delete:");
        int id = sc.nextInt();

        String sql = "DELETE FROM Client WHERE client_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("🥂 Client deleted!");
        } else {
            System.out.println("🤡 Client ID not found!");
        }
    }

    // List all clients
    public void list() throws SQLException {
        String sql = "SELECT * FROM Client";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n⚠️ All Clients:");
        System.out.println("Client ID | Name | Address | Phone Number | Pref. Type | Price Range | Bedrooms | Bathrooms");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("client_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("address") + " | " +
                    rs.getString("phone_number") + " | " +
                    rs.getString("pref_property_type") + " | " +
                    rs.getString("price_range") + " | " +
                    rs.getInt("pref_bedrooms") + " | " +
                    rs.getInt("pref_bathrooms")
            );
        }
    }
}
