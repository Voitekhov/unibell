package voy.task.unibell.model.dto;

import voy.task.unibell.model.entity.ContactType;

public class ContactDto {

    private final Integer Id;
    private final ContactType contactType;
    private final String value;

    private final Integer clientId;

    public ContactDto(Integer id, ContactType contactType, String value, Integer clientId) {
        Id = id;
        this.contactType = contactType;
        this.value = value;
        this.clientId = clientId;
    }

    public ContactDto() {
        this(null, null, null, null);
    }

    public Integer getId() {
        return Id;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public String getValue() {
        return value;
    }

    public Integer getClientId() {
        return clientId;
    }
}
