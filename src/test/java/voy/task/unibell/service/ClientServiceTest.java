package voy.task.unibell.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import voy.task.unibell.model.entity.Client;
import voy.task.unibell.model.exception.EntityNotFoundException;
import voy.task.unibell.repository.ClientJpaRepository;

import java.util.Optional;



@SpringBootTest
@ActiveProfiles("test")
class ClientServiceTest {

    @MockBean
    private ClientJpaRepository clientJpaRepository;

    @Autowired
    ClientService clientService;

    @Test
    void testThrowNotFoundExceptionWhenFindClientByNotExistingId() {
        Mockito.when(clientJpaRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class, () -> clientService.findClientById(1));
    }

    @Test
    void testFindClientByExistingId() {
        Client c = new Client(1, "Test client");
        Mockito.when(clientJpaRepository.findById(1)).thenReturn(Optional.of(c));
        Assertions.assertEquals(c, clientService.findClientById(1));
    }
}