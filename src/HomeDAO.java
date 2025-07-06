import java.sql.*;
import java.util.Scanner;

public class HomeDAO {
    private Connection conn;

    // Constructor
    public HomeDAO(Connection conn) {
        this.conn = conn;
    }

    // Add a new home
    public void add() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Home ID:");
        int id = sc.nextInt(); sc.nextLine();

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        System.out.println("Enter Bedrooms:");
        int beds = sc.nextInt();

        System.out.println("Enter Bathrooms:");
        int baths = sc.nextInt();

        System.out.println("Enter Size (sqft):");
        int sqft = sc.nextInt();

        System.out.println("Enter Lot Size:");
        int lot = sc.nextInt(); sc.nextLine();

        System.out.println("Enter Property Type:");
        String type = sc.nextLine();

        System.out.println("Enter Price:");
        int price = sc.nextInt();

        String sql = "INSERT INTO Home VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, address);
        stmt.setInt(3, beds);
        stmt.setInt(4, baths);
        stmt.setInt(5, sqft);
        stmt.setInt(6, lot);
        stmt.setString(7, type);
        stmt.setInt(8, price);
        stmt.executeUpdate();

        System.out.println("🍻 cheers，Home added successfully!");
    }

    // Update home's price
    public void update() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Home ID to update:");
        int id = sc.nextInt();

        System.out.println("Enter new Price:");
        int price = sc.nextInt();

        String sql = "UPDATE Home SET price=? WHERE home_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, price);
        stmt.setInt(2, id);

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("🥂 Home updated!");
        } else {
            System.out.println("🤡 Home ID not found!🤡");
        }
    }

    // Delete a home
    public void delete() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Home ID to delete:");
        int id = sc.nextInt();

        String sql = "DELETE FROM Home WHERE home_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("🥂 Home deleted!");
        } else {
            System.out.println("🤡 Home ID not found!");
        }
    }

    // List all homes
    public void list() throws SQLException {
        String sql = "SELECT * FROM Home";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n⚠️ All Homes:");
        while (rs.next()) {
            System.out.println(
                rs.getInt("home_id") + " | " +
                rs.getString("address") + " | " +
                rs.getInt("bedrooms") + " beds | " +
                rs.getInt("bathrooms") + " baths | " +
                rs.getInt("size_sqft") + " sqft | " +
                rs.getString("property_type") + " | $" +
                rs.getInt("price")
            );
        }
    }
}
