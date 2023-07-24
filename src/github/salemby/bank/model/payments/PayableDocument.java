package github.salemby.bank.model.payments;

import java.math.BigDecimal;

public interface PayableDocument {

    BigDecimal getTotalValue();
    boolean isPaid();
    void payingTotalValue();
    default void paymentVoucher() {
        System.out.println("Total Value: " + getTotalValue());
        System.out.println("Paid : " + isPaid());
    }


}
