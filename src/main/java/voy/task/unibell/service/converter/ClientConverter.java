package voy.task.unibell.service.converter;

import voy.task.unibell.model.dto.ClientDto;
import voy.task.unibell.model.entity.Client;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientConverter implements Converter<Client, ClientDto> {

    @Override
    public Client fromDto(ClientDto dto) {
        return new Client(dto.getId(), dto.getName());
    }

    @Override
    public ClientDto toDto(Client entity) {
        return new ClientDto(entity.getId(), entity.getName());
    }

    @Override
    public Set<Client> fromDtos(Collection<ClientDto> dtos) {
        return dtos.stream().map(this::fromDto).collect(Collectors.toSet());
    }

    @Override
    public Set<ClientDto> toDtos(Collection<Client> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toSet());
    }
}
