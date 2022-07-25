abstract public class BroadcastItem implements BroadcastItemInterface {
    protected double price = 0; //per second
    public int duration = 0;

    abstract public String getName();

    abstract public String getTitle();

    public int getDuration() {
        return duration;
    }

    public double getPrice()
    {
        return price;
    }
    public double getProfit() {
        return getPrice() * getDuration();
    }

    public boolean isPaidContent() {
        return false;
    }
}
