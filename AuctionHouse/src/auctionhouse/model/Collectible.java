package auctionhouse.model;

public abstract class Collectible implements Comparable<Collectible>  {
    private String id;
    private String owner;
    private String condition; // "Mint", "Restored", "Needs Restoring"
    private double startingPrice;
    private YearEstimate yearEstimate;

    // Constructor
    public Collectible(String id, String owner, String condition, double startingPrice, int lowEstimate, int highEstimate) {
        this.id = id;
        this.owner = owner;
        setCondition(condition);
        this.startingPrice = startingPrice;
        this.yearEstimate = createYearEstimate(lowEstimate, highEstimate);
    }

    private YearEstimate createYearEstimate(int lowEstimate, int highEstimate) {
        return new YearEstimate(lowEstimate, highEstimate);
    }

    public int compareTo(Collectible other) {
        return this.id.compareTo(other.id);
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        if (!isValidCondition(condition)) {
            throw new IllegalArgumentException("Invalid condition: " + condition);
        }
        this.condition = condition;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public YearEstimate getYearEstimate() {
        return yearEstimate;
    }

    // Abstract method
    public abstract String shortDescription();

    @Override
    public String toString() {
        return "ID: " + id + ", Owner: " + owner + ", Condition: " + condition + ", Starting Price: $" + String.format("%.2f", startingPrice) + ", " + yearEstimate.toString();
    }

    // Static method to validate condition
    public static boolean isValidCondition(String condition) {
        return condition.equalsIgnoreCase("Mint") ||
               condition.equalsIgnoreCase("Restored") ||
               condition.equalsIgnoreCase("Needs Restoring");
    }
}