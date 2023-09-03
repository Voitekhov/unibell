package voy.task.unibell.service.converter;

import org.springframework.stereotype.Component;
import voy.task.unibell.model.dto.ContactDto;
import voy.task.unibell.model.entity.Client;
import voy.task.unibell.model.entity.Contact;
import voy.task.unibell.service.ClientService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ContactConverter implements Converter<Contact, ContactDto> {

    private final ClientService clientService;

    public ContactConverter(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public Contact fromDto(ContactDto dto) {
        Client c = clientService.findClientById(dto.getClientId());
        return fromDto(dto, c);
    }

    private Contact fromDto(ContactDto dto, Client c) {
        return new Contact(dto.getId(), dto.getValue(), dto.getContactType(), c);
    }

    @Override
    public ContactDto toDto(Contact entity) {
        return new ContactDto(entity.getId(), entity.getContactType(), entity.getValue(), entity.getClient().getId());
    }

    @Override
    public Set<Contact> fromDtos(Collection<ContactDto> dtos) {
        Set<Client> clients = clientService.findAll();
        Set<Contact> contacts = new HashSet<>();
        dtos.forEach(d -> {
            Client client = clients.stream().filter(c -> c.getId() == d.getClientId()).findFirst().get();
            contacts.add(fromDto(d, client));
        });
        return contacts;
    }

    @Override
    public Set<ContactDto> toDtos(Collection<Contact> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }
}
