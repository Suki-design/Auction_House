# F20-21SF Coursework Project

> Author: Favour Sukat

## Getting started:
 
- [x] Fork project in personal space
- [x] Clone project on machine
- [x] Create first issue on GitLab
- [x] Edit code to address issue
- [x] Commit by referencing issue number
- [x] Push commits
- [x] Edit README 

Refer to the instructions on published Canvas.

## Stage 1
Core Classes Implementation

### Memorabilia Class
- Represents individual memorabilia items for auction
- Attributes: id, personalityName, personalityOccupation, objectType, isAutographed, estimatedYear, owner, condition, startingPrice
- Implemented with private attributes, getters, and setters (except for id)
- Added a shortDescription() method for concise item representation

### MemorabiliaCollection Class
- Manages a collection of Memorabilia items using ArrayList
- Key methods:
  - addItem(): Adds a Memorabilia item to the collection
  - displayAllItems(): Shows details of all items
  - getNumberOfItems(): Returns the count of items
  - getOldestItem(), getMostExpensiveItem(), getLeastExpensiveItem(): Retrieves specific items
  - getUniqueOwners(): Lists unique owners in the collection

## Stage 2

File I/O and Error Handling

### DataLoader Class
- Responsible for reading CSV files and creating Memorabilia objects
- Implements error handling for missing fields and invalid data
- Uses BufferedReader for efficient line-by-line reading
- Collects and reports errors without crashing the application

### Enhanced MemorabiliaCollection
- Added generateStatisticsSummary() method to create a comprehensive report
- Statistics include:
    - Total number of items
    - Details of oldest, newest, most expensive, and least expensive items
    - Average and standard deviation of starting prices
    - Breakdown of items by condition

### Error Management
- Implemented try-catch blocks for specific error types
- Uses ArrayList to collect all errors from corrupted data files
- Tracks line numbers for precise error reporting
- Handles NumberFormatException and IllegalArgumentException
- Displays detailed error messages to the user after file processing


## Stage 3
Refactoring and Class Hierarchy

**Collectible Class (Abstract Superclass)**

- Introduced as a common structure for various collectible items.

**YearEstimate Class**

- Represents the estimated year range for collectibles,having a composition relationship with the Collectible class.

**Subclass Implementations**

- Developed subclasses: VinylRecord, Toy, Sculpture, and Memorabilia, each with specific attributes and a description method.

**CollectibleCollection Class**

- Renamed from MemorabiliaCollection to manage a collection of Collectible items, with updated methods to support the new hierarchy.

**DataLoader and Creator Classes**

- Refactored DataLoader to support various Collectible subclasses, not just Memorabilia.
- Introduced a Creator class to handle the instantiation of different Collectible subclasses based on data input.

**UML Design**
- Updated the UML class diagram to reflect new structure.
## Stage 4

Design notes...