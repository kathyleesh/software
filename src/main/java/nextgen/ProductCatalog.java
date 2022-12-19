package nextgen;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    private Map productSpecifications = new HashMap();

    public ProductCatalog() {
        ItemID id1 = new ItemID(100);
        ItemID id2 = new ItemID(200);
        Money Price = new Money(1000);

        ProductSpecification ps;
        ps = new ProductSpecification(id1, Price, "product 1");
        productSpecifications.put(id1, ps);
        ps = new ProductSpecification(id2, Price, "product 2");
        productSpecifications.put(id2, ps);
    }

    public ProductSpecification getSpecification(ItemID id){
        return (ProductSpecification) productSpecifications.get(id);
    }
}
