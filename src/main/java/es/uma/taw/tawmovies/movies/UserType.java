package es.uma.taw.tawmovies.movies;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usertype")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer userid;

    @Column(name = "user", length = 50)
    private String user;

    @Column(name = "mail", length = 100)
    private String mail;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "ID_role")
    private Integer idRole;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Lista> listas = new ArrayList<>();

    // Getters y Setters
    public Integer getId() {
        return userid;
    }

    public void setId(Integer userid) {
        this.userid = userid;
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

    public List<Lista> getListas() {
        return listas;
    }

    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }

    public void addLista(Lista lista) {
        this.listas.add(lista);
        lista.setUsuario(this);
    }

    public void removeLista(Lista lista) {
        this.listas.remove(lista);
    }
}