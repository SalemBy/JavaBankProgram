package github.salemby.bank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountList {

    private List<Account> accounts = new ArrayList<>();

    public AccountList() {

        Client clientOne = new Client("Jão", "73946293044", ClientType.LEGALPERSON);
        Client clientTwo = new Client("Joana", "47293720534", ClientType.LEGALPERSON);

        Account account1 = new InvestAccount(clientOne, 123, 999);
        Account account2 = new InvestAccount(clientOne, 123, 111);
        Account account3 = new InvestAccount(clientTwo, 123, 222);
        Account account4 = new EspecialAccount(clientTwo, 123,121, new BigDecimal("10000"));
        Account account5 = new EspecialAccount(clientTwo, 123,145, new BigDecimal("2000"));

        account1.deposit(new BigDecimal("500"));
        account2.deposit(new BigDecimal("600"));
        account3.deposit(new BigDecimal("1000"));
        account4.deposit(new BigDecimal("60"));
        account5.deposit(new BigDecimal("20000"));

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);

    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Optional<Account> searchAccount(int agency, int accountNumber) {
        for (Account account : getAccounts()) {
            if (account.getAgency() == agency && account.getNumber() == accountNumber) {
                return  Optional.of(account);
            }
        }
        return Optional.empty();
    }
}
