package nextgen;

public class ProductSpecification {
    private ItemID id;
    private Money price;
    private String description;

    public ProductSpecification(ItemID id, Money price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public ItemID getItemID() { return id; }
    public Money getPrice() { return price; }
    public String getDescription() { return description; }
}