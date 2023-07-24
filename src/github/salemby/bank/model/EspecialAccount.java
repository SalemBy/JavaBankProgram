package github.salemby.bank.model;

import java.math.BigDecimal;

public class EspecialAccount extends Account {

    private BigDecimal limitValue;

    public EspecialAccount(Client owner, int agency, int number, BigDecimal limitValue) {
        super(owner, agency, number);
        this.limitValue = limitValue;
    }

    @Override
    public void debitMensalFees() {
        withdraw(new BigDecimal("30"));
    }

    @Override
    public BigDecimal getAvalibleFunds() {
        return getFunds().add(getLimitValue());
    }

    public BigDecimal getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(BigDecimal limitValue) {
        this.limitValue = limitValue;
    }
}
