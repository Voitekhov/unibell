package voy.task.unibell.http.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import voy.task.unibell.model.dto.ContactDto;
import voy.task.unibell.model.entity.Contact;
import voy.task.unibell.model.entity.ContactType;
import voy.task.unibell.service.ContactService;
import voy.task.unibell.service.converter.ContactConverter;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/contact")
public class ContactsController {

    private final ContactService contactService;

    private final ContactConverter contactConverter;

    public ContactsController(ContactService contactService, ContactConverter contactConverter) {
        this.contactService = contactService;
        this.contactConverter = contactConverter;
    }

    @Operation(summary = "Get all client contacts by its id")
    @GetMapping("/all")
    public Collection<ContactDto> getAll(@RequestParam("clientId") Integer clientId) {
        Set<Contact> contacts = contactService.findAllByClientId(clientId);
        return contactConverter.toDtos(contacts);
    }

    @Operation(summary = "Get all client contacts by client id and contact type")
    @GetMapping("/all-with-filtration")
    public Collection<ContactDto> getAll(@RequestParam("clientId") Integer clientId,
                                         @Parameter(description = "Contact type ident (PHONE or EMAIL)")
                                         @RequestParam("contactType") ContactType contactType) {
        Set<Contact> contacts = contactService.findAllByContactTypeAndClientId(clientId, contactType);
        return contactConverter.toDtos(contacts);
    }

    @Operation(summary = "Save or update client contact")
    @PostMapping()
    public ContactDto save(@RequestBody ContactDto contactDto) {
        Contact contact = contactConverter.fromDto(contactDto);
        return contactConverter.toDto(contactService.save(contact));
    }

}
