import nextgen.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {
    Register register = new Store().getRegister();

    @Test
    void makeNewSaleTest() {
        List lineItems = register.makeNewSale().lineItems;
        assertTrue(lineItems.isEmpty());
    }

    @Test
    void enterItemTest() {
        ItemID id = new ItemID(300);
        List lineItems = register.makeNewSale().lineItems;
        register.enterItem(id, 10);
        assertEquals(1, lineItems.size());
    }

    @Test
    void endSaleTest() {
        Sale sale = register.makeNewSale();
        register.endSale();
        assertEquals(true, sale.isComplete());
    }

    @Test
    void makePaymentTest(){
        register.makeNewSale();
        Money cashTendered = new Money(10);
        Payment payment = new Payment(cashTendered);
        register.makePayment(cashTendered);
        assertTrue(payment.getAmount() == cashTendered);
    }

    @Test
    void receipt(){
        Sale sale = register.makeNewSale();

        ItemID id1 = new ItemID(100);
        ItemID id2 = new ItemID(200);
        Money price1 = new Money(1000);
        Money price2 = new Money(1000);
        ProductSpecification productSpecification1 = new ProductSpecification(id1, price1, "item1");
        ProductSpecification productSpecification2 = new ProductSpecification(id2, price2, "item2");
        register.enterItem(id1, 10);
        register.enterItem(id2, 10);

        register.endSale();

        Money cashTendered = new Money(30000);
        Payment payment = new Payment(cashTendered);
        register.makePayment(cashTendered);

        System.out.println("-------------------receipt-------------------");
        System.out.println("||   ItemID   ||   ItemName   ||   Price   ||");
        System.out.print("      " + productSpecification1.getItemID());
        System.out.print("           " + productSpecification1.getDescription());
        System.out.println("         " + productSpecification1.getPrice());
        System.out.print("      " + productSpecification2.getItemID());
        System.out.print("           " + productSpecification2.getDescription());
        System.out.println("         " + productSpecification2.getPrice());
        System.out.println("==============================================");

        System.out.print("     Total                       ");
        System.out.println(sale.getTotal());

        System.out.print("     Payment                     ");
        System.out.println(payment.getAmount());

        System.out.print("     Balance                     ");
        System.out.println(sale.getBalance());

    }
}
