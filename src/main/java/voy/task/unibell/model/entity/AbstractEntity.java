package voy.task.unibell.model.entity;


import jakarta.persistence.*;

@MappedSuperclass
public class AbstractEntity  {
    @Id
    @SequenceGenerator(name = "entity_id_sequence", sequenceName = "entity_id_sequence", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_id_sequence")
    private Integer id;

    protected AbstractEntity(Integer id) {
        this.id = id;
    }

    protected AbstractEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
