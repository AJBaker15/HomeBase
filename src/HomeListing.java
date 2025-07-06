
import java.util.ArrayList;
import java.util.Date;

public class HomeListing {
    Date listingDate;
    int homeId;
    int sellerId;
    int agentId;

    static ArrayList<HomeListing> Listings = new ArrayList<>();

    public HomeListing(int homeId, int sellerId, int agentId) {
        this.homeId = homeId;
        this.sellerId = sellerId;
        this.agentId = agentId;
    }

    public static void addListing(int homeId, int sellerId, int agentId) {
        HomeListing newListing = new HomeListing(homeId, sellerId, agentId);
        newListing.listingDate = new Date();
        Listings.add(newListing);
        System.out.println("Listing added successfully");
    }

    public static void getListingByAgent(int agentId) {
        for(HomeListing home : Listings) {
            if(home.agentId == agentId) {
                System.out.println("Listing Date: " + home.listingDate);
                System.out.println("Seller: " + home.sellerId);
                System.out.println("Agent: " + home.agentId);
                System.out.println("ID: " + home.homeId);
            }
        }
    }

    public static void getListingBySeller(int sellerId) {
        for(HomeListing home : Listings) {
            if(home.sellerId == sellerId) {
                System.out.println("Listing Date: " + home.listingDate);
                System.out.println("Seller: " + home.sellerId);
                System.out.println("Agent: " + home.agentId);
                System.out.println("ID: " + home.homeId);

            }
        }
    }

    public static void getListings() {
        for(HomeListing home : Listings) {
            System.out.println("Listing Date: " + home.listingDate);
            System.out.println("Seller: " + home.sellerId);
            System.out.println("Agent: " + home.agentId);
            System.out.println("ID: " + home.homeId);
            System.out.println("---------------------------------");
        }
    }
}
