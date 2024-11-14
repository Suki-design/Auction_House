/**
 * Represents a vinyl record, which is a type of Collectible.
 * Contains specific attributes related to vinyl records.
 */
public class VinylRecord extends Collectible {
    private String albumName;
    private String artist;
    private String musicGenre;
    private int diameter;

    /**
     * Constructs a new VinylRecord object with the specified details.
     *
     * @param id            The unique identifier of the item.
     * @param owner         The current owner of the item.
     * @param condition     The condition of the item
     * @param startingPrice The starting price for the auction.
     * @param lowEstimate   The lower bound of the year estimate.
     * @param highEstimate  The upper bound of the year estimate.
     * @param albumName     The name of the album.
     * @param artist        The artist of the album.
     * @param musicGenre    The music genre of the album.
     * @param diameter      The diameter of the vinyl record in inches (7, 10, or 12).
     * @throws IllegalArgumentException If the diameter is not 7, 10, or 12 inches.
     */
    public VinylRecord(String id, String owner, String condition, double startingPrice, int lowEstimate, int highEstimate,
    String albumName, String artist, String musicGenre, int diameter) {
        super(id, owner, condition, startingPrice, lowEstimate, highEstimate);
        this.albumName = albumName;
        this.artist = artist;
        this.musicGenre = musicGenre;
        setDiameter(diameter);
    }

    // Get and Set Methods
    public String getAlbumName() {
        return albumName;
    }

    public String getArtist() {
        return artist;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    /**
     * Sets the diameter of the vinyl record.
     *
     * @param diameter The diameter in inches (must be 7, 10, or 12).
     * @throws IllegalArgumentException If the diameter is not 7, 10, or 12 inches.
     */
    public void setDiameter(int diameter) {
        if (diameter == 7 || diameter == 10 || diameter == 12) {
            this.diameter = diameter;
        } else {
            throw new IllegalArgumentException("Invalid diameter. Valid options are 7, 10, or 12 inches.");
        }
    }

    // Overridden Methods

    /**
     * Provides a short description of the vinyl record.
     *
     * @return A  string containing the item's ID and album details.
     */
    @Override
    public String shortDescription() {
        return "VinylRecord [ID: " + getId() + ", " + albumName + " by " + artist + "]";
    }

    /**
     * Parses a VinylRecord object from CSV data.
     *
     * @param data An array of strings representing the CSV fields.
     * @return A VinylRecord object.
     * @throws IllegalArgumentException If data is invalid or insufficient.
     */
    public static VinylRecord fromCSV(String[] data) throws IllegalArgumentException {
        // Expected CSV Format for VinylRecord:
        // Type,ID,AlbumName,Artist,MusicGenre,Diameter,LowEstimate,HighEstimate,Owner,Condition,StartingPrice
        // Example:
        // VinylRecord,004,Thriller,Michael Jackson,Pop,12,1982,1987,Bob,Mint,1500.00

        final int EXPECTED_ATTRIBUTES = 11; // Including Type

        if (data.length != EXPECTED_ATTRIBUTES) {
            throw new IllegalArgumentException("Missing fields for VinylRecord. Expected "
                    + EXPECTED_ATTRIBUTES + ", got " + data.length + ".");
        }

        try {
            String id = data[1].trim();
            String albumName = data[2].trim();
            String artist = data[3].trim();
            String musicGenre = data[4].trim();

            int diameter = Integer.parseInt(data[5].trim());
            if (diameter <= 0) {
                throw new IllegalArgumentException("Diameter must be a positive value.");
            }

            int lowEstimate = Integer.parseInt(data[6].trim());
            int highEstimate = Integer.parseInt(data[7].trim());

            String owner = data[8].trim();
            String condition = data[9].trim();

            double startingPrice = Double.parseDouble(data[10].trim());
            if (startingPrice < 0) {
                throw new IllegalArgumentException("Starting price cannot be negative.");
            }

            return new VinylRecord(id, owner, condition, startingPrice, lowEstimate, highEstimate,
                    albumName, artist, musicGenre, diameter);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in VinylRecord data: " + e.getMessage());
        }
    }

    /**
     * Returns a string representation of the vinyl record.
     *
     * @return A detailed string containing all attributes of the vinyl record.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Album Name: " + albumName +
                ", Artist: " + artist +
                ", Music Genre: " + musicGenre +
                ", Diameter: " + diameter + " inches";
    }
}
