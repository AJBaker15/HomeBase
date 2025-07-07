import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner sc = new Scanner(System.in);

            // Create DAO objects for each entity
            SellerDAO sellerDAO = new SellerDAO(conn);
            AgentDAO agentDAO = new AgentDAO(conn);
            HomeDAO homeDAO = new HomeDAO(conn);
            ClientDAO clientDAO = new ClientDAO(conn);
            ViewingsDAO viewingsDAO = new ViewingsDAO(conn);

            // Main menu loop
            while (true) {
                System.out.println("\n🌟 === HomeBase Main Menu === 🌟");
                System.out.println("1️⃣ Manage Seller");
                System.out.println("2️⃣ Manage Agent");
                System.out.println("3️⃣ Manage Home");
                System.out.println("4️⃣ Manage Client");
                System.out.println("5️⃣ Manage Viewing");
                System.out.println("6️⃣ Exit");
                System.out.print("👉 Your choice: ");
                int choice = getIntInput(sc);

                if (choice == 1) {
                    runSubMenu(sellerDAO, sc, "Seller");
                } else if (choice == 2) {
                    runSubMenu(agentDAO, sc, "Agent");
                } else if (choice == 3) {
                    runSubMenu(homeDAO, sc, "Home");
                } else if (choice == 4) {
                    runSubMenu(clientDAO, sc, "Client");
                } else if (choice == 5) {
                    runSubMenu(viewingsDAO, sc, "Viewing");
                } else if (choice == 6) {
                    System.out.println("👋 Bye! Thanks for using HomeBase!");
                    break;
                } else {
                    System.out.println("🤡 Invalid choice. Please try again!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the sub-menu for any DAO object.
     * It shows Add / Update / Delete / List / Back options.
     */
    private static void runSubMenu(Object dao, Scanner sc, String name) throws Exception {
        while (true) {
            System.out.println("\n🍀 --- " + name + " Menu --- 🍀");
            System.out.println("1️⃣ Add");
            System.out.println("2️⃣ Update");
            System.out.println("3️⃣ Delete");
            System.out.println("4️⃣ List");
            System.out.println("5️⃣ Back to Main Menu");
            System.out.print("👉 Your choice: ");
            int c = getIntInput(sc);

            if (c == 5) break;

            try {
                if (dao instanceof SellerDAO) {
                    runSellerActions((SellerDAO) dao, c);
                } else if (dao instanceof AgentDAO) {
                    runAgentActions((AgentDAO) dao, c);
                } else if (dao instanceof HomeDAO) {
                    runHomeActions((HomeDAO) dao, c);
                } else if (dao instanceof ClientDAO) {
                    runClientActions((ClientDAO) dao, c);
                } else if (dao instanceof ViewingsDAO) {
                    runViewingsActions((ViewingsDAO) dao, c);
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }

    /**
     * Utility method to safely get an integer input.
     */
    private static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("⚠️ Please enter a number.");
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     * These methods call the correct DAO action based on user choice.
     */
    private static void runSellerActions(SellerDAO dao, int choice) throws Exception {
        if (choice == 1) dao.add();
        else if (choice == 2) dao.update();
        else if (choice == 3) dao.delete();
        else if (choice == 4) dao.list();
        else System.out.println("🤡 Invalid choice.");
    }

    private static void runAgentActions(AgentDAO dao, int choice) throws Exception {
        if (choice == 1) dao.add();
        else if (choice == 2) dao.update();
        else if (choice == 3) dao.delete();
        else if (choice == 4) dao.list();
        else System.out.println("🤡 Invalid choice.");
    }

    private static void runHomeActions(HomeDAO dao, int choice) throws Exception {
        if (choice == 1) dao.add();
        else if (choice == 2) dao.update();
        else if (choice == 3) dao.delete();
        else if (choice == 4) dao.list();
        else System.out.println("🤡 Invalid choice.");
    }

    private static void runClientActions(ClientDAO dao, int choice) throws Exception {
        if (choice == 1) dao.add();
        else if (choice == 2) dao.update();
        else if (choice == 3) dao.delete();
        else if (choice == 4) dao.list();
        else System.out.println("🤡 Invalid choice.");
    }

    private static void runViewingsActions(ViewingsDAO dao, int choice) throws Exception {
        if (choice == 1) dao.add();
        else if (choice == 2) dao.update();
        else if (choice == 3) dao.delete();
        else if (choice == 4) dao.list();
        else System.out.println("🤡 Invalid choice.");
    }
}
