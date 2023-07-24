package github.salemby.bank.model.payments;

import github.salemby.bank.model.Client;

import java.math.BigDecimal;

public class Salary implements PayableDocument {

    private Client employee;
    private BigDecimal valueHour;
    private BigDecimal hoursWorked;
    private boolean paid;

    public Salary(Client employee, BigDecimal valueHour, BigDecimal hoursWorked) {
        this.employee = employee;
        this.valueHour = valueHour;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public BigDecimal getTotalValue() {
        return valueHour.multiply(hoursWorked);
    }

    @Override
    public boolean isPaid() {
        return paid;
    }

    @Override
    public void payingTotalValue() {
        paid = true;
    }
}
