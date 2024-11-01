public class YearEstimate {
    private int lowEstimate;
    private int highEstimate;

    // Constructor
    public YearEstimate(int lowEstimate, int highEstimate) {
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
