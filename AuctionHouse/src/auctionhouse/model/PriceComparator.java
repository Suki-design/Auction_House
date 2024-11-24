package auctionhouse.model;
import java.util.Comparator;

public class PriceComparator implements Comparator<Collectible> {
    //descending sort
    public int compare(Collectible c1, Collectible c2){
        return Double.compare(c2.getStartingPrice(), c1.getStartingPrice());
    }

}
