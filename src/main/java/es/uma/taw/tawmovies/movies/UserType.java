package es.uma.taw.tawmovies.movies;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usertype")
public class UserType {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "user", length = 50)
    private String user;

    @Column(name = "mail", length = 100)
    private String mail;

    @Column(name = "password", length = 100)
    private String password;
    @Column(name = "ID_role", length = 1)
    private Integer idRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }
}