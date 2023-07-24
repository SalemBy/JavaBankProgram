package github.salemby.bank.model.atm;

import github.salemby.bank.model.Account;
import github.salemby.bank.model.payments.DocumentWithReversiblePayment;
import github.salemby.bank.model.payments.PayableDocument;

public class CashMachine {
    public void printFunds(Account account) {
        System.out.println("Account: " + account.getAgency() + "/" + account.getNumber());
        System.out.println("Owner: " + account.getOwner().getName());
        System.out.println("Account Type: " + account.getOwner().getType());
        System.out.println("Funds: " + account.getFunds());
        System.out.println("Available Funds: " + account.getAvalibleFunds());
    }

    public void payingBills(PayableDocument document, Account account, Account receiver) {

        if (document.isPaid()) {
            throw new IllegalStateException("Document already ´paid");
        }

        account.withdraw(document.getTotalValue());
        receiver.deposit(document.getTotalValue());
        document.payingTotalValue();
    }

    public void ReversiblePaymentDocument(DocumentWithReversiblePayment document,Account account, Account receiver) {

        if (!document.isPaid()) {
            throw new IllegalStateException("The document it is not paid ");
        }
        document.revertPayment();
        account.deposit(document.getTotalValue());
        receiver.withdraw(document.getTotalValue());


    }




}
