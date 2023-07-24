package github.salemby.bank.model.payments;

public interface DocumentWithReversiblePayment extends PayableDocument {

    void revertPayment();
}
