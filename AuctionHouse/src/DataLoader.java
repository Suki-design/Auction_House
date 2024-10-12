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
                String[] parts = line.split(",");
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }

                //parse and create Memorabilia objects
                //id, personalityName, personalityOccupation, objectType, isAutographed, estimatedYear, owner, condition, startingPrice

                String id = parts[0];
                String personalityName = parts[1];
                String personalityOccupation = parts[2];
                String objectType = parts[3];
                boolean isAutographed = Boolean.parseBoolean(parts[4]);
                int estimatedYear = Integer.parseInt(parts[5]);
                String owner = parts[6];
                String condition = parts[7];
                double startingPrice = Double.parseDouble(parts[8]);

                //call the Memorabilia constructor
                Memorabilia item = new Memorabilia(id, personalityName, personalityOccupation, objectType,isAutographed, estimatedYear, owner, condition, startingPrice);
                collection.addItem(item);


            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
