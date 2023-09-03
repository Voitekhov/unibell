package voy.task.unibell.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact extends AbstractEntity {

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "contact_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Contact(Integer id, String value, ContactType contactType, Client client) {
        super(id);
        this.value = value;
        this.contactType = contactType;
        this.client = client;
    }

    public Contact() {

    }

    public String getValue() {
        return value;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public Client getClient() {
        return client;
    }
}
