package github.salemby.bank.model.payments;

import github.salemby.bank.model.Client;

import java.math.BigDecimal;

public class BankBill implements PayableDocument, DocumentWithReversiblePayment {

    private Client receiver;
    private BigDecimal value;
    private boolean paid;

    public BankBill(Client receiver, BigDecimal value) {
        this.receiver = receiver;
        this.value = value;
    }

    @Override
    public BigDecimal getTotalValue() {
        return value;
    }

    @Override
    public boolean isPaid() {
        return paid;
    }

    @Override
    public void revertPayment() {
        paid = false;
    }

    @Override
    public void payingTotalValue() {
        paid = true;
    }
}
