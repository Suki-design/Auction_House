package auctionhouse.model;

/**
 * Represents a sculpture, which is a type of Collectible.
 * Contains specific attributes related to sculptures.
 */
public class Sculpture extends Collectible {
    private String subject;
    private String material;
    private double height;

    /**
     * Constructs a new Sculpture object with the specified details.
     *
     * @param id            The unique identifier of the item.
     * @param owner         The current owner of the item.
     * @param condition     The condition of the item ("Mint", "Restored", "Needs Restoring").
     * @param startingPrice The starting price for the auction.
     * @param lowEstimate   The lower bound of the year estimate.
     * @param highEstimate  The upper bound of the year estimate.
     * @param subject       The subject the sculpture represents.
     * @param material      The material of the sculpture.
     * @param height        The height of the sculpture in meters.
     */
    public Sculpture(String id, String owner, String condition, double startingPrice, int lowEstimate, int highEstimate,
    String subject, String material, double height) {
        super(id, owner, condition, startingPrice, lowEstimate, highEstimate);
        this.subject = subject;
        this.material = material;
        this.height = height;
    }

    // Get and Set Methods

    public String getSubject() {
        return subject;
    }

    public String getMaterial() {
        return material;
    }

    public double getHeight() {
        return height;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Sets the height of the sculpture.
     *
     * @param height The height in meters (must be positive).
     * @throws IllegalArgumentException If the height is negative or zero.
     */
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height must be a positive value.");
        }
    }

    // Overridden Methods

    /**
     * Provides a short description of the sculpture.
     *
     * @return A string containing the item's ID and sculpture details.
     */
    @Override
    public String shortDescription() {
        return "Sculpture (ID: " + getId() + ", " + subject + " in " + material + " Price: " + getStartingPrice() +")";
    }

    /**
     * Parses a Sculpture object from CSV data.
     *
     * @param data An array of strings representing the CSV fields.
     * @return A Sculpture object.
     * @throws IllegalArgumentException If data is invalid or insufficient.
     */
    public static Sculpture fromCSV(String[] data) throws IllegalArgumentException {
        // Expected CSV Format for Sculpture:
        // Type,ID,Subject,Material,Height,LowEstimate,HighEstimate,Owner,Condition,StartingPrice
        // Example:
        // Sculpture,005,The Thinker,Marble,1.8,1900,1905,Carol,Restored,5000.00

        final int EXPECTED_ATTRIBUTES = 10; // Including Type

        if (data.length != EXPECTED_ATTRIBUTES) {
            throw new IllegalArgumentException("Missing fields for Sculpture. Expected "
                    + EXPECTED_ATTRIBUTES + ", got " + data.length + ".");
        }

        try {
            String id = data[1].trim();
            String subject = data[2].trim();
            String material = data[3].trim();

            double height = Double.parseDouble(data[4].trim());
            if (height <= 0) {
                throw new IllegalArgumentException("Height must be a positive value.");
            }

            int lowEstimate = Integer.parseInt(data[5].trim());
            int highEstimate = Integer.parseInt(data[6].trim());

            String owner = data[7].trim();
            String condition = data[8].trim();

            double startingPrice = Double.parseDouble(data[9].trim());
            if (startingPrice < 0) {
                throw new IllegalArgumentException("Starting price cannot be negative.");
            }

            return new Sculpture(id, owner, condition, startingPrice, lowEstimate, highEstimate,
                    subject, material, height);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in Sculpture data: " + e.getMessage());
        }
    }

    /**
     * Returns a string representation of the sculpture.
     *
     * @return A detailed string containing all attributes of the sculpture.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Subject: " + subject +
                ", Material: " + material +
                ", Height: " + height + " meters";
    }

    @Override
    public String toCSV() {
        return String.join(",",
                "Sculpture",
                super.toCSV(),
                subject,
                material,
                String.valueOf(height)
        );
    }
}