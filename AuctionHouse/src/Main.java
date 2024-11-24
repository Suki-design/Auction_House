import auctionhouse.model.CollectibleCollection;
import auctionhouse.model.DataLoader;

public class Main {
    public static void main(String[] args) {
        // Initialize the generic auctionhouse.model.CollectibleCollection
        CollectibleCollection collection = new CollectibleCollection();
        DataLoader dataLoader = new DataLoader();

        // Create some collectible items manually (optional)
        /*
        // auctionhouse.model.Memorabilia
        auctionhouse.model.Memorabilia item1 = new auctionhouse.model.Memorabilia("001", "Elvis Presley", "Singer", "Guitar", true, 1956, "Alice", "Mint", 20000.00);
        auctionhouse.model.Memorabilia item2 = new auctionhouse.model.Memorabilia("002", "Marilyn Monroe", "Actress", "Dress", false, 1962, "Bob", "Restored", 15000.00);
        // Duplicate ID test
        auctionhouse.model.Memorabilia item3 = new auctionhouse.model.Memorabilia("001", "Elvis Presley", "Singer", "Guitar", true, 1956, "Alice", "Mint", 20000.00);
        auctionhouse.model.Memorabilia item4 = new auctionhouse.model.Memorabilia("003", "Walter White", "Actor", "Diary", true, 2007, "Sukat", "Restored", 3000.00);
        // Add items to the collection
        collection.addItem(item1);
        collection.addItem(item2);
        collection.addItem(item3); // Attempt to add duplicate
        collection.addItem(item4);

        // auctionhouse.model.Toy
        auctionhouse.model.Toy toy1 = new auctionhouse.model.Toy("004", "David", "Mint", 300.00, new auctionhouse.model.YearEstimate(1982, 1986), "Car", "Hot Wheels Car", "Hot Wheels Collection");
        collection.addItem(toy1);

        // auctionhouse.model.VinylRecord
        auctionhouse.model.VinylRecord record1 = new auctionhouse.model.VinylRecord("005", "Bob", "Mint", 1500.00, new auctionhouse.model.YearEstimate(1982, 1987),
                "Thriller", "Michael Jackson", "Pop", 12);
        collection.addItem(record1);

        // auctionhouse.model.Sculpture
        auctionhouse.model.Sculpture sculpture1 = new auctionhouse.model.Sculpture("007", "Carol", "Restored", 5000.00, new auctionhouse.model.YearEstimate(1900, 1905),
                "The Thinker", "Marble", 1.8);
        collection.addItem(sculpture1);
        */

        // Load sample data using the loadData method of the auctionhouse.model.DataLoader class

        // 1. Valid CSV File
        dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\valid_data.csv", collection);

        // 2. CSV File with Missing Fields
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\missing_fields.csv", collection);

        // 3. CSV File with Invalid Number Formats
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\invalid_numbers.csv", collection);

        // 4. CSV File with Unexpected Condition Values
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\unexpected_values.csv", collection);

        // Display the number of items in the collection
        System.out.println("Total items in collection: " + collection.getNumberOfItems());

        // Display all items using the displayAllItems method
        collection.displayAllItems();

        // Print out unique owners in the collection
        System.out.println("Unique owners in the collection: " + collection.getUniqueOwners());

        // Generate the statistics summary
        collection.generateStatisticsSummary("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\statistics_summary.txt");
    }
}
