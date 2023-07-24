package github.salemby.bank.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Client {

    private String name;
    private String document;
    private ClientType type = ClientType.PHYSICALPERSON;
    private LocalDateTime lastUpdate = LocalDateTime.now();

    public Client() {

    }

    public Client(String name, String document, ClientType type) {
        this.name = name;
        this.document = document;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(document, client.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document);
    }
}
