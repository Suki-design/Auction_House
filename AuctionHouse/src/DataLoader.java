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
    public void loadData(String filename, MemorabiliaCollection collection) {
        //List to collect error messages encountered during parsing of file
        List<String> errors = new ArrayList<>();

        //variable to keep track of the current line number
        int lineNumber =0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber ++;
                //split the line by commas to separate fields
                String[] parts = line.split(",");
                //Trim whitespace from each field
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }

                //this block checks if the line has the expected number of fields (9)
                try {
                    if (parts.length < 9) {
                        throw new IllegalArgumentException("Missing fields");
                    }

                    //parse and create Memorabilia objects
                    //id, personalityName, personalityOccupation, objectType, isAutographed, estimatedYear, owner, condition, startingPrice
                    String id = parts[0];
                    String personalityName = parts[1];
                    String personalityOccupation = parts[2];
                    String objectType = parts[3];
                    boolean isAutographed = Boolean.parseBoolean(parts[4]);
                    int estimatedYear;
                    try {
                        estimatedYear = Integer.parseInt(parts[5]);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Invalid estimated year: " + parts[5]);
                    }
                    String owner = parts[6];
                    String condition = parts[7];
                    //Validate 'condition' to ensure it matches expected set values

                    if (!condition.equals("Mint") && !condition.equals("Restored") && !condition.equals("Needs Restoring")) {
                        throw new IllegalArgumentException("Invalid condition: " + condition);
                    }

                    double startingPrice;
                    //handle invalid number format
                    try {
                        startingPrice = Double.parseDouble(parts[8]);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Invalid starting price: " + parts[8]);
                    }

                    //call the Memorabilia constructor to create new Memorabila object
                    Memorabilia item = new Memorabilia(id, personalityName, personalityOccupation, objectType, isAutographed, estimatedYear, owner, condition, startingPrice);

                    if (!collection.addItem(item)) {
                        String errorMsg = "Line" + lineNumber + ": Duplicate item ID: " + id;
                        errors.add(errorMsg);
                    }

                }catch (NumberFormatException e) {
                    //catch invalid number format
                    String errorMsg = "line " + lineNumber + ": " + e.getMessage();
                    errors.add(errorMsg);
                }catch (IllegalArgumentException e){
                    //catch missing fields and Invalid condition values
                    String errorMsg = "Line "+ lineNumber + ": " + e.getMessage();
                    errors.add(errorMsg);
                }catch (Exception e){
                    //catch all other exceptions
                    String errorMsg= "Line "+ lineNumber + ": Unexpected error during parsing "+ e.getMessage();
                    errors.add(errorMsg);
                }
                }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            //Other I/O exception handling
            e.printStackTrace();
        }

        //display collected errors to the user
        if(!errors.isEmpty()){
            System.out.println(" These errors were encountered while loading data from "+ filename +": ");
            for (String error: errors){
                System.out.println(error);
            }
        }

    }
}
