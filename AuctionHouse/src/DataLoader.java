import java.io.*;
public class DataLoader {
    //This class is responsible for adding data from a file to the collection
    // Constructor is not needed for this class since  methods will be used directly

    /**
     * Loads data from a CSV file and adds Memorabilia items to the given collection.
     *
     * @param filename   The path to the CSV file.
     * @param collection The MemorabiliaCollection to add items to.
     */
    public void loadData(String filename, MemorabiliaCollection collection) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // For initial verification
                // Parsing will be added in the next step
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
