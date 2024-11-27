import auctionhouse.gui.CollectibleGUI;
import auctionhouse.model.CollectibleCollection;
import auctionhouse.model.DataLoader;

public class Main {
    public static void main(String[] args) {
        // Initialize the CollectibleCollection
        CollectibleCollection collection = new CollectibleCollection();
        DataLoader dataLoader = new DataLoader();

        // 1. Valid CSV File
        String dataFilename = "AuctionHouse/src/valid_data.csv";

        // 2. CSV File with Missing Fields
        //String dataFilename = ("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\missing_fields.csv";

        // 3. CSV File with Invalid Number Formats
        //String dataFilename = ("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\invalid_numbers.csv";

        // 4. CSV File with Unexpected Condition Values
        //String dataFilename = ("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\unexpected_values.csv";

        //collection.generateStatisticsSummary("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\statistics_summary.txt");

        // Load data from the file
        dataLoader.loadData(dataFilename, collection);


        // Create the GUI and set its content
        CollectibleGUI gui = new CollectibleGUI("Auction House", collection, dataFilename);
        gui.setCollectibleListContent(collection.getItems());
        gui.setVisible(true);

    }
}
