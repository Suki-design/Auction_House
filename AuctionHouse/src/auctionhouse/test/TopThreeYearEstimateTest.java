package auctionhouse.test;

import auctionhouse.model.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TopThreeYearEstimateTest {

    // Instance variables for test collectibles
    Collectible item1;
    Collectible item2;
    Collectible item3;
    Collectible item4;
    Collectible item5;
    Collectible item6;
    Collectible item7;
    Collectible item8;

    // The collection to test
    CollectibleCollection collection;

    @BeforeEach
    void init() {
        // Initialize the collection
        collection = new CollectibleCollection();
        // Initialize collectibles
        item1 = new Memorabilia("test1", "Owner1", "Mint", 1000.0, 1980, 1990, "test", "test", "test", true); // 1990 - 1980 = 10
        item2 = new Toy("test2", "Owner2", "Restored", 500.0, 1900, 1950, "test", "test",  "test"); //1950-1900=50
        item3 = new VinylRecord("test3", "Owner3", "Needs Restoring", 750.0, 1960, 1965, "test", "test", "test", 12); //1965 - 1960 = 5
        item4 = new Sculpture("test4", "Owner4", "Mint", 2000.0, 1800, 1900, "test", "test", 2.5); //1900-1800=100
        item5 = new Toy("test5", "Owner5", "Mint", 300.0, 2000, 2000, "test", "test", "test"); //2000-2000=0
        item6 = new Memorabilia("test6", "Owner6", "Restored", 1000.0, 1920, 1970, "test", "test", "test", true); //1970-1920= 50
        item7 = new Toy("test7", "Owner7", "Restored", 500.0, 1900, 1950, "test", "test", "test"); //1950-1900=50
        item8 = new VinylRecord("test8", "Owner8", "Needs Restoring", 750.0, 2000, 2010, "test", "test", "test", 12); //2000-2013

        // Clear the collection before each test
        collection.getItems().clear();
    }

    void checkInitStatus() {
        assertTrue(collection.getItems().isEmpty(), "Collection is empty at initialization");
    }

}
