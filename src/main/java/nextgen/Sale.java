package nextgen;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Sale {
    public List lineItems = new ArrayList();
    private Date date = new Date();
    private boolean isComplete = false;
    private Payment payment;

    public Money getBalance() { return payment.getAmount().minus(getTotal()); }
    public void becomeComplete() { isComplete = true;}
    public boolean isComplete() { return isComplete; }

    public void makeLineItem(ProductSpecification spec, int quantity) {
        lineItems.add(new SalesLineItem(spec, quantity));
    }

    public Money getTotal() {
        Money total = new Money();
        Iterator i = lineItems.iterator();
        while(i.hasNext()) {
            SalesLineItem sli = (SalesLineItem) i.next();
            total = total.add(sli.getSubtotal());
        }
        return total;
    }

    public void makePayment(Money cashTendered) {
        payment = new Payment(cashTendered);
    }
}


