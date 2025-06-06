package es.uma.taw.tawmovies.movies;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
public class UserRole {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "rolUser", length = 50)
    private String rolUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolUser() {
        return rolUser;
    }

    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }
}