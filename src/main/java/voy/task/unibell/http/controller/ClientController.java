package voy.task.unibell.http.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import voy.task.unibell.model.dto.ClientDto;
import voy.task.unibell.model.entity.Client;
import voy.task.unibell.service.ClientService;
import voy.task.unibell.service.converter.ClientConverter;

import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    private final ClientConverter clientConverter = new ClientConverter();

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(summary = "Get client by its id")
    @GetMapping("/{clientId}")
    public ClientDto getClientById(@Parameter(description = "Id of client to be searched")
                                   @PathVariable Integer clientId) {
        Client c = clientService.findClientById(clientId);
        return clientConverter.toDto(c);
    }

    @Operation(summary = "Save or update client")
    @PostMapping
    public ClientDto save(@RequestBody ClientDto clientDto) {
        Client c = clientConverter.fromDto(clientDto);
        return clientConverter.toDto(clientService.save(c));
    }

    @Operation(summary = "Find all clients in system")
    @GetMapping("/all")
    public Set<ClientDto> getAll() {
        Set<Client> clients = clientService.findAll();
        return clientConverter.toDtos(clients);
    }
}
