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
     * @param yearEstimate  The estimated years of the item's origin.
     * @param albumName     The name of the album.
     * @param artist        The artist of the album.
     * @param musicGenre    The music genre of the album.
     * @param diameter      The diameter of the vinyl record in inches (7, 10, or 12).
     * @throws IllegalArgumentException If the diameter is not 7, 10, or 12 inches.
     */
    public VinylRecord(String id, String owner, String condition, double startingPrice, YearEstimate yearEstimate,
                       String albumName, String artist, String musicGenre, int diameter) {
        super(id, owner, condition, startingPrice, yearEstimate);
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
     * Returns a string representation of the vinyl record, including all attributes.
     *
     * @return A detailed string containing all attributes of the item.
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
