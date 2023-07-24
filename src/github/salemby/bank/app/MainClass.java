package github.salemby.bank.app;

import github.salemby.bank.model.*;
import github.salemby.bank.model.atm.CashMachine;
import github.salemby.bank.model.exception.InsufficientFundsException;
import github.salemby.bank.model.payments.BankBill;
import github.salemby.bank.model.payments.Salary;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MainClass {
    public static void main(String[] args) {

        Client holder1 = new Client();
        InvestAccount myAccount = new InvestAccount(holder1, 123, 1234);
        myAccount.setAnnualEarnings(new BigDecimal("15000"));

        Client holder2 = new Client();
        EspecialAccount yourAccount = new EspecialAccount(holder2, 321, 4321, new BigDecimal("10000"));


        CashMachine atm = new CashMachine();

        holder1.setName("Salem");
        holder1.setDocument("123456789");
        holder1.setType(ClientType.PHYSICALPERSON);
        holder1.setLastUpdate(LocalDateTime.parse("2023-07-23T20:50:00"));
        System.out.println(holder1.getLastUpdate());

        holder2.setName("Pedro");
        holder2.setDocument("987654321");
        holder2.setType(ClientType.LEGALPERSON);

        try {
            myAccount.deposit(new BigDecimal(50000));
            myAccount.withdraw(new BigDecimal("1000"));
            myAccount.depositIncomeCredit(new BigDecimal("0.8"));

            yourAccount.deposit(new BigDecimal("50000"));
            yourAccount.withdraw(new BigDecimal("51000"));

            myAccount.debitMensalFees();
            yourAccount.debitMensalFees();

            BankBill medicalBills = new BankBill(holder2, new BigDecimal("1000"));
            Salary employeeSalary = new Salary(holder1, new BigDecimal("100"), new BigDecimal("40"));

            atm.payingBills(employeeSalary, yourAccount, myAccount);
            atm.payingBills(medicalBills, myAccount, yourAccount);

            atm.ReversiblePaymentDocument(medicalBills, myAccount, yourAccount);

            employeeSalary.paymentVoucher();
            medicalBills.paymentVoucher();
            System.out.println();
        } catch (InsufficientFundsException e) {
            System.out.println("Error to execute operation in account: " + e.getMessage());
        }

        atm.printFunds(myAccount);
        System.out.println();
        atm.printFunds(yourAccount);

    }
}
