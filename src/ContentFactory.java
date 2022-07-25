//Singleton pattern + Factory
public class ContentFactory {
    private static ContentFactory instance;
    public static ContentFactory getInstance() {
        if (instance == null) {
            instance = new ContentFactory();
        }

        return instance;
    }

    public Song create(int duration, Singer singer, String name) {
        return new Song(duration, singer, name);
    }

    public Commercial create(int duration, Product product)
    {
        return new Commercial(duration, product);
    }

    public Interview create(int duration, String name) {
        return new Interview(duration, name);
    }
}
