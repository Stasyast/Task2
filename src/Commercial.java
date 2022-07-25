public class Commercial extends BroadcastItem {
    Product product;

    Commercial(int duration, Product product) {
        this.price = 5.00;
        this.duration = duration;
        this.product = product;
    }

    public String getTitle() {
        return this.getName();
    }

    public String getName() {
        return this.product.getName();
    }

    public boolean isPaidContent() {
        return true;
    }

}
