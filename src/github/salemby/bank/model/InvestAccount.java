package github.salemby.bank.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestAccount extends Account{

    public InvestAccount(Client owner, int agency, int number) {
        super(owner, agency, number);
    }

    @Override
    public void debitMensalFees() {
        if (getFunds().compareTo(new BigDecimal("10000" )) < 0){
            withdraw(new BigDecimal("30"));
        }
    }

    public void depositIncomeCredit(BigDecimal feesPercent) {
        BigDecimal incomeValue = getFunds().multiply(feesPercent)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_EVEN);
        deposit(incomeValue);
    }


}
