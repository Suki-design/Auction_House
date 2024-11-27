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
    @Test
    @DisplayName(" Testing with 4 items with different year estimate differences")
    void testNormalCase() {
        checkInitStatus();
        collection.addItem(item1); //10
        collection.addItem(item2); //50
        collection.addItem(item3); //5
        collection.addItem(item4); //100
        // put the top 3 in arrayList
        ArrayList<Collectible> topThree = collection.getTopThreeYearEstimateDifferences();
        // what the method should return
        assertEquals(3, topThree.size(), "Top three has 3 items");
        assertEquals(item4, topThree.get(0), "First item is item4 with the largest difference of 100 years");
        assertEquals(item2, topThree.get(1), "Second item is item2 with the second largest difference of 50");
        assertEquals(item1, topThree.get(2), "Third item is item1 with the third largest difference of 5 years");
    }

    @Test
    @DisplayName("Test with ties in year estimate differences")
    void testTies() {
        checkInitStatus();
        collection.addItem(item6); //50
        collection.addItem(item2); //50
        collection.addItem(item3); //5
        collection.addItem(item4); //100
        ArrayList<Collectible> topThree = collection.getTopThreeYearEstimateDifferences();
        assertEquals(3, topThree.size(), "Top three has 3 items");
        assertEquals(item4, topThree.get(0), "First item is item4 with the largest difference of 100 years");
        assertEquals(item2, topThree.get(1), "Second item is item2 with the second largest difference of 50 and with a lower id number");
        assertEquals(item6, topThree.get(2), "Third item is item6 with the third largest difference of 50 years and comes after 2");    }

    @Test
    @DisplayName("Collection having only two collectibles")
    void testTwoItems() {
        checkInitStatus();
        collection.addItem(item1);
        collection.addItem(item2);

        ArrayList<Collectible> topThree = collection.getTopThreeYearEstimateDifferences();
        assertEquals(2, topThree.size(), "Top three should contain 2 items");
        assertEquals(item2, topThree.get(0), "First item is item2 with largest difference of 50 years");
        assertEquals(item1, topThree.get(1), "Second item is item1 with second largest difference of 10 yest");
    }

    @Test
    @DisplayName("Test with an empty collection")
    void testEmptyCollection() {
        checkInitStatus();
        ArrayList<Collectible> topThree = collection.getTopThreeYearEstimateDifferences();

        assertEquals(0, topThree.size(), "Top three is empty");
    }

    @Test
    @DisplayName("Test items with zero difference in year estimates")
    void testZeroDifference() {
        checkInitStatus();

        // Initialize items with zero difference
        item4 = new Sculpture("S001", "Owner4", "Mint", 2000.0, 1800, 1800, "Subject1", "Material1", 2.5);
        item5 = new Toy("T002", "Owner5", "Mint", 300.0, 2000, 2000, "ToyName2", "Doll", "Collection2");

        // Add items to the collection
        collection.addItem(item1); // Difference: 50
        collection.addItem(item4); // Difference: 0
        collection.addItem(item5); // Difference: 0

        // Invoke the method under test
        ArrayList<Collectible> topThree = collection.getTopThreeYearEstimateDifferences();

        // Assertions
        assertEquals(3, topThree.size(), "Top three contains 3 items");
        assertEquals(item1, topThree.get(0), "First item is item1 with the largest difference of 50");
        assertTrue(topThree.contains(item4), "Top three contains item4");
        assertTrue(topThree.contains(item5), "Top three contains item5");
    }

    @Test
    @DisplayName("Test with a single item in collection")
    void testSingleItem() {
        collection.addItem(item1);

        ArrayList<Collectible> topThree = collection.getTopThreeYearEstimateDifferences();

        assertEquals(1, topThree.size(), "Only one item is returned");
        assertEquals(item1, topThree.get(0), "Item One is the item returned");
    }

}
