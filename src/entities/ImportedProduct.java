package entities;

public final class ImportedProduct extends Product {

    private final Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        return getName() + " $ " + String.format("%.2f", totalPrice()) + " (Customs fee: $ " + String.format("%.2f", customsFee) + ")";
    }

    public double totalPrice() {
        return getPrice() + customsFee;
    }
}
