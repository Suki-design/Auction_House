public class Memorabilia {
    private String id;
    private String personalityName;
    private String personalityOccupation;
    private String objectType;
    private boolean isAutographed;
    private int estimatedYear;
    private String owner;
    private String condition;
    private double startingPrice;

    //Constructor for the class
    public Memorabilia(String id, String personalityName, String personalityOccupation,
                       String objectType, boolean isAutographed, int estimatedYear,
                       String owner, String condition, double startingPrice) {
        this.id = id;
        this.personalityName = personalityName;
        this.personalityOccupation = personalityOccupation;
        this.objectType = objectType;
        this.isAutographed = isAutographed;
        this.estimatedYear = estimatedYear;
        this.owner = owner;
        this.condition = condition;
        this.startingPrice = startingPrice;
    }

    //Get Methods
    public String getId(){
        return id;
    }

    public String getPersonalityName(){
        return personalityName;
    }

    public String getPersonalityOccupation(){
        return personalityOccupation;
    }

    public String getObjectType(){
        return objectType;
    }

    public boolean isAutographed(){
        return isAutographed;
    }

    public int getEstimatedYear(){
        return estimatedYear;
    }

    public String getOwner(){
        return owner;
    }

    public String getCondition(){
        return condition;
    }

    public double getStartingPrice(){
        return startingPrice;
    }

    //Set Methods
    //Did not create set method for Id to avoid clashes in unique Id values

    public void setPersonalityName(String personalityName) {
        this.personalityName = personalityName;
    }

    public void setPersonalityOccupation(String personalityOccupation) {
        this.personalityOccupation = personalityOccupation;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public void setIsAutographed(boolean isAutographed) {
        this.isAutographed = isAutographed;
    }

    public void setEstimatedYear(int estimatedYear) {
        this.estimatedYear = estimatedYear;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }



}

