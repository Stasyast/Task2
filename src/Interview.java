public class Interview extends BroadcastItem {

    private final String whoName;

    Interview(int duration, String name)
    {
        this.price = 0.5;
        this.duration = duration;
        this.whoName = name;
    }
    public String getName()
    {
        return whoName;
    }
    public String getTitle()
    {
        return whoName;
    }
    public boolean isPaidContent()
    {
        return true;
    }

}
