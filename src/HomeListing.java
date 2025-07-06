//using an arraylist here as a way to add functionality without adding a table
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HomeListing {
    Date listingDate;
    int homeId;
    int sellerId;
    int agentId;
    //the list should persist through the program.
    static ArrayList<HomeListing> Listings = new ArrayList<>();

    //Constructor
    public HomeListing(int homeId, int sellerId, int agentId) {
        this.homeId = homeId;
        this.sellerId = sellerId;
        this.agentId = agentId;
    }

    //add a new HomeListing
    public static void addListing(int homeId, int sellerId, int agentId) {
        HomeListing newListing = new HomeListing(homeId, sellerId, agentId);
        newListing.listingDate = new Date();
        Listings.add(newListing);
        System.out.println("Listing added successfully");
    }

    //delete a listing. I used homeID here since it would need to be the essential "key" in this table
    public static void deleteListing(int homeId) {
        boolean found = false;
        for(HomeListing home : Listings) {
            if(home.homeId == homeId) {
                Listings.remove(home);
                found = true;
                System.out.println("Listing deleted successfully");
            }
        }
        if(!found) {
            System.out.println("Listing not found!");
        }

    }

    //update an existing listing
    public static void updateListing(int homeId) {
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new AgentID: ");
        int agentId = sc.nextInt();
        System.out.println("Enter new SellerID: ");
        int sellerId = sc.nextInt();

        for(HomeListing home : Listings) {
            if(home.homeId == homeId) {
                home.agentId = agentId;
                home.sellerId = sellerId;
                home.listingDate = new Date();
                found = true;
                System.out.println("Listing updated successfully");
            }
        }
        if(!found) {
            System.out.println("Listing not found!");
        }
    }

    //Get a listing by an Agent ID number
    public static void getListingByAgent(int agentId) {
        boolean found = false;
        for(HomeListing home : Listings) {
            if(home.agentId == agentId) {
                found = true;
                System.out.println("Listing Date: " + home.listingDate);
                System.out.println("Seller: " + home.sellerId);
                System.out.println("Agent: " + home.agentId);
                System.out.println("ID: " + home.homeId);
            }
        }
        if(!found) {
            System.out.println("Agent not found!");
        }
    }

    //get a listing by a Seller ID number
    public static void getListingBySeller(int sellerId) {
        boolean found = false;
        for(HomeListing home : Listings) {
            if(home.sellerId == sellerId) {
                found = true;
                System.out.println("Listing Date: " + home.listingDate);
                System.out.println("Seller: " + home.sellerId);
                System.out.println("Agent: " + home.agentId);
                System.out.println("ID: " + home.homeId);

            }
        }
        if(!found) {
            System.out.println("Seller not found!");
        }
    }

    //show all the listings
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
