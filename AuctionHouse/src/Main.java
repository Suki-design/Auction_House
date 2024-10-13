public class Main{

    public static void main(String[] args){

        MemorabiliaCollection collection = new MemorabiliaCollection();
        DataLoader dataLoader = new DataLoader();

        // Create some memorabilia items
        /*Memorabilia item1 = new Memorabilia("001", "Elvis Presley", "Singer", "Guitar", true, 1956, "Alice", "Mint", 20000.00);
        Memorabilia item2 = new Memorabilia("002", "Marilyn Monroe", "Actress","Dress", false, 1962, "Bob", "Good", 15000.00);
        // Duplicate ID test
        Memorabilia item3 = new Memorabilia("001", "Elvis Presley", "Singer", "Guitar", true, 1956, "Alice", "Mint", 20000.00);
        Memorabilia item4 = new Memorabilia("003", "Walter White","Actor", "Diary",true,2007, "Sukat","Good", 3000.00 );
        // Add items to the collection
        collection.addItem(item1);
        collection.addItem(item2);
        collection.addItem(item3);// Attempt to add duplicate
        collection.addItem(item4);*/


        //load sample data using the loadData method of the dataLoader class
        //1. Non-corrupted csv
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\memorabilia_data.csv", collection);
        //2. file with some missing fields
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\missing_fields.csv", collection);
        //3. File with strings instead of numbers
        //dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\invalid_numbers.csv", collection);
        //4. unexpected condition category values
        // dataLoader.loadData("C:\\Users\\Favour Sukat\\f21sfcode\\coursework\\AuctionHouse\\src\\unexpected_values.csv", collection);
        // Display the number of items
        System.out.println("Total items in collection: " + collection.getNumberOfItems());


        // Display all items using displayAllItems method
        collection.displayAllItems();

        //Print out  Oldest Item
        Memorabilia oldestItem = collection.getOldestItem();
        if (oldestItem != null) {
            System.out.println("Oldest Item ID: " + oldestItem.getId());
        } else {
            System.out.println("The collection is empty.");
        };

        //Print out Newest Item
        Memorabilia newestItem = collection.getNewestItem();
        if (newestItem != null) {
            System.out.println("Newest Item ID: " + newestItem.getId());
        } else {
            System.out.println("The collection is empty.");
        };

        //Print out Least Expensive Item
        Memorabilia leastExpensiveItem = collection.getLeastExpensiveItem();
        if (leastExpensiveItem != null) {
            System.out.println("Least Expensive Item ID: " + leastExpensiveItem.getId());
        } else {
            System.out.println("The collection is empty.");
        }

        //Print out Most Expensive Item
        System.out.println("Most Expensive Item in the collection: " +collection.getMostExpensiveItem());

        //Print out  Unique Owners in the collection
        System.out.println("Unique owners in the collection: " + collection.getUniqueOwners());

        //Generate the statistics summary
        collection.generateStatisticsSummary("statistics_summary.txt");
    }
    }