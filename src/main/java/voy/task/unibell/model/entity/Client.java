package voy.task.unibell.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    public Client(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public Client() {

    }

    public String getName() {
        return name;
    }
}
