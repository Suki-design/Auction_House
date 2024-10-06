public class Main{

    public static void main(String[] args){

        MemorabiliaCollection collection = new MemorabiliaCollection();

        // Create some memorabilia items
        Memorabilia item1 = new Memorabilia("001", "Elvis Presley", "Singer", "Guitar", true, 1956, "Alice", "Mint", 20000.00);
        Memorabilia item2 = new Memorabilia("002", "Marilyn Monroe", "Actress","Dress", false, 1962, "Bob", "Good", 15000.00);
        // Duplicate ID test
        Memorabilia item3 = new Memorabilia("001", "Elvis Presley", "Singer", "Guitar", true, 1956, "Alice", "Mint", 20000.00);

        // Add items to the collection
        collection.addItem(item1);
        collection.addItem(item2);
        collection.addItem(item3); // Attempt to add duplicate

        // Display the number of items
        System.out.println("Total items in collection: " + collection.getNumberOfItems());


        // Display all items using displayAllItems method
        collection.displayAllItems();
    }
    }