package voy.task.unibell.model.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Object id) {
        super(String.format("Entity with %s not found", id));
    }
}
