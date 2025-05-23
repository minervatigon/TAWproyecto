package es.uma.taw.tawmovies.movies;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lista")
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "ID")
    private UserType usuario;


    @OneToMany(mappedBy = "idList", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MovieList> movies = new ArrayList<>();


    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UserType getUsuario() {
        return usuario;
    }

    public void setUsuario(UserType usuario) {
        this.usuario = usuario;
    }

    public List<MovieList> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieList> movies) {
        this.movies = movies;
    }
}