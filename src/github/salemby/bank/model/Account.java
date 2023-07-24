package github.salemby.bank.model;

import github.salemby.bank.model.exception.InsufficientFundsException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Account {

    private Client owner;
    private int agency;
    private int number;
    private BigDecimal funds = BigDecimal.ZERO;
    private BigDecimal annualEarnings;

    Account() {

    }

    public Account(Client owner, int agency, int number) {
        Objects.requireNonNull(owner);
        this.owner = owner;
        this.agency = agency;
        this.number = number;

    }

    public void deposit(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("Enter a valid value");
        }

        funds = funds.add(value);
    }

    public void withdraw(BigDecimal value) {
        if (getAvalibleFunds().subtract(value).compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException("insufficient funds");
        } else if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("Enter a valid value");
        }
        funds = funds.subtract(value);
    }

    public void withdraw(BigDecimal value, BigDecimal withdrawTax) {
        withdraw(value.add(withdrawTax));

    }

    public abstract void debitMensalFees();


    public Client getOwner() {
        return owner;
    }

    public int getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public BigDecimal getAvalibleFunds() {
        return getFunds();
    }

    public BigDecimal getAnnualEarnings() { return annualEarnings; }

    public void setAnnualEarnings(BigDecimal annualEarnings) { this.annualEarnings = annualEarnings; }
}
