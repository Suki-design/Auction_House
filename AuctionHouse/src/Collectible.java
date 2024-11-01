public abstract class Collectible {
    private String id;
    private String owner;
    private String condition; // "Mint", "Restored", "Needs Restoring"
    private double startingPrice;
    private YearEstimate yearEstimate;

    // Constructor
    public Collectible(String id, String owner, String condition, double startingPrice, YearEstimate yearEstimate) {
        this.id = id;
        this.owner = owner;
        this.condition = condition;
        this.startingPrice = startingPrice;
        this.yearEstimate = yearEstimate;
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
}
