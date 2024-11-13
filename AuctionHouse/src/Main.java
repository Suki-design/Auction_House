public class Main {
    public static void main(String[] args) {
        // Initialize the generic CollectibleCollection
        CollectibleCollection collection = new CollectibleCollection();
        DataLoader dataLoader = new DataLoader();

        // Create some collectible items manually (optional)
        /*
        // Memorabilia
        Memorabilia item1 = new Memorabilia("001", "Elvis Presley", "Singer", "Guitar", true, 1956, "Alice", "Mint", 20000.00);
        Memorabilia item2 = new Memorabilia("002", "Marilyn Monroe", "Actress", "Dress", false, 1962, "Bob", "Restored", 15000.00);
        // Duplicate ID test
        Memorabilia item3 = new Memorabilia("001", "Elvis Presley", "Singer", "Guitar", true, 1956, "Alice", "Mint", 20000.00);
        Memorabilia item4 = new Memorabilia("003", "Walter White", "Actor", "Diary", true, 2007, "Sukat", "Restored", 3000.00);
        // Add items to the collection
        collection.addItem(item1);
        collection.addItem(item2);
        collection.addItem(item3); // Attempt to add duplicate
        collection.addItem(item4);

        // Toy
        Toy toy1 = new Toy("004", "David", "Mint", 300.00, new YearEstimate(1982, 1986), "Car", "Hot Wheels Car", "Hot Wheels Collection");
        collection.addItem(toy1);

        // VinylRecord
        VinylRecord record1 = new VinylRecord("005", "Bob", "Mint", 1500.00, new YearEstimate(1982, 1987),
                "Thriller", "Michael Jackson", "Pop", 12);
        collection.addItem(record1);

        // Sculpture
        Sculpture sculpture1 = new Sculpture("007", "Carol", "Restored", 5000.00, new YearEstimate(1900, 1905),
                "The Thinker", "Marble", 1.8);
        collection.addItem(sculpture1);
        */

        // Load sample data using the loadData method of the DataLoader class

        // 1. Valid CSV File
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\valid_data.csv", collection);

        // 2. CSV File with Missing Fields
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\missing_fields.csv", collection);

        // 3. CSV File with Invalid Number Formats
        dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\invalid_numbers.csv", collection);

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
