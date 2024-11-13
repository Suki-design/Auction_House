/**
 * Represents a Toy collectible item.
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
     * @param yearEstimate   The estimated years of the item's origin.
     * @param typeOfToy      The type of toy (e.g., car, figurine).
     * @param name           The name of the toy.
     * @param collectionName The name of the collection (optional).
     */
    public Toy(String id, String owner, String condition, double startingPrice, YearEstimate yearEstimate,
               String typeOfToy, String name, String collectionName) {
        super(id, owner, condition, startingPrice, yearEstimate);
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
        return "Toy [ID: " + getId() + ", " + name + " (" + typeOfToy + ")]";
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
        // Type,ID,TypeOfToy,Name,LowEstimate,HighEstimate,Owner,Condition,StartingPrice,CollectionName
        // Example:
        // Toy,002,Vintage Barbie Doll,Toy,Barbie,1980,1985,Carol,Needs Restoring,500.00,
        // Toy,003,Hot Wheels Car,Car,,1982,1986,David,Mint,300.00,Hot Wheels Collection

        final int EXPECTED_ATTRIBUTES = 10; // Including Type

        if (data.length != EXPECTED_ATTRIBUTES) {
            throw new IllegalArgumentException("Invalid number of attributes for Toy. Expected "
                    + EXPECTED_ATTRIBUTES + ", got " + data.length + ".");
        }

        try {
            // Parse common fields from the CSV
            String id = data[1].trim();
            String typeOfToy = data[2].trim();
            String name = data[3].trim();

            // Parse integers for estimates
            int lowEstimate;
            int highEstimate;
            try {
                lowEstimate = Integer.parseInt(data[4].trim());
                highEstimate = Integer.parseInt(data[5].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid year estimate values: " + e.getMessage());
            }

            String owner = data[6].trim();
            String condition = data[7].trim();

            // Validate 'condition'
            if (!condition.equalsIgnoreCase("Mint") &&
                    !condition.equalsIgnoreCase("Restored") &&
                    !condition.equalsIgnoreCase("Needs Restoring")) {
                throw new IllegalArgumentException("Invalid condition: " + condition);
            }

            // Parse starting price
            double startingPrice;
            try {
                startingPrice = Double.parseDouble(data[8].trim());
                if (startingPrice < 0) {
                    throw new IllegalArgumentException("Starting price cannot be negative.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid starting price: " + data[8]);
            }

            // Parse collectionName (optional)
            String collectionName = "";
            if (data[9] != null && !data[9].trim().isEmpty()) {
                collectionName = data[9].trim();
            }

            // Create YearEstimate object
            YearEstimate yearEstimate = new YearEstimate(lowEstimate, highEstimate);

            return new Toy(id, owner, condition, startingPrice, yearEstimate,
                    typeOfToy, name, collectionName);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Missing attributes for Toy: " + e.getMessage());
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
}