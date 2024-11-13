import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    //This class is responsible for adding data from a csv file to the collection
    // Constructor is not needed for this class since  methods will be used directly
    //The class will also handle error detection and collect error messages for reporting

    /**
     * Loads data from a CSV file and adds Memorabilia items to the given collection.
     *
     * @param filename   The path to the CSV file.
     * @param collection The MemorabiliaCollection to add items to.
     */
    public void loadData(String filename, CollectibleCollection collection) {
        // List to collect error messages encountered during parsing of file
        List<String> errors = new ArrayList<>();

        // Variable to keep track of the current line number
        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Read the header line first and ignore it
            if ((line = br.readLine()) != null) {
                lineNumber++;
                // Optionally, validate the header here
            }

            while ((line = br.readLine()) != null) {
                lineNumber++;
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Split the line by commas to separate fields
                String[] parts = line.split(",");
                // Trim whitespace from each field
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }

                try {
                    // Create Collectible object using the factory
                    Collectible item = CollectibleCreator.createCollectible(parts);

                    // Attempt to add the item to the collection
                    if (!collection.addItem(item)) {
                        String errorMsg = "Line " + lineNumber + ": Duplicate item ID: " + item.getId();
                        errors.add(errorMsg);
                    }
                } catch (NumberFormatException e) {
                    // Catch invalid number format
                    String errorMsg = "Line " + lineNumber + ": " + e.getMessage();
                    errors.add(errorMsg);
                } catch (IllegalArgumentException e) {
                    // Catch missing fields, invalid types, and invalid condition values
                    String errorMsg = "Line " + lineNumber + ": " + e.getMessage();
                    errors.add(errorMsg);
                } catch (Exception e) {
                    // Catch all other exceptions
                    String errorMsg = "Line " + lineNumber + ": Unexpected error during parsing - " + e.getMessage();
                    errors.add(errorMsg);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return; // Exit the method as there's no data to load
        } catch (IOException e) {
            // Other I/O exception handling
            e.printStackTrace();
            return; // Exit the method as an I/O error occurred
        }

        // Display collected errors to the user
        if (!errors.isEmpty()) {
            System.out.println("Errors encountered while loading data from " + filename + ":");
            for (String error : errors) {
                System.out.println(error);
            }
        } else {
            System.out.println("Data loading completed successfully. Total items loaded: " + collection.getNumberOfItems());
        }
    }
}