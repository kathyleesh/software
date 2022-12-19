package nextgen;

public class SalesLineItem {
    private int quantity;
    private ProductSpecification productSpec;

    public SalesLineItem(ProductSpecification spec, int quantity) {
        this.productSpec = spec;
        this.quantity = quantity;
    }

    public Money getSubtotal() {
        return productSpec.getPrice().times(quantity);
    }
}