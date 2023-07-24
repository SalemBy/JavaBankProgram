package github.salemby.bank.app;

import github.salemby.bank.model.Account;
import github.salemby.bank.model.AccountList;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ThirdClass {
    public static void main(String[] args) {

        AccountList bank = new AccountList();

        bank.getAccounts().sort(Comparator.comparingInt(Account::getNumber));

        for (Account account : bank.getAccounts()) {
            System.out.println(account.getAgency() + "/" + account.getNumber());
        }

    }
}
