package voy.task.unibell.service.converter;

import java.util.Collection;

public interface Converter<E, D> {

    E fromDto(D dto);

    D toDto(E entity);

    Collection<E> fromDtos(Collection<D> dtos);

    Collection<D> toDtos(Collection<E> entities);


}
