package auctionhouse.model;
import java.util.Comparator;

public class YearDifferenceComparator implements Comparator<Collectible> {
    public int compare(Collectible a, Collectible b) {
        //find the difference in Year Estimates for the two items
        YearEstimate aEstimate= a.getYearEstimate();
        YearEstimate bEstimate= b.getYearEstimate();
        int diffA = aEstimate.getHighEstimate() - aEstimate.getLowEstimate();
        int diffB = bEstimate.getHighEstimate() - bEstimate.getLowEstimate();
        if (diffB != diffA) {
            //compare the second to the first difference
            //return -ve if second collectible(b)'s difference is less than first(a), +ve if it is greater than first collectible
            return Integer.compare(diffB, diffA);
        }
        //to handle when they have equal values
        //sort by ID in ascending order to handle the tie
        return a.getId().compareTo(b.getId());
    }
}
