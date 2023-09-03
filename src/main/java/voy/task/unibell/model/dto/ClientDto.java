package voy.task.unibell.model.dto;

public class ClientDto {
    private final Integer id;
    private final String name;

    public ClientDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDto() {
        this(null, null);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
