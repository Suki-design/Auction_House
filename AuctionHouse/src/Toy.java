/**
 * Represents a toy, which is a type of Collectible.
 * Contains specific attributes related to toys.
 */
public class Toy extends Collectible {

    private String type;
    private String name;
    private String collectionName;

    /**
     * Constructs a new Toy object with the specified details.
     *
     * @param id             The unique identifier of the item.
     * @param owner          The current owner of the item.
     * @param condition      The condition of the item ("Mint", "Restored", "Needs Restoring").
     * @param startingPrice  The starting price for the auction.
     * @param yearEstimate   The estimated years of the item's origin.
     * @param type           The type of toy.
     * @param name           The name of the toy.
     * @param collectionName The collection name (optional).
     */
    public Toy(String id, String owner, String condition, double startingPrice, YearEstimate yearEstimate,
               String type, String name, String collectionName) {
        super(id, owner, condition, startingPrice, yearEstimate);
        this.type = type;
        this.name = name;
        this.collectionName = collectionName;
    }

    // Get and Set Methods

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    // Overridden Methods

    /**
     * Provides a short description of the toy.
     *
     * @return A concise string containing the item's ID and toy details.
     */
    @Override
    public String shortDescription() {
        return "Toy [ID: " + getId() + ", " + name + " (" + type + ")]";
    }

    /**
     * Returns a string representation of the toy, including all attributes.
     *
     * @return A detailed string containing all attributes of the item.
     */
    @Override
    public String toString() {
        String collectionInfo = (collectionName != null && !collectionName.isEmpty()) ? ", Collection: " + collectionName : "";
        return super.toString() +
                ", Type: " + type +
                ", Name: " + name +
                collectionInfo;
    }
}
