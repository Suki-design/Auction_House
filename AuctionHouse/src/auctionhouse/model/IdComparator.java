package auctionhouse.model;
import java.util.Comparator;
public class IdComparator implements Comparator<Collectible>{
    //ascending sort
    public int compare(Collectible c1, Collectible c2){
        return c1.getId().compareTo(c2.getId());
    }
}