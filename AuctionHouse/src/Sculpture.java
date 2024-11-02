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
     * Returns a string representation of the sculpture, including all attributes.
     *
     * @return A detailed string containing all attributes of the item.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Subject: " + subject +
                ", Material: " + material +
                ", Height: " + height + " meters";
    }
}
