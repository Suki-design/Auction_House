package auctionhouse.model;

/**
 * Represents a auctionhouse.model.Toy collectible item.
 */
public class Toy extends Collectible {
    private String typeOfToy;       // e.g., car, figurine, card
    private String name;
    private String collectionName;  // Optional

    /**
     * Constructs a new Toy object with the specified details.
     *
     * @param id             The unique identifier of the item.
     * @param owner          The current owner of the item.
     * @param condition      The condition of the item.
     * @param startingPrice  The starting price for the auction.
     * @param lowEstimate   The lower bound of the year estimate.
     * @param highEstimate  The upper bound of the year estimate.
     * @param typeOfToy      The type of toy (e.g., car, figurine).
     * @param name           The name of the toy.
     * @param collectionName The name of the collection (optional).
     */
    public Toy(String id, String owner, String condition, double startingPrice, int lowEstimate, int highEstimate,
    String typeOfToy, String name, String collectionName) {
        super(id, owner, condition, startingPrice, lowEstimate, highEstimate);
        this.typeOfToy = typeOfToy;
        this.name = name;
        this.collectionName = collectionName;
    }

    // Getters and Setters

    public String getTypeOfToy() {
        return typeOfToy;
    }

    public void setTypeOfToy(String typeOfToy) {
        this.typeOfToy = typeOfToy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    /**
     * Provides a short description of the toy.
     *
     * @return A concise string containing the item's ID and toy details.
     */
    @Override
    public String shortDescription() {
        return "Toy (ID: " + getId() + ", " + name + " " + typeOfToy + " Price: " + getStartingPrice() +")";
    }

    /**
     * Parses a Toy object from CSV data.
     *
     * @param data An array of strings representing the CSV fields.
     * @return A Toy object.
     * @throws IllegalArgumentException If data is invalid or insufficient.
     */
    public static Toy fromCSV(String[] data) throws IllegalArgumentException {
        // Expected CSV Format for Toy:
        // Type,ID,TypeOfToy,Name,LowEstimate,HighEstimate,Owner,Condition,StartingPrice,CollectionName(optional)
        // Example:
        // Toy,002,Vintage Barbie Doll,Toy,Barbie,1980,1985,Carol,Needs Restoring,500.00,
        // Toy,003,Hot Wheels Car,Car,1982,1986,David,Mint,300.00,Hot Wheels Collection

        if (data.length < 9) { // Everything else apart from Collection Name should be provided
            throw new IllegalArgumentException("Missing fields for Toy. Expected at least 9 fields, got " + data.length + ".");
        }

        try {
            String id = data[1].trim();
            String typeOfToy = data[2].trim();
            String name = data[3].trim();

            int lowEstimate = Integer.parseInt(data[4].trim());
            int highEstimate = Integer.parseInt(data[5].trim());

            String owner = data[6].trim();
            String condition = data[7].trim();

            double startingPrice = Double.parseDouble(data[8].trim());
            if (startingPrice < 0) {
                throw new IllegalArgumentException("Starting price cannot be negative.");
            }

            String collectionName = null;
            if (data.length == 10) {
                collectionName = data[9].trim();
            }

            return new Toy(id, owner, condition, startingPrice, lowEstimate, highEstimate, typeOfToy, name, collectionName);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in Toy data: " + e.getMessage());
        }
    }
    /**
     * Returns a string representation of the toy.
     *
     * @return A detailed string containing all attributes of the toy.
     */
    @Override
    public String toString() {
        String collectionInfo = (collectionName != null && !collectionName.isEmpty()) ? ", Collection: " + collectionName : "";
        return super.toString() +
                ", Type of Toy: " + typeOfToy +
                ", Name: " + name +
                collectionInfo;
    }

    @Override
    public String toCSV() {
        String collectionInfo = (collectionName != null && !collectionName.isEmpty()) ? collectionName : "";
        return String.join(",",
                "Toy",                      // Type of Collectible
                super.toCSV(),              // Shared attributes
                name,
                typeOfToy,
                collectionInfo
        );
    }
}