package github.salemby.bank.app;

import github.salemby.bank.model.Account;
import github.salemby.bank.model.AccountList;
import github.salemby.bank.model.Client;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FourthClass {

    public static void main(String[] args) {
        AccountList bank = new AccountList();

        List<Client> clients = bank.getAccounts().stream().map(Account::getOwner).distinct().toList();
        System.out.println(clients);

        BigDecimal totalFunds = bank.getAccounts().stream().map(Account::getFunds)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(totalFunds);

        bank.getAccounts().stream()
                .filter(account -> account.getFunds().compareTo(new BigDecimal("50")) > 0)
                .filter(account -> account.getNumber() > 50)
                .map(Account::getOwner)
                .distinct()
                .forEach(System.out::println);
    }
}
