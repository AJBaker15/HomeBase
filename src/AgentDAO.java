import java.sql.*;
import java.util.Scanner;

public class AgentDAO {
    private Connection conn;

    // Constructor: needs the database connection
    public AgentDAO(Connection conn) {
        this.conn = conn;
    }

    // Add a new agent
    public void add() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Agent ID:");
        int id = sc.nextInt(); sc.nextLine();

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        System.out.println("Enter Phone Number:");
        String phone = sc.nextLine();

        System.out.println("Enter Number of Homes:");
        int homes = sc.nextInt();

        String sql = "INSERT INTO Agent VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setString(3, address);
        stmt.setString(4, phone);
        stmt.setInt(5, homes);
        stmt.executeUpdate();

        System.out.println("🍻 cheers，Agent added successfully!");
    }

    // Update agent's phone number
    public void update() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Agent ID to update:");
        int id = sc.nextInt(); sc.nextLine();

        System.out.println("Enter new Phone Number:");
        String phone = sc.nextLine();

        String sql = "UPDATE Agent SET phone_number=? WHERE agent_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, phone);
        stmt.setInt(2, id);

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("🥂 Agent updated!");
        } else {
            System.out.println("🤡 Agent ID not found!");
        }
    }

    // Delete an agent
    public void delete() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Agent ID to delete:");
        int id = sc.nextInt();

        String sql = "DELETE FROM Agent WHERE agent_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("🥂 Agent deleted!");
        } else {
            System.out.println("🤡 Agent ID not found!");
        }
    }

    // List all agents
    public void list() throws SQLException {
        String sql = "SELECT * FROM Agent";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n⚠️ All Agents:");
        while (rs.next()) {
            int id = rs.getInt("agent_id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String phone = rs.getString("phone_number");
            int homes = rs.getInt("number_of_homes");

            System.out.println(id + " | " + name + " | " + address + " | " + phone + " | Homes: " + homes);
        }
    }
}
