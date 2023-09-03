package voy.task.unibell.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voy.task.unibell.model.entity.Client;
import voy.task.unibell.model.exception.EntityNotFoundException;
import voy.task.unibell.repository.ClientJpaRepository;

import java.util.Set;

@Service
@Transactional
public class ClientService {

    private final ClientJpaRepository clientJpaRepository;

    public ClientService(ClientJpaRepository clientJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
    }

    public Client findClientById(Integer id) {
        return clientJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public Client save(Client client) {
        return clientJpaRepository.save(client);
    }

    public Set<Client> findAll() {
        return clientJpaRepository.findAllClients();
    }

}
