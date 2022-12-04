package touristAttraction;


public class TouristTicket {
    protected String title;
    protected int period;
    protected int peopleAmount;
    protected boolean hasChild;
    protected boolean hasAnimal;
    protected boolean needNoiseReduction;
    protected boolean includesParty;
    protected String ticketType;
    protected double price;
    protected int hotelRating;
    protected String transportationType;
    protected String mealType;

    public TouristTicket(String title, int period, int peopleAmount, boolean hasChild, boolean hasAnimal,
                         boolean needNoiseReduction, boolean includesParty, String type, double price,
                         int hotelRating, String transportationType, String mealType) {
        this.title = title;
        this.period = period;
        this.peopleAmount = peopleAmount;
        this.hasChild = hasChild;
        this.hasAnimal = hasAnimal;
        this.needNoiseReduction = needNoiseReduction;
        this.includesParty = includesParty;
        this.ticketType = type;
        this.price = price;
        this.hotelRating = hotelRating;
        this.transportationType = transportationType;
        this.mealType = mealType;
    }


    @Override
    public String toString() {
        return String.format("│%15s ││%15s ││%8d ││%11.2f ││%14d│",
                title, ticketType, period, price, hotelRating);
    }

    public int getPeriod() {
        return period;
    }

    public int getPrice() {
        return (int) price;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public String getTitle() {
        return title;
    }

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public boolean isHasAnimal() {
        return hasAnimal;
    }

    public boolean isNeedNoiseReduction() {
        return needNoiseReduction;
    }

    public boolean isIncludesParty() {
        return includesParty;
    }

    public String getTransportationType() {
        return transportationType;
    }

    public String getTicketType() { return ticketType; }

    public String getMealType() { return mealType; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public void setHasAnimal(boolean hasAnimal) {
        this.hasAnimal = hasAnimal;
    }

    public void setNeedNoiseReduction(boolean needNoiseReduction) {
        this.needNoiseReduction = needNoiseReduction;
    }

    public void setIncludesParty(boolean includesParty) {
        this.includesParty = includesParty;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }

    public void setTransportationType(String transportationType) {
        this.transportationType = transportationType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
};