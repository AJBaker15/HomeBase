import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        HomeListing.addListing(1, 2, 3);
        HomeListing.addListing(4, 5, 6);
        HomeListing.addListing(7, 8, 9);
        HomeListing.addListing(9, 10, 11);

        System.out.println("All Home Listings: ");
        HomeListing.getListings();

        System.out.println("All listing by Seller 2: ");
        HomeListing.getListingBySeller(2);

        System.out.println("All listings by Agent 3: ");
        HomeListing.getListingByAgent(3);
        try {
            ClientDAO client = new ClientDAO(DatabaseConnection.getConnection());
            client.addClient();
            client.updateClient();
            client.listClients();
            client.deleteClient();
        } catch (SQLException sqle) {
            System.out.println("Error in ClientDAO");
            System.out.println(sqle.getMessage());
        }
    }
}
