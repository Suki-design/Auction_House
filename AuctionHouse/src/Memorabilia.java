/**
 * Represents a memorabilia item, which is a type of Collectible.
 * Contains specific attributes related to memorabilia items.
 */
public class Memorabilia extends Collectible {
    private String personalityName;
    private String personalityOccupation;
    private String objectType;
    private boolean isAutographed;

    /**
     * Constructs a new Memorabilia object with the specified details.
     *
     * @param id                    The unique identifier of the item.
     * @param owner                 The current owner of the item.
     * @param condition             The condition of the item ("Mint", "Restored", "Needs Restoring").
     * @param startingPrice         The starting price for the auction.
     * @param yearEstimate          The estimated years of the item's origin.
     * @param personalityName       The name of the associated personality.
     * @param personalityOccupation The occupation of the personality.
     * @param objectType            The type of object.
     * @param isAutographed         True if the item is autographed; false otherwise.
     */
    public Memorabilia(String id, String owner, String condition, double startingPrice, YearEstimate yearEstimate,
                       String personalityName, String personalityOccupation, String objectType, boolean isAutographed) {
        super(id, owner, condition, startingPrice, yearEstimate);
        this.personalityName = personalityName;
        this.personalityOccupation = personalityOccupation;
        this.objectType = objectType;
        this.isAutographed = isAutographed;
    }

    //Get and set Methods
    public String getPersonalityName() {
        return personalityName;
    }

    public String getPersonalityOccupation() {
        return personalityOccupation;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setPersonalityName(String personalityName) {
        this.personalityName = personalityName;
    }

    public void setPersonalityOccupation(String personalityOccupation) {
        this.personalityOccupation = personalityOccupation;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public void setAutographed(boolean isAutographed) {
        this.isAutographed = isAutographed;
    }

    /**
     * Checks if the item is autographed.
     *
     * @return True if autographed; false otherwise.
     */
    public boolean isAutographed() {
        return isAutographed;
    }


    // Overridden Methods

    /**
     * Provides a short description of the memorabilia item.
     *
     * @return A string containing the item's ID and a brief description.
     */
    @Override
    public String shortDescription() {
        return "Memorabilia [ID: " + getId() + ", " + personalityName + "'s " + objectType + "]";
    }

    /**
     * Returns a string representation of the memorabilia item, including all attributes.
     *
     * @return A detailed string containing all attributes of the item.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Personality Name: " + personalityName +
                ", Personality Occupation: " + personalityOccupation +
                ", Object Type: " + objectType +
                ", Autographed: " + isAutographed;
    }
}
