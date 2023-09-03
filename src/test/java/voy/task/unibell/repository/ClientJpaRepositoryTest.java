package voy.task.unibell.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import voy.task.unibell.model.entity.Client;


class ClientJpaRepositoryTest extends AbstractJpaTest {

    @Autowired
    private ClientJpaRepository clientJpaRepository;


    @Test
    public void testSaveClient() {
        Client expected = clientJpaRepository.save(new Client(null, "Test client"));
        Client value = clientJpaRepository.findById(expected.getId()).get();
        Assertions.assertEquals(expected, value);
    }

    @Test
    public void testFindAllClient() {
        clientJpaRepository.save(new Client(null, "Test client 1"));
        clientJpaRepository.save(new Client(null, "Test client 2"));
        Assertions.assertEquals(2, clientJpaRepository.findAll().size());
    }
}