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
     * Parses a Memorabilia object from CSV data.
     *
     * @param data An array of strings representing the CSV fields.
     * @return A Memorabilia object.
     * @throws IllegalArgumentException If data is invalid or insufficient.
     */
    public static Memorabilia fromCSV(String[] data) throws IllegalArgumentException {
        // Expected CSV Format for Memorabilia:
        // Type,ID,PersonalityName,PersonalityOccupation,ObjectType,IsAutographed,LowEstimate,HighEstimate,Owner,Condition,StartingPrice
        // Example:
        // Memorabilia,001,Elvis Presley,Singer,Guitar,true,1950,1956,Alice,Mint,20000.00

        final int EXPECTED_ATTRIBUTES = 11; // Including Type

        if (data.length != EXPECTED_ATTRIBUTES) {
            throw new IllegalArgumentException("Invalid number of attributes for Memorabilia. Expected "
                    + EXPECTED_ATTRIBUTES + ", got " + data.length + ".");
        }

        try {
            // Parse common fields from the superclass
            String id = data[1].trim();
            String owner = data[8].trim();
            String condition = data[9].trim();
            double startingPrice = Double.parseDouble(data[10].trim());

            // Validate 'condition'
            if (!condition.equalsIgnoreCase("Mint") &&
                    !condition.equalsIgnoreCase("Restored") &&
                    !condition.equalsIgnoreCase("Needs Restoring")) {
                throw new IllegalArgumentException("Invalid condition: " + condition);
            }

            // Parse year estimates
            int lowEstimate = Integer.parseInt(data[6].trim());
            int highEstimate = Integer.parseInt(data[7].trim());

            YearEstimate yearEstimate = new YearEstimate(lowEstimate, highEstimate);

            // Parse specific fields
            String personalityName = data[2].trim();
            String personalityOccupation = data[3].trim();
            String objectType = data[4].trim();

            // Parse boolean for isAutographed
            String isAutographedStr = data[5].trim().toLowerCase();
            boolean isAutographed;
            if (isAutographedStr.equals("true") || isAutographedStr.equals("yes")) {
                isAutographed = true;
            } else if (isAutographedStr.equals("false") || isAutographedStr.equals("no")) {
                isAutographed = false;
            } else {
                throw new IllegalArgumentException("Invalid value for isAutographed: " + data[5]);
            }

            return new Memorabilia(id, owner, condition, startingPrice, yearEstimate,
                    personalityName, personalityOccupation, objectType, isAutographed);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in Memorabilia data: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Missing attributes for Memorabilia: " + e.getMessage());
        }
    }

    /**
     * Returns a string representation of the memorabilia.
     *
     * @return A detailed string containing all attributes of the memorabilia.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Personality Name: " + personalityName +
                ", Occupation: " + personalityOccupation +
                ", Object Type: " + objectType +
                ", Autographed: " + isAutographed;
    }
}