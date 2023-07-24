package github.salemby.bank.app;

import github.salemby.bank.model.Account;
import github.salemby.bank.model.AccountList;

import java.math.BigDecimal;
import java.util.Optional;

public class FifthClass {
    public static void main(String[] args) {

        AccountList bank = new AccountList();


        bank.searchAccount(123, 222).ifPresent(account -> System.out.println(account.getFunds()));

        BigDecimal funds = bank.searchAccount(123, 222)
                .map(Account::getFunds).orElse(BigDecimal.ZERO);

        System.out.println(funds);

    }
}
