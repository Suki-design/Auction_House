package auctionhouse.model;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

/**
 * Manages a collection of Collectible items.
 */
public class CollectibleCollection {
    private ArrayList<Collectible> items;


    /**
     * instantiate the list
     */
    public CollectibleCollection() {
        items = new ArrayList<>();
    }

    /**
     * Returns the list of collectible items.
     */
    public ArrayList<Collectible> getItems() {
        return items;
    }

    /**
     * Adds a Collectible item to the collection if it is not duplicated
     * @param item The auctionhouse.model.Collectible item to add.
     * @return true if the item was added; false if it was a duplicate.
     * @throws IllegalArgumentException If the item is null.
     */
    public boolean addItem(Collectible item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add a null item to the collection.");
        }
        if (findById(item.getId()) == null) {
            items.add(item);
            return true;
        }
        return false;
    }
    
    /**
     * finds a Collectible item by its ID.
     * @param id The ID of the item to find.
     * @return The Collectible item if found; null if not found.
     */
    public Collectible findById(String id) {
        for (Collectible item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    // Query methods

    /**
     * gets the total number of items in the collection.
     * @return The number of items.
     */
    public int getNumberOfItems() {
        return items.size();
    }

    /**
     * gets the oldest item based on the low year estimate.
     * @return The oldest Collectible item.
     */
    public Collectible getOldestByLowEstimate() {
        if (items.isEmpty()) return null;

        Collectible oldest = items.get(0);
        int oldestLowEstimate = oldest.getYearEstimate().getLowEstimate();

        for (int i = 1; i < items.size(); i++) {
            Collectible item = items.get(i);
            int itemLowEstimate = item.getYearEstimate().getLowEstimate();
            if (itemLowEstimate < oldestLowEstimate) {
                oldest = item;
                oldestLowEstimate = itemLowEstimate;
            }
        }
        return oldest;
    }

    /**
     * gets the newest item based on the high year estimate.
     * @return The newest Collectible item.
     */
    public Collectible getNewestByHighEstimate() {
        if (items.isEmpty()) return null;

        Collectible newest = items.get(0);
        int newestHighEstimate = newest.getYearEstimate().getHighEstimate();

        for (int i = 1; i < items.size(); i++) {
            Collectible item = items.get(i);
            int itemHighEstimate = item.getYearEstimate().getHighEstimate();
            if (itemHighEstimate > newestHighEstimate) {
                newest = item;
                newestHighEstimate = itemHighEstimate;
            }
        }
        return newest;
    }

    /**
     * gets the oldest item based on the middle year estimate.
     * @return The oldest Collectible item by middle estimate.
     */
    public Collectible getOldestByMiddleEstimate() {
        if (items.isEmpty()) return null;

        Collectible oldest = items.get(0);
        int oldestMiddleEstimate = oldest.getYearEstimate().getMiddleEstimate();

        for (int i = 1; i < items.size(); i++) {
            Collectible item = items.get(i);
            int itemMiddleEstimate = item.getYearEstimate().getMiddleEstimate();
            if (itemMiddleEstimate < oldestMiddleEstimate) {
                oldest = item;
                oldestMiddleEstimate = itemMiddleEstimate;
            }
        }
        return oldest;
    }

    /**
     * gets the newest item based on the middle year estimate.
     * @return The newest Collectible item by middle estimate.
     */
    public Collectible getNewestByMiddleEstimate() {
        if (items.isEmpty()) return null;

        Collectible newest = items.get(0);
        int newestMiddleEstimate = newest.getYearEstimate().getMiddleEstimate();

        for (int i = 1; i < items.size(); i++) {
            Collectible item = items.get(i);
            int itemMiddleEstimate = item.getYearEstimate().getMiddleEstimate();
            if (itemMiddleEstimate > newestMiddleEstimate) {
                newest = item;
                newestMiddleEstimate = itemMiddleEstimate;
            }
        }
        return newest;
    }

    /**
     * gets the most expensive item based on starting price.
     * @return The most expensive Collectible item.
     */
    public Collectible getMostExpensiveItem() {
        if (items.isEmpty()) return null;

        Collectible mostExpensive = items.get(0);
        double highestPrice = mostExpensive.getStartingPrice();

        for (int i = 1; i < items.size(); i++) {
            Collectible item = items.get(i);
            double itemPrice = item.getStartingPrice();
            if (itemPrice > highestPrice) {
                mostExpensive = item;
                highestPrice = itemPrice;
            }
        }
        return mostExpensive;
    }

    /**
     * gets the least expensive item based on starting price.
     * @return The least expensive Collectible item.
     */
    public Collectible getLeastExpensiveItem() {
        if (items.isEmpty()) return null;

        Collectible leastExpensive = items.get(0);
        double lowestPrice = leastExpensive.getStartingPrice();

        for (int i = 1; i < items.size(); i++) {
            Collectible item = items.get(i);
            double itemPrice = item.getStartingPrice();
            if (itemPrice < lowestPrice) {
                leastExpensive = item;
                lowestPrice = itemPrice;
            }
        }
        return leastExpensive;
    }

    /**
     * calculates the average starting price of all items in the collection.
     * @return The average starting price.
     */
    private double calculateAverageStartingPrice() {
        if (items.isEmpty()) return 0.0;
        double total = 0.0;
        for (Collectible item : items) {
            total += item.getStartingPrice();
        }
        return total / items.size();
    }

    /**
     * Calculates the standard deviation of starting prices.
     * Someone solved a similar question on StackOverflow which I have modified to the method below
     * <a href="https://stackoverflow.com/questions/37930631/standard-deviation-of-an-arraylist">...</a>
     * @return The standard deviation of starting prices.
     */
    private double calculateStandardDeviationStartingPrice() {
        if (items.isEmpty()) return 0.0;
        double average = calculateAverageStartingPrice();
        double sumSquaredDiffs = 0.0;
        for (Collectible item : items) {
            double diff = item.getStartingPrice() - average;
            sumSquaredDiffs += diff * diff;
        }
        return Math.sqrt(sumSquaredDiffs / items.size());
    }

    /**
     * gets a summary of item counts by condition.
     * @return A string summarizing the counts by condition.
     */
    private String getConditionCount() {
        int mintCount = 0;
        int restoredCount = 0;
        int needsRestoringCount = 0;

        for (Collectible item : items) {
            String condition = item.getCondition();
            if (condition.equalsIgnoreCase("Mint")) {
                mintCount++;
            } else if (condition.equalsIgnoreCase("Restored")) {
                restoredCount++;
            } else if (condition.equalsIgnoreCase("Needs Restoring")) {
                needsRestoringCount++;
            }
        }

        StringBuilder conditionSummary = new StringBuilder();
        conditionSummary.append("Mint: ").append(mintCount).append("\n");
        conditionSummary.append("Restored: ").append(restoredCount).append("\n");
        conditionSummary.append("Needs Restoring: ").append(needsRestoringCount).append("\n");
        return conditionSummary.toString();
    }

    /**
     * returns the top 3 items with the largest differences between high and low year estimates.
     */
    public ArrayList<Collectible> getTopThreeYearEstimateDifferences() {
        //create a copy of the items in a new arrayList
        ArrayList<Collectible> sortedItems = new ArrayList<>(items);

        // useYearDifferenceComparator class for sorting
        Collections.sort(sortedItems, new YearDifferenceComparator());
        // put the top 3 in a collection
        ArrayList<Collectible> topThree = new ArrayList<>();
        for (int i = 0; i < 3 && i < sortedItems.size(); i++) {
            topThree.add(sortedItems.get(i));
        }
        return topThree;
    }


    /**
     * generates a statistics summary and writes it to a text file.
     * @param filename The name of the file to write the summary to.
     */
    public void generateStatisticsSummary(String filename) {
        StringBuilder summary = new StringBuilder();

        // Total number of items
        int totalItems = getNumberOfItems();
        summary.append("Total Number of Items: ").append(totalItems).append("\n\n");

        // Oldest Item by Low Estimate
        Collectible oldestByLow = getOldestByLowEstimate();
        if (oldestByLow != null) {
            YearEstimate oldestLowYear = oldestByLow.getYearEstimate();
            summary.append("Oldest Item (Low Estimate):\n")
                    .append(oldestByLow.shortDescription())
                    .append(" (Year: ").append(oldestLowYear.getLowEstimate()).append(")\n\n");
        } else {
            summary.append("Oldest Item (Low Estimate):\nNo data available.\n\n");
        }

        // Newest Item by High Estimate
        Collectible newestByHigh = getNewestByHighEstimate();
        if (newestByHigh != null) {
            YearEstimate newestHighYear = newestByHigh.getYearEstimate();
            summary.append("Newest Item (High Estimate):\n")
                    .append(newestByHigh.shortDescription())
                    .append(" (Year: ").append(newestHighYear.getHighEstimate()).append(")\n\n");
        } else {
            summary.append("Newest Item (High Estimate):\nNo data available.\n\n");
        }

        // Oldest Item by Middle Estimate
        Collectible oldestByMiddle = getOldestByMiddleEstimate();
        if (oldestByMiddle != null) {
            YearEstimate oldestMiddleYear = oldestByMiddle.getYearEstimate();
            int middleEstimate = oldestMiddleYear.getMiddleEstimate();
            summary.append("Oldest Item (Middle Estimate):\n")
                    .append(oldestByMiddle.shortDescription())
                    .append(" (Year: ").append(middleEstimate).append(")\n\n");
        } else {
            summary.append("Oldest Item (Middle Estimate):\nNo data available.\n\n");
        }

        // Newest Item by Middle Estimate
        Collectible newestByMiddle = getNewestByMiddleEstimate();
        if (newestByMiddle != null) {
            YearEstimate newestMiddleYear = newestByMiddle.getYearEstimate();
            int middleEstimate = newestMiddleYear.getMiddleEstimate();
            summary.append("Newest Item (Middle Estimate):\n")
                    .append(newestByMiddle.shortDescription())
                    .append(" (Year: ").append(middleEstimate).append(")\n\n");
        } else {
            summary.append("Newest Item (Middle Estimate):\nNo data available.\n\n");
        }

        // Most Expensive Item
        Collectible mostExpensiveItem = getMostExpensiveItem();
        if (mostExpensiveItem != null) {
            double price = mostExpensiveItem.getStartingPrice();
            summary.append("Most Expensive Item:\n")
                    .append(mostExpensiveItem.shortDescription())
                    .append(" (Price: $").append(String.format("%.2f", price)).append(")\n\n");
        } else {
            summary.append("Most Expensive Item:\nNo data available.\n\n");
        }

        // Least Expensive Item
        Collectible leastExpensiveItem = getLeastExpensiveItem();
        if (leastExpensiveItem != null) {
            double price = leastExpensiveItem.getStartingPrice();
            summary.append("Least Expensive Item:\n")
                    .append(leastExpensiveItem.shortDescription())
                    .append(" (Price: $").append(String.format("%.2f", price)).append(")\n\n");
        } else {
            summary.append("Least Expensive Item:\nNo data available.\n\n");
        }

        // Average Starting Price
        double averagePrice = calculateAverageStartingPrice();
        summary.append("Average Starting Price: $").append(String.format("%.2f", averagePrice)).append("\n\n");

        // Standard Deviation of Starting Prices
        double stdDeviation = calculateStandardDeviationStartingPrice();
        summary.append("Standard Deviation of Starting Prices: $").append(String.format("%.2f", stdDeviation)).append("\n\n");

        // Items by Condition
        String conditionSummary = getConditionCount();
        summary.append("Items by Condition:\n").append(conditionSummary).append("\n");

        // Top 3 Items with Largest Year Estimate Differences
        ArrayList<Collectible> topDifferences = getTopThreeYearEstimateDifferences();
        summary.append("Top 3 Items with Largest Year Estimate Differences:\n");
        for (Collectible item : topDifferences) {
            YearEstimate yearEstimate = item.getYearEstimate();
            int difference = yearEstimate.getHighEstimate() - yearEstimate.getLowEstimate();
            summary.append(item.shortDescription())
                    .append(" (Difference: ").append(difference).append(" years)\n");
        }

        // Write the summary to the specified file
        writeToFile(filename, summary.toString());
    }

    /**
     * Writes content to a file.
     *
     * @param filename The name of the file.
     * @param content  The content to write.
     */
    private void writeToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("Statistics summary written to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the statistics summary to file: " + e.getMessage());
        }
    }

    /**
     * Saves the collection data to a CSV file.
     *
     * @param filename The name of the file to save the data to.
     */
    public void saveData(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Collectible item : items) {
                writer.write(item.toCSV() + "\n");
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred " + e.getMessage());
    }
    }
}

