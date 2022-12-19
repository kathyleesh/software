package nextgen;

public class Register {
    private ProductCatalog catalog;
    private Sale sale;

    public Register(ProductCatalog catalog) { this.catalog = catalog; }
    public void endSale() { sale.becomeComplete(); }

    public void enterItem(ItemID id, int quantity) {
        ProductSpecification spec = catalog.getSpecification(id);
        sale.makeLineItem(spec, quantity);
    }

    public Sale makeNewSale() {
        sale = new Sale();
        return sale;
    }

    public void makePayment(Money cashTendered) { sale.makePayment(cashTendered); }
}