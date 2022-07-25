public class Main {
    public static void main(String[] args) {
        Broadcast broadcast = new Broadcast(8);
        ContentFactory factory = ContentFactory.getInstance();

        Singer Johny = new Singer("Johny");
        Song song = factory.create(90, Johny, "Lets go");

        broadcast.add(song);
        broadcast.add(song);

        broadcast.add(factory.create(20, new Product("Mazda")));
        broadcast.add(factory.create(95, Johny, "My life"));
        broadcast.add(factory.create(20, new Product("JetFly")));
        broadcast.add(factory.create(75, "Vasya"));
        broadcast.add(factory.create(20, new Product("Coca")));
        broadcast.add(factory.create(75, "Boris"));
        broadcast.add(factory.create(20, new Product("Pepsi1")));
        broadcast.add(factory.create(95, new Singer("Roy"), "You're pretty woman"));
        broadcast.add(factory.create(10, new Product("Pepsi2")));
        broadcast.add(factory.create(65, Johny, "The end"));
        broadcast.add(factory.create(20, new Product("Pepsi3")));
        broadcast.add(factory.create(20, new Product("Pepsi4")));

        System.out.println("\n--- REPORT ---");
        broadcast.printReport();
        System.out.println("\nDone");
    }
}
