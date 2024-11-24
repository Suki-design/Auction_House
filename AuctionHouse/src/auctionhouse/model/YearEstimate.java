package auctionhouse.model;

public class YearEstimate {
    private int lowEstimate;
    private int highEstimate;

    // Constructor
    YearEstimate(int lowEstimate, int highEstimate) {
        if (lowEstimate > highEstimate) {
            throw new IllegalArgumentException("Low estimate cannot be higher than high estimate.");
        }
        this.lowEstimate = lowEstimate;
        this.highEstimate = highEstimate;
    }

    // Accessors
    public int getLowEstimate() {
        return lowEstimate;
    }

    public int getHighEstimate() {
        return highEstimate;
    }

    //  middle estimate
    public int getMiddleEstimate() {
        return (lowEstimate + highEstimate) / 2;
    }

    @Override
    public String toString() {
        return "Year Estimate: " + getMiddleEstimate();
    }
}
