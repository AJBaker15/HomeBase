import java.sql.*;
import java.util.Scanner;

public class ClientDAO {
    private Connection conn;

    // Constructor
    public ClientDAO(Connection conn) {
        this.conn = conn;
    }


    // Add a new client
    public void addClient() throws SQLException {
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

        System.out.println("Client added successfully!");
    }

    // Update client info
    public void updateClient() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Client ID to update:");
        int id = sc.nextInt();

        System.out.println("Update fields: ");
        System.out.println(" 1. Name ");
        System.out.println(" 2. Address ");
        System.out.println(" 3. Phone Number");
        System.out.println(" 4. Preferred Property Type");
        System.out.println(" 5. Price Range");
        System.out.println(" 6. Preferred Number of Bedrooms");
        System.out.println(" 7. Preferred Number of Bathrooms");
        System.out.println("Enter the number of the field to update:");
        int updateField = sc.nextInt();
        int rows = 0;
        switch (updateField) {
            case 1:
                System.out.println("Enter the new Name:");
                String name = sc.nextLine();
                String sqlName = "UPDATE Client SET name=? WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(sqlName);
                stmt.setString(1, name);
                stmt.setInt(2, id);
                rows = stmt.executeUpdate();
                break;
            case 2:
                System.out.println("Enter the new Address:");
                String address = sc.nextLine();
                String sqlAddress = "UPDATE Client SET address=? WHERE id=?";
                PreparedStatement stmt2 = conn.prepareStatement(sqlAddress);
                stmt2.setString(1, address);
                stmt2.setInt(2, id);
                rows = stmt2.executeUpdate();
                break;
            case 3:
                System.out.println("Enter the new Phone Number:");
                String phone_number = sc.nextLine();
                String sqlPhoneNumber = "UPDATE Client SET phone_number=? WHERE id=?";
                PreparedStatement stmt3 = conn.prepareStatement(sqlPhoneNumber);
                stmt3.setString(1, phone_number);
                stmt3.setInt(2, id);
                rows = stmt3.executeUpdate();
                break;
            case 4:
                System.out.println("Enter the new Preferred Property Type:");
                String pref_property_type = sc.nextLine();
                String sqlPropertyType = "UPDATE Client SET pref_property_type=? WHERE id=?";
                PreparedStatement stmt4 = conn.prepareStatement(sqlPropertyType);
                stmt4.setString(1, pref_property_type);
                stmt4.setInt(2, id);
                rows = stmt4.executeUpdate();
                break;
            case 5:
                System.out.println("Enter the new Price Range:");
                String price_range = sc.nextLine();
                String sqlPriceRange = "UPDATE Client SET price_range=? WHERE id=?";
                PreparedStatement stmt5 = conn.prepareStatement(sqlPriceRange);
                stmt5.setString(1, price_range);
                stmt5.setInt(2, id);
                rows = stmt5.executeUpdate();
                break;
            case 6:
                System.out.println("Enter the new Preferred Number of Bedrooms:");
                int pref_bedrooms = sc.nextInt();
                String sqlBedrooms = "UPDATE Client SET pref_bedrooms=? WHERE id=?";
                PreparedStatement stmt6 = conn.prepareStatement(sqlBedrooms);
                stmt6.setInt(1, pref_bedrooms);
                stmt6.setInt(2, id);
                rows = stmt6.executeUpdate();
                break;
            case 7:
                System.out.println("Enter the new number of Bathrooms: ");
                int pref_bathrooms = sc.nextInt();
                String sqlBathrooms = "UPDATE Client SET pref_bathrooms=? WHERE id=?";
                PreparedStatement stmt7 = conn.prepareStatement(sqlBathrooms);
                stmt7.setInt(1, pref_bathrooms);
                stmt7.setInt(2, id);
                rows = stmt7.executeUpdate();
                break;
            default:
                System.out.println("Please enter a valid selection. ");


        }
        if (rows > 0) {
            System.out.println("🥂 Client updated!");
        } else {
            System.out.println("🤡 Client ID not found!🤡");
        }
    }

    // Delete a client
    public void deleteClient() throws SQLException {
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
    public void listClients() throws SQLException {
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
                            rs.getString("pref_property_type") + " | $" +
                            rs.getString("price_range") + " | " +
                            rs.getInt("pref_bedrooms") + " | " +
                            rs.getInt("pref_bathrooms")
            );
        }
    }
}
