import java.util.ArrayList;

public class MemorabiliaCollection {
    private ArrayList<Memorabilia> items;

    //constructor to initialize items
    public MemorabiliaCollection(){
        items = new ArrayList<Memorabilia>();
    }

    public void addItem(Memorabilia item) {
        items.add(item);
    }

    //query methods

    public int getNumberOfItems() {
        return items.size();
    }

    public Memorabilia getOldestItem() {
        if (items.isEmpty()) return null;
        Memorabilia oldest = items.getFirst();
        for (Memorabilia item : items) {
            if (item.getEstimatedYear() < oldest.getEstimatedYear()) {
                oldest = item;
            }
        }
        return oldest;
    }

    public Memorabilia getNewestItem() {
        if (items.isEmpty()) return null;
        Memorabilia newest = items.get(0);
        for (Memorabilia item : items) {
            if (item.getEstimatedYear() > newest.getEstimatedYear()) {
                newest = item;
            }
        }
        return newest;
    }

    public Memorabilia getMostExpensiveItem() {
        if (items.isEmpty()) return null;
        Memorabilia mostExpensive = items.get(0);
        for (Memorabilia item : items) {
            if (item.getStartingPrice() > mostExpensive.getStartingPrice()) {
                mostExpensive = item;
            }
        }
        return mostExpensive;
    }

    public Memorabilia getLeastExpensiveItem() {
        if (items.isEmpty()) return null;
        Memorabilia leastExpensive = items.get(0);
        for (Memorabilia item : items) {
            if (item.getStartingPrice() < leastExpensive.getStartingPrice()) {
                leastExpensive = item;
            }
        }
        return leastExpensive;
    }

    public ArrayList<String> getUniqueOwners() {
        ArrayList<String> owners = new ArrayList<>();
        for (Memorabilia item : items) {
            String owner = item.getOwner();
            if (!owners.contains(owner)) {
                owners.add(owner);
            }
        }
        return owners;
    }
}







}
