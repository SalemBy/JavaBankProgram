package github.salemby.bank.app;

import github.salemby.bank.model.Client;
import github.salemby.bank.model.ClientType;

import java.util.HashSet;
import java.util.Set;

public class SecondaryClass {

    public static void main(String[] args) {
        Client firstClient = new Client("Gabriel", "22233344455", ClientType.LEGALPERSON);
        Client secondClient = new Client("Richard", "55544433322", ClientType.PHYSICALPERSON);
        Client thirdClient = new Client("Richard", "55544433322", ClientType.PHYSICALPERSON);

        Set<Client> clients = new HashSet<>();

        clients.add(firstClient);
        clients.add(secondClient);

        boolean isInTheList = clients.contains(thirdClient);
        System.out.println(isInTheList);

        System.out.println(secondClient.equals(thirdClient));

        for (Client client : clients) {
            System.out.println(client);
        }

    }

}
