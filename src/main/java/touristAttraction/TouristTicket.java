package touristAttraction;


public class TouristTicket {
    public int ticketId;
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

    public TouristTicket(int ticketId, String title, int period, int peopleAmount, boolean hasChild, boolean hasAnimal,
                         boolean needNoiseReduction, boolean includesParty, String type, double price,
                         int hotelRating, String transportationType, String mealType) {
        this.ticketId = ticketId;
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

    public String getTitle() {
        return title;
    }
};