package bookstore.models.entities;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    public Users() {
    }

    public Users(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Users(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
