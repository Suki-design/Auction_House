import auctionhouse.gui.CollectibleGUI;
import auctionhouse.model.CollectibleCollection;
import auctionhouse.model.DataLoader;

public class Main {
    public static void main(String[] args) {
        // Initialize the generic auctionhouse.model.CollectibleCollection
        CollectibleCollection collection = new CollectibleCollection();
        DataLoader dataLoader = new DataLoader();

        // 1. Valid CSV File
        dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\valid_data.csv", collection);

        // 2. CSV File with Missing Fields
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\missing_fields.csv", collection);

        // 3. CSV File with Invalid Number Formats
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\invalid_numbers.csv", collection);

        // 4. CSV File with Unexpected Condition Values
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\unexpected_values.csv", collection);

        // Display the number of items in the collection
        //System.out.println("Total items in collection: " + collection.getNumberOfItems());

        // Display all items using the displayAllItems method
        //collection.displayAllItems();

        // Print out unique owners in the collection
        //System.out.println("Unique owners in the collection: " + collection.getUniqueOwners());

        // Generate the statistics summary
        //collection.generateStatisticsSummary("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\statistics_summary.txt");

        // Create the GUI and set its content
        CollectibleGUI gui = new CollectibleGUI("Auction House", collection);
        gui.setVisible(true);
        gui.setCollectibleListContent(collection.getItems());

    }
}
