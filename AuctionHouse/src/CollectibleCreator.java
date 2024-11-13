/**
 * Creator class responsible for creating Collectible objects based on their type.
 */
public class CollectibleCreator {
    /**
     * Creates a Collectible object based on the type specified in the data.
     *
     * @param data An array of strings representing the CSV fields.
     * @return A Collectible object.
     * @throws IllegalArgumentException If the type is unknown or data is invalid.
     */
    public static Collectible createCollectible(String[] data) throws IllegalArgumentException {
        if (data.length < 1) {
            throw new IllegalArgumentException("Missing type field.");
        }

        String type = data[0].trim().toLowerCase();

        switch (type) {
            case "memorabilia":
                return Memorabilia.fromCSV(data);
            case "toy":
                return Toy.fromCSV(data);
            case "vinylrecord":
                return VinylRecord.fromCSV(data);
            case "sculpture":
                return Sculpture.fromCSV(data);
            // Add more cases as new Collectible types are introduced
            default:
                throw new IllegalArgumentException("Unknown Collectible type: " + data[0]);
        }
    }
}
