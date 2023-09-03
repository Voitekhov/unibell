package voy.task.unibell.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import voy.task.unibell.model.entity.Client;
import voy.task.unibell.model.entity.Contact;
import voy.task.unibell.model.entity.ContactType;


class ContactJpaRepositoryTest extends AbstractJpaTest {
    @Autowired
    private ContactJpaRepository contactJpaRepository;

    @Autowired
    private ClientJpaRepository clientJpaRepository;

    private static Integer CLIENT_ID = null;

    @BeforeEach
    void setUp() {
        Client c = clientJpaRepository.save(new Client(CLIENT_ID, "Test client"));
        CLIENT_ID = c.getId();
        contactJpaRepository.save(new Contact(null, "8800555355", ContactType.PHONE, c));
        contactJpaRepository.save(new Contact(null, "8912312312", ContactType.PHONE, c));
        contactJpaRepository.save(new Contact(null, "some@mail", ContactType.EMAIL, c));
        contactJpaRepository.save(new Contact(null, "asd@gmail", ContactType.EMAIL, c));
    }

    @Test
    public void testFindAllByContactType() {
        Integer emailExpected = contactJpaRepository.findAllByContactType(CLIENT_ID, ContactType.EMAIL).size();
        Assertions.assertEquals(2, emailExpected);

        Integer phoneExpected = contactJpaRepository.findAllByContactType(CLIENT_ID, ContactType.PHONE).size();
        Assertions.assertEquals(2, phoneExpected);
    }

    @Test
    public void testFindAllByUserId() {
        Integer actualSize = contactJpaRepository.findAllByClientId(CLIENT_ID).size();
        Assertions.assertEquals(4, actualSize);
    }
}