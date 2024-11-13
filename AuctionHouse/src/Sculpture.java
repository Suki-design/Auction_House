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
     * @param yearEstimate  The estimated years of the item's origin.
     * @param subject       The subject the sculpture represents.
     * @param material      The material of the sculpture.
     * @param height        The height of the sculpture in meters.
     */
    public Sculpture(String id, String owner, String condition, double startingPrice, YearEstimate yearEstimate,
                     String subject, String material, double height) {
        super(id, owner, condition, startingPrice, yearEstimate);
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
        return "Sculpture [ID: " + getId() + ", " + subject + " in " + material + "]";
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

            // Parse double for height
            double height;
            try {
                height = Double.parseDouble(data[4].trim());
                if (height <= 0) {
                    throw new IllegalArgumentException("Height must be a positive value.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid height: " + data[4]);
            }

            // Parse integers for estimates
            int lowEstimate;
            int highEstimate;
            try {
                lowEstimate = Integer.parseInt(data[5].trim());
                highEstimate = Integer.parseInt(data[6].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid year estimate values: " + e.getMessage());
            }

            String owner = data[7].trim();
            String condition = data[8].trim();

            // Validate 'condition'
            if (!condition.equalsIgnoreCase("Mint") &&
                    !condition.equalsIgnoreCase("Restored") &&
                    !condition.equalsIgnoreCase("Needs Restoring")) {
                throw new IllegalArgumentException("Invalid condition: " + condition);
            }

            // Parse starting price
            double startingPrice;
            try {
                startingPrice = Double.parseDouble(data[9].trim());
                if (startingPrice < 0) {
                    throw new IllegalArgumentException("Starting price cannot be negative.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid starting price: " + data[9]);
            }

            // Create YearEstimate object
            YearEstimate yearEstimate = new YearEstimate(lowEstimate, highEstimate);

            return new Sculpture(id, owner, condition, startingPrice, yearEstimate,
                    subject, material, height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in Toy data: " + e.getMessage());
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
}