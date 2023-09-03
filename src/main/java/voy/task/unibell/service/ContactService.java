package voy.task.unibell.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voy.task.unibell.model.entity.Contact;
import voy.task.unibell.model.entity.ContactType;
import voy.task.unibell.repository.ContactJpaRepository;

import java.util.Set;

@Service
@Transactional
public class ContactService {
    private final ContactJpaRepository contactJpaRepository;

    public ContactService(ContactJpaRepository contactJpaRepository) {
        this.contactJpaRepository = contactJpaRepository;
    }

    public Set<Contact> findAllByClientId(Integer clientId) {
        return contactJpaRepository.findAllByClientId(clientId);
    }

    public Set<Contact> findAllByContactTypeAndClientId(Integer clientId, ContactType contactType) {
        return contactJpaRepository.findAllByContactType(clientId, contactType);
    }

    public Contact save(Contact contact) {
        return contactJpaRepository.save(contact);
    }
}
