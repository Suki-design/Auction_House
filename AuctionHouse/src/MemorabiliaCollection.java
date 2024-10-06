import java.util.ArrayList;

public class MemorabiliaCollection {
    private ArrayList<Memorabilia> items;

    //constructor to initialize items
    public MemorabiliaCollection(){
        items = new ArrayList<Memorabilia>();
    }

    /**
     * Adds a Memorabilia item to the collection if it doesn't already exist.
     *
     * @param item The Memorabilia item to add.
     * @return true if the item was added; false if it was a duplicate.
     */
    public boolean addItem(Memorabilia item) {
        if (findById(item.getId()) == null) {
            items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Displays all memorabilia items in the collection.
     * Outputs the details of each item to the console.
     */
    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("The collection is empty.");
            return;
        }
        System.out.println("Items in the collection:");
        for (Memorabilia item : items) {
            System.out.println("ID: " + item.getId());
            System.out.println("Personality Name: " + item.getPersonalityName());
            System.out.println("Personality Occupation: " + item.getPersonalityOccupation());
            System.out.println("Object Type: " + item.getObjectType());
            System.out.println("Is Autographed: " + item.isAutographed());
            System.out.println("Estimated Year: " + item.getEstimatedYear());
            System.out.println("Owner: " + item.getOwner());
            System.out.println("Condition: " + item.getCondition());
            System.out.println("Starting Price: " + item.getStartingPrice());
            System.out.println(".........................................");
        }
    }

    /**
     * Finds a Memorabilia item by its ID.
     *
     * @param id The ID of the item to find.
     * @return The Memorabilia item if found; null otherwise.
     */
    public Memorabilia findById(String id) {
        for (Memorabilia item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    //query methods

    public int getNumberOfItems() {
        return items.size();
    }

    public Memorabilia getOldestItem() {
        if (items.isEmpty()) return null;
        Memorabilia oldest = items.getFirst();
        for (Memorabilia item : items) {
            if (item.getEstimatedYear() < oldest.getEstimatedYear()) {
                oldest = item;
            }
        }
        return oldest;
    }

    public Memorabilia getNewestItem() {
        if (items.isEmpty()) return null;
        Memorabilia newest = items.get(0);
        for (Memorabilia item : items) {
            if (item.getEstimatedYear() > newest.getEstimatedYear()) {
                newest = item;
            }
        }
        return newest;
    }

    public Memorabilia getMostExpensiveItem() {
        if (items.isEmpty()) return null;
        Memorabilia mostExpensive = items.get(0);
        for (Memorabilia item : items) {
            if (item.getStartingPrice() > mostExpensive.getStartingPrice()) {
                mostExpensive = item;
            }
        }
        return mostExpensive;
    }

    public Memorabilia getLeastExpensiveItem() {
        if (items.isEmpty()) return null;
        Memorabilia leastExpensive = items.get(0);
        for (Memorabilia item : items) {
            if (item.getStartingPrice() < leastExpensive.getStartingPrice()) {
                leastExpensive = item;
            }
        }
        return leastExpensive;
    }

    public ArrayList<String> getUniqueOwners() {
        ArrayList<String> owners = new ArrayList<>();
        for (Memorabilia item : items) {
            String owner = item.getOwner();
            if (!owners.contains(owner)) {
                owners.add(owner);
            }
        }
        return owners;
    }
    }
